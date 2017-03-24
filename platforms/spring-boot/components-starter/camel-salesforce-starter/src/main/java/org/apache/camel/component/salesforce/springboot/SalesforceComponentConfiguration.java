/**
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
package org.apache.camel.component.salesforce.springboot;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.component.salesforce.AuthenticationType;
import org.apache.camel.component.salesforce.SalesforceHttpClient;
import org.apache.camel.component.salesforce.api.dto.analytics.reports.ReportMetadata;
import org.apache.camel.component.salesforce.api.dto.approval.ApprovalRequest;
import org.apache.camel.component.salesforce.api.dto.approval.ApprovalRequest.Action;
import org.apache.camel.component.salesforce.api.dto.bulk.ContentType;
import org.apache.camel.component.salesforce.internal.PayloadFormat;
import org.apache.camel.component.salesforce.internal.dto.NotifyForFieldsEnum;
import org.apache.camel.component.salesforce.internal.dto.NotifyForOperationsEnum;
import org.apache.camel.util.jsse.KeyStoreParameters;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * The salesforce component is used for integrating Camel with the massive
 * Salesforce API.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.salesforce")
public class SalesforceComponentConfiguration {

    /**
     * Explicit authentication type to be used one of USERNAME_PASSWORD
     * REFRESH_TOKEN or JWT.
     */
    private AuthenticationType authenticationType;
    /**
     * To use the shared SalesforceLoginConfig as login configuration
     */
    private SalesforceLoginConfigNestedConfiguration loginConfig;
    /**
     * Salesforce login URL defaults to https://login.salesforce.com
     */
    private String loginUrl = "https://login.salesforce.com";
    /**
     * Salesforce connected application Consumer Key
     */
    private String clientId;
    /**
     * Salesforce connected application Consumer Secret
     */
    private String clientSecret;
    /**
     * KeyStoreParameters to use in OAuth 2.0 JWT Bearer Token Flow.
     */
    @NestedConfigurationProperty
    private KeyStoreParameters keystore;
    /**
     * Salesforce connected application Consumer token
     */
    private String refreshToken;
    /**
     * Salesforce account user name
     */
    private String userName;
    /**
     * Salesforce account password
     */
    private String password;
    /**
     * Flag to enable/disable lazy OAuth default is false. When enabled OAuth
     * token retrieval or generation is not done until the first API call
     */
    private Boolean lazyLogin = false;
    /**
     * To use the shared SalesforceEndpointConfig as endpoint configuration
     */
    private SalesforceEndpointConfigNestedConfiguration config;
    /**
     * Used for configuring HTTP client properties as key/value pairs
     */
    private Map<String, Object> httpClientProperties;
    /**
     * To configure security using SSLContextParameters
     */
    @NestedConfigurationProperty
    private SSLContextParameters sslContextParameters;
    /**
     * To configure HTTP proxy host
     */
    private String httpProxyHost;
    /**
     * To configure HTTP proxy port
     */
    private Integer httpProxyPort;
    /**
     * To configure HTTP proxy username
     */
    private String httpProxyUsername;
    /**
     * To configure HTTP proxy password
     */
    private String httpProxyPassword;
    /**
     * Enable for Socks4 proxy false by default
     */
    private Boolean isHttpProxySocks4 = false;
    /**
     * Enable for TLS connections true by default
     */
    private Boolean isHttpProxySecure = false;
    /**
     * HTTP proxy included addresses
     */
    private Set<String> httpProxyIncludedAddresses;
    /**
     * HTTP proxy excluded addresses
     */
    private Set<String> httpProxyExcludedAddresses;
    /**
     * HTTP proxy authentication URI
     */
    private String httpProxyAuthUri;
    /**
     * HTTP proxy authentication realm
     */
    private String httpProxyRealm;
    /**
     * Use HTTP proxy Digest authentication false by default
     */
    private Boolean httpProxyUseDigestAuth = false;
    /**
     * Package names to scan for DTO classes (multiple packages can be separated
     * by comma).
     */
    private String[] packages;
    /**
     * Whether the component should resolve property placeholders on itself when
     * starting. Only properties which are of String type can use property
     * placeholders.
     */
    private Boolean resolvePropertyPlaceholders = true;

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public SalesforceLoginConfigNestedConfiguration getLoginConfig() {
        return loginConfig;
    }

    public void setLoginConfig(
            SalesforceLoginConfigNestedConfiguration loginConfig) {
        this.loginConfig = loginConfig;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public KeyStoreParameters getKeystore() {
        return keystore;
    }

    public void setKeystore(KeyStoreParameters keystore) {
        this.keystore = keystore;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLazyLogin() {
        return lazyLogin;
    }

    public void setLazyLogin(Boolean lazyLogin) {
        this.lazyLogin = lazyLogin;
    }

    public SalesforceEndpointConfigNestedConfiguration getConfig() {
        return config;
    }

    public void setConfig(SalesforceEndpointConfigNestedConfiguration config) {
        this.config = config;
    }

    public Map<String, Object> getHttpClientProperties() {
        return httpClientProperties;
    }

    public void setHttpClientProperties(Map<String, Object> httpClientProperties) {
        this.httpClientProperties = httpClientProperties;
    }

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public String getHttpProxyHost() {
        return httpProxyHost;
    }

    public void setHttpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    public Integer getHttpProxyPort() {
        return httpProxyPort;
    }

    public void setHttpProxyPort(Integer httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }

    public String getHttpProxyUsername() {
        return httpProxyUsername;
    }

    public void setHttpProxyUsername(String httpProxyUsername) {
        this.httpProxyUsername = httpProxyUsername;
    }

    public String getHttpProxyPassword() {
        return httpProxyPassword;
    }

    public void setHttpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
    }

    public Boolean getIsHttpProxySocks4() {
        return isHttpProxySocks4;
    }

    public void setIsHttpProxySocks4(Boolean isHttpProxySocks4) {
        this.isHttpProxySocks4 = isHttpProxySocks4;
    }

    public Boolean getIsHttpProxySecure() {
        return isHttpProxySecure;
    }

    public void setIsHttpProxySecure(Boolean isHttpProxySecure) {
        this.isHttpProxySecure = isHttpProxySecure;
    }

    public Set<String> getHttpProxyIncludedAddresses() {
        return httpProxyIncludedAddresses;
    }

    public void setHttpProxyIncludedAddresses(
            Set<String> httpProxyIncludedAddresses) {
        this.httpProxyIncludedAddresses = httpProxyIncludedAddresses;
    }

    public Set<String> getHttpProxyExcludedAddresses() {
        return httpProxyExcludedAddresses;
    }

    public void setHttpProxyExcludedAddresses(
            Set<String> httpProxyExcludedAddresses) {
        this.httpProxyExcludedAddresses = httpProxyExcludedAddresses;
    }

    public String getHttpProxyAuthUri() {
        return httpProxyAuthUri;
    }

    public void setHttpProxyAuthUri(String httpProxyAuthUri) {
        this.httpProxyAuthUri = httpProxyAuthUri;
    }

    public String getHttpProxyRealm() {
        return httpProxyRealm;
    }

    public void setHttpProxyRealm(String httpProxyRealm) {
        this.httpProxyRealm = httpProxyRealm;
    }

    public Boolean getHttpProxyUseDigestAuth() {
        return httpProxyUseDigestAuth;
    }

    public void setHttpProxyUseDigestAuth(Boolean httpProxyUseDigestAuth) {
        this.httpProxyUseDigestAuth = httpProxyUseDigestAuth;
    }

    public String[] getPackages() {
        return packages;
    }

    public void setPackages(String[] packages) {
        this.packages = packages;
    }

    public Boolean getResolvePropertyPlaceholders() {
        return resolvePropertyPlaceholders;
    }

    public void setResolvePropertyPlaceholders(
            Boolean resolvePropertyPlaceholders) {
        this.resolvePropertyPlaceholders = resolvePropertyPlaceholders;
    }

    public static class SalesforceLoginConfigNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.salesforce.SalesforceLoginConfig.class;
        /**
         * Salesforce login URL, defaults to https://login.salesforce.com
         */
        private String loginUrl;
        /**
         * Salesforce connected application Consumer Key
         */
        private String clientId;
        /**
         * Salesforce connected application Consumer Secret
         */
        private String clientSecret;
        /**
         * Keystore parameters for keystore containing certificate and private
         * key needed for OAuth 2.0 JWT Bearer Token Flow.
         */
        @NestedConfigurationProperty
        private KeyStoreParameters keystore;
        /**
         * Salesforce connected application Consumer token
         */
        private String refreshToken;
        private AuthenticationType type;
        /**
         * Salesforce account user name
         */
        private String userName;
        /**
         * Salesforce account password
         */
        private String password;
        /**
         * Flag to enable/disable lazy OAuth, default is false. When enabled,
         * OAuth token retrieval or generation is not done until the first API
         * call
         */
        private Boolean lazyLogin;

        public String getLoginUrl() {
            return loginUrl;
        }

        public void setLoginUrl(String loginUrl) {
            this.loginUrl = loginUrl;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

        public KeyStoreParameters getKeystore() {
            return keystore;
        }

        public void setKeystore(KeyStoreParameters keystore) {
            this.keystore = keystore;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public AuthenticationType getType() {
            return type;
        }

        public void setType(AuthenticationType type) {
            this.type = type;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getLazyLogin() {
            return lazyLogin;
        }

        public void setLazyLogin(Boolean lazyLogin) {
            this.lazyLogin = lazyLogin;
        }
    }

    public static class SalesforceEndpointConfigNestedConfiguration {
        public static final Class CAMEL_NESTED_CLASS = org.apache.camel.component.salesforce.SalesforceEndpointConfig.class;
        /**
         * Payload format to use for Salesforce API calls, either JSON or XML,
         * defaults to JSON
         */
        private PayloadFormat format;
        /**
         * Salesforce API version, defaults to
         * SalesforceEndpointConfig.DEFAULT_VERSION
         */
        private String apiVersion;
        /**
         * SObject name if required or supported by API
         */
        private String sObjectName;
        /**
         * SObject ID if required by API
         */
        private String sObjectId;
        /**
         * SObject fields to retrieve
         */
        private String sObjectFields;
        /**
         * SObject external ID field name
         */
        private String sObjectIdName;
        /**
         * SObject external ID field value
         */
        private String sObjectIdValue;
        /**
         * SObject blob field name
         */
        private String sObjectBlobFieldName;
        /**
         * Fully qualified SObject class name, usually generated using
         * camel-salesforce-maven-plugin
         */
        private String sObjectClass;
        /**
         * Salesforce SOQL query string
         */
        private String sObjectQuery;
        /**
         * Salesforce SOSL search string
         */
        private String sObjectSearch;
        /**
         * APEX method name
         */
        private String apexMethod;
        /**
         * APEX method URL
         */
        private String apexUrl;
        /**
         * Query params for APEX method
         */
        private Map apexQueryParams;
        /**
         * The approval request for Approval API.
         * 
         * @param approval
         */
        @NestedConfigurationProperty
        private ApprovalRequest approval;
        /**
         * Bulk API content type, one of XML, CSV, ZIP_XML, ZIP_CSV
         */
        private ContentType contentType;
        /**
         * Bulk API Job ID
         */
        private String jobId;
        /**
         * Bulk API Batch ID
         */
        private String batchId;
        /**
         * Bulk API Result ID
         */
        private String resultId;
        /**
         * Whether to update an existing Push Topic when using the Streaming
         * API, defaults to false
         */
        private Boolean updateTopic = false;
        /**
         * Notify for fields, options are ALL, REFERENCED, SELECT, WHERE
         */
        private NotifyForFieldsEnum notifyForFields;
        /**
         * Notify for operations, options are ALL, CREATE, EXTENDED, UPDATE (API
         * version < 29.0)
         */
        private NotifyForOperationsEnum notifyForOperations;
        /**
         * Notify for create operation, defaults to false (API version >= 29.0)
         */
        private Boolean notifyForOperationCreate;
        /**
         * Notify for update operation, defaults to false (API version >= 29.0)
         */
        private Boolean notifyForOperationUpdate;
        /**
         * Notify for delete operation, defaults to false (API version >= 29.0)
         */
        private Boolean notifyForOperationDelete;
        /**
         * Notify for un-delete operation, defaults to false (API version >=
         * 29.0)
         */
        private Boolean notifyForOperationUndelete;
        /**
         * Salesforce1 Analytics report Id
         */
        private String reportId;
        /**
         * Include details in Salesforce1 Analytics report, defaults to false.
         */
        private Boolean includeDetails;
        /**
         * Salesforce1 Analytics report metadata for filtering
         */
        @NestedConfigurationProperty
        private ReportMetadata reportMetadata;
        /**
         * Salesforce1 Analytics report execution instance ID
         */
        private String instanceId;
        /**
         * Custom Jetty Http Client to use to connect to Salesforce.
         */
        @NestedConfigurationProperty
        private SalesforceHttpClient httpClient;
        /**
         * Custom Jackson ObjectMapper to use when serializing/deserializing
         * Salesforce objects.
         */
        @NestedConfigurationProperty
        private ObjectMapper objectMapper;
        /**
         * Backoff interval increment for Streaming connection restart attempts
         * for failures beyond CometD auto-reconnect.
         */
        private Long backoffIncrement;
        /**
         * Maximum backoff interval for Streaming connection restart attempts
         * for failures beyond CometD auto-reconnect.
         */
        private Long maxBackoff;
        /**
         * Default replayId setting if no value is found in
         * {@link #initialReplayIdMap}
         * 
         * @param defaultReplayId
         */
        private Long defaultReplayId;
        /**
         * Replay IDs to start from per channel name.
         */
        private Map initialReplayIdMap;
        /**
         * Limit on number of returned records. Applicable to some of the API,
         * check the Salesforce documentation.
         * 
         * @param limit
         */
        private Integer limit;
        /**
         * Represents the kind of action to take: Submit, Approve, or Reject.
         * 
         * @param actionType
         */
        private Action approvalActionType;
        /**
         * The comment to add to the history step associated with this request.
         * 
         * @param comments
         */
        private String approvalComments;
        /**
         * The ID of the submitter who’s requesting the approval record.
         * 
         * @param contextActorId
         */
        private String approvalContextActorId;
        /**
         * The ID of the item that is being acted upon.
         * 
         * @param contextId
         */
        private String approvalContextId;
        /**
         * If the process requires specification of the next approval, the ID of
         * the user to be assigned the next request.
         * 
         * @param nextApproverIds
         */
        private List approvalNextApproverIds;
        /**
         * The developer name or ID of the process definition.
         * 
         * @param processDefinitionNameOrId
         */
        private String approvalProcessDefinitionNameOrId;
        /**
         * Determines whether to evaluate the entry criteria for the process
         * (true) or not (false) if the process definition name or ID isn’t
         * null. If the process definition name or ID isn’t specified, this
         * argument is ignored, and standard evaluation is followed based on
         * process order. By default, the entry criteria isn’t skipped if it’s
         * not set by this request.
         * 
         * @param skipEntryCriteria
         */
        private Boolean approvalSkipEntryCriteria;

        public PayloadFormat getFormat() {
            return format;
        }

        public void setFormat(PayloadFormat format) {
            this.format = format;
        }

        public String getApiVersion() {
            return apiVersion;
        }

        public void setApiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
        }

        public String getSObjectName() {
            return sObjectName;
        }

        public void setSObjectName(String sObjectName) {
            this.sObjectName = sObjectName;
        }

        public String getSObjectId() {
            return sObjectId;
        }

        public void setSObjectId(String sObjectId) {
            this.sObjectId = sObjectId;
        }

        public String getSObjectFields() {
            return sObjectFields;
        }

        public void setSObjectFields(String sObjectFields) {
            this.sObjectFields = sObjectFields;
        }

        public String getSObjectIdName() {
            return sObjectIdName;
        }

        public void setSObjectIdName(String sObjectIdName) {
            this.sObjectIdName = sObjectIdName;
        }

        public String getSObjectIdValue() {
            return sObjectIdValue;
        }

        public void setSObjectIdValue(String sObjectIdValue) {
            this.sObjectIdValue = sObjectIdValue;
        }

        public String getSObjectBlobFieldName() {
            return sObjectBlobFieldName;
        }

        public void setSObjectBlobFieldName(String sObjectBlobFieldName) {
            this.sObjectBlobFieldName = sObjectBlobFieldName;
        }

        public String getSObjectClass() {
            return sObjectClass;
        }

        public void setSObjectClass(String sObjectClass) {
            this.sObjectClass = sObjectClass;
        }

        public String getSObjectQuery() {
            return sObjectQuery;
        }

        public void setSObjectQuery(String sObjectQuery) {
            this.sObjectQuery = sObjectQuery;
        }

        public String getSObjectSearch() {
            return sObjectSearch;
        }

        public void setSObjectSearch(String sObjectSearch) {
            this.sObjectSearch = sObjectSearch;
        }

        public String getApexMethod() {
            return apexMethod;
        }

        public void setApexMethod(String apexMethod) {
            this.apexMethod = apexMethod;
        }

        public String getApexUrl() {
            return apexUrl;
        }

        public void setApexUrl(String apexUrl) {
            this.apexUrl = apexUrl;
        }

        public Map getApexQueryParams() {
            return apexQueryParams;
        }

        public void setApexQueryParams(Map apexQueryParams) {
            this.apexQueryParams = apexQueryParams;
        }

        public ApprovalRequest getApproval() {
            return approval;
        }

        public void setApproval(ApprovalRequest approval) {
            this.approval = approval;
        }

        public ContentType getContentType() {
            return contentType;
        }

        public void setContentType(ContentType contentType) {
            this.contentType = contentType;
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getResultId() {
            return resultId;
        }

        public void setResultId(String resultId) {
            this.resultId = resultId;
        }

        public Boolean getUpdateTopic() {
            return updateTopic;
        }

        public void setUpdateTopic(Boolean updateTopic) {
            this.updateTopic = updateTopic;
        }

        public NotifyForFieldsEnum getNotifyForFields() {
            return notifyForFields;
        }

        public void setNotifyForFields(NotifyForFieldsEnum notifyForFields) {
            this.notifyForFields = notifyForFields;
        }

        public NotifyForOperationsEnum getNotifyForOperations() {
            return notifyForOperations;
        }

        public void setNotifyForOperations(
                NotifyForOperationsEnum notifyForOperations) {
            this.notifyForOperations = notifyForOperations;
        }

        public Boolean getNotifyForOperationCreate() {
            return notifyForOperationCreate;
        }

        public void setNotifyForOperationCreate(Boolean notifyForOperationCreate) {
            this.notifyForOperationCreate = notifyForOperationCreate;
        }

        public Boolean getNotifyForOperationUpdate() {
            return notifyForOperationUpdate;
        }

        public void setNotifyForOperationUpdate(Boolean notifyForOperationUpdate) {
            this.notifyForOperationUpdate = notifyForOperationUpdate;
        }

        public Boolean getNotifyForOperationDelete() {
            return notifyForOperationDelete;
        }

        public void setNotifyForOperationDelete(Boolean notifyForOperationDelete) {
            this.notifyForOperationDelete = notifyForOperationDelete;
        }

        public Boolean getNotifyForOperationUndelete() {
            return notifyForOperationUndelete;
        }

        public void setNotifyForOperationUndelete(
                Boolean notifyForOperationUndelete) {
            this.notifyForOperationUndelete = notifyForOperationUndelete;
        }

        public String getReportId() {
            return reportId;
        }

        public void setReportId(String reportId) {
            this.reportId = reportId;
        }

        public Boolean getIncludeDetails() {
            return includeDetails;
        }

        public void setIncludeDetails(Boolean includeDetails) {
            this.includeDetails = includeDetails;
        }

        public ReportMetadata getReportMetadata() {
            return reportMetadata;
        }

        public void setReportMetadata(ReportMetadata reportMetadata) {
            this.reportMetadata = reportMetadata;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public SalesforceHttpClient getHttpClient() {
            return httpClient;
        }

        public void setHttpClient(SalesforceHttpClient httpClient) {
            this.httpClient = httpClient;
        }

        public ObjectMapper getObjectMapper() {
            return objectMapper;
        }

        public void setObjectMapper(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        public Long getBackoffIncrement() {
            return backoffIncrement;
        }

        public void setBackoffIncrement(Long backoffIncrement) {
            this.backoffIncrement = backoffIncrement;
        }

        public Long getMaxBackoff() {
            return maxBackoff;
        }

        public void setMaxBackoff(Long maxBackoff) {
            this.maxBackoff = maxBackoff;
        }

        public Long getDefaultReplayId() {
            return defaultReplayId;
        }

        public void setDefaultReplayId(Long defaultReplayId) {
            this.defaultReplayId = defaultReplayId;
        }

        public Map getInitialReplayIdMap() {
            return initialReplayIdMap;
        }

        public void setInitialReplayIdMap(Map initialReplayIdMap) {
            this.initialReplayIdMap = initialReplayIdMap;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Action getApprovalActionType() {
            return approvalActionType;
        }

        public void setApprovalActionType(Action approvalActionType) {
            this.approvalActionType = approvalActionType;
        }

        public String getApprovalComments() {
            return approvalComments;
        }

        public void setApprovalComments(String approvalComments) {
            this.approvalComments = approvalComments;
        }

        public String getApprovalContextActorId() {
            return approvalContextActorId;
        }

        public void setApprovalContextActorId(String approvalContextActorId) {
            this.approvalContextActorId = approvalContextActorId;
        }

        public String getApprovalContextId() {
            return approvalContextId;
        }

        public void setApprovalContextId(String approvalContextId) {
            this.approvalContextId = approvalContextId;
        }

        public List getApprovalNextApproverIds() {
            return approvalNextApproverIds;
        }

        public void setApprovalNextApproverIds(List approvalNextApproverIds) {
            this.approvalNextApproverIds = approvalNextApproverIds;
        }

        public String getApprovalProcessDefinitionNameOrId() {
            return approvalProcessDefinitionNameOrId;
        }

        public void setApprovalProcessDefinitionNameOrId(
                String approvalProcessDefinitionNameOrId) {
            this.approvalProcessDefinitionNameOrId = approvalProcessDefinitionNameOrId;
        }

        public Boolean getApprovalSkipEntryCriteria() {
            return approvalSkipEntryCriteria;
        }

        public void setApprovalSkipEntryCriteria(
                Boolean approvalSkipEntryCriteria) {
            this.approvalSkipEntryCriteria = approvalSkipEntryCriteria;
        }
    }
}