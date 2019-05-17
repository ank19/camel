/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.fhir;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceGoneException;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.support.IntrospectionSupport;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Patient;
import org.junit.Before;

/**
 * Abstract base class for Fhir Integration tests generated by Camel API component maven plugin.
 */
public abstract class AbstractFhirTestSupport extends CamelTestSupport {

    private static final String TEST_OPTIONS_PROPERTIES = "/test-options.properties";
    private static final ThreadLocal<FhirContext> FHIR_CONTEXT_THREAD_LOCAL =  new ThreadLocal<>();
    private static final ThreadLocal<IGenericClient> GENERIC_CLIENT_THREAD_LOCAL = new ThreadLocal<>();
    protected Patient patient;
    FhirContext fhirContext;
    IGenericClient fhirClient;

    @Before
    public void cleanFhirServerState() {
        if (patientExists()) {
            deletePatient();
        }
        createPatient();
    }

    boolean patientExists() {
        try {
            Bundle bundle = fhirClient.search().byUrl("Patient?given=Vincent&family=Freeman").returnBundle(Bundle.class).execute();
            return !bundle.getEntry().isEmpty();
        } catch (ResourceGoneException e) {
            return false;
        }
    }

    private void deletePatient() {
        fhirClient.delete().resourceConditionalByUrl("Patient?given=Vincent&family=Freeman").execute();
    }

    private void createPatient() {
        this.patient = new Patient().addName(new HumanName().addGiven("Vincent").setFamily("Freeman")).setActive(false);
        this.patient.setId(fhirClient.create().resource(patient).execute().getId());
    }


    @Override
    protected CamelContext createCamelContext() throws Exception {

        final CamelContext context = super.createCamelContext();

        // read Fhir component configuration from TEST_OPTIONS_PROPERTIES
        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(TEST_OPTIONS_PROPERTIES));
        } catch (Exception e) {
            throw new IOException(String.format("%s could not be loaded: %s", TEST_OPTIONS_PROPERTIES, e.getMessage()),
                e);
        }

        Map<String, Object> options = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            options.put(entry.getKey().toString(), entry.getValue());
        }

        FhirVersionEnum version = FhirVersionEnum.valueOf((String) options.get("fhirVersion"));
        this.fhirContext = new FhirContext(version);
        FHIR_CONTEXT_THREAD_LOCAL.set(this.fhirContext);
        this.fhirClient = this.fhirContext.newRestfulGenericClient((String) options.get("serverUrl"));
        GENERIC_CLIENT_THREAD_LOCAL.set(this.fhirClient);
        final FhirConfiguration configuration = new FhirConfiguration();
        IntrospectionSupport.setProperties(configuration, options);
        configuration.setFhirContext(this.fhirContext);

        // add FhirComponent to Camel context
        final FhirComponent component = new FhirComponent(context);
        component.setConfiguration(configuration);
        context.addComponent("fhir", component);
        return context;
    }

    @Override
    protected void postProcessTest() throws Exception {
        super.postProcessTest();
        this.fhirContext = FHIR_CONTEXT_THREAD_LOCAL.get();
        this.fhirClient = GENERIC_CLIENT_THREAD_LOCAL.get();
    }

    @Override
    public boolean isCreateCamelContextPerClass() {
        // only create the context once for this class
        return true;
    }

    @SuppressWarnings("unchecked")
    <T> T requestBodyAndHeaders(String endpointUri, Object body, Map<String, Object> headers)
        throws CamelExecutionException {
        return (T) template().requestBodyAndHeaders(endpointUri, body, headers);
    }

    @SuppressWarnings("unchecked")
    <T> T requestBody(String endpoint, Object body) throws CamelExecutionException {
        return (T) template().requestBody(endpoint, body);
    }
}