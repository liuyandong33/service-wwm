package build.dream.wwm.utils;

import build.dream.wwm.api.ApiRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

public abstract class MicroServiceCaller {
    protected abstract RestTemplate obtainRestTemplate();

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public String doGetOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public String doGetOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public String doPostOriginalWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public String doPostOriginalWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public String doPostOriginalWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildMultipartHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public String doPostOriginalWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildMultipartHttpEntity(requestParameters), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, queryParams), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public String doPostOriginalWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return obtainRestTemplate().postForObject(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, queryParams), ProxyUtils.buildApplicationJsonUtf8HttpEntity(requestBody), String.class);
    }

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ApiRest doGetWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ApiRest doGetWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doGetOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ApiRest doPostWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ApiRest doPostWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return ApiRest.fromJson(doPostOriginalWithRequestParameters(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务，可以上传文件
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public ApiRest doPostWithRequestParametersAndFiles(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(partitionCode, serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用公共服务，可以上传文件
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     * @throws IOException
     */
    public ApiRest doPostWithRequestParametersAndFiles(String serviceName, String controllerName, String actionName, Map<String, Object> requestParameters) throws IOException {
        return ApiRest.fromJson(doPostOriginalWithRequestParametersAndFiles(serviceName, controllerName, actionName, requestParameters));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithFormRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithFormRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithFormRequestBody(serviceName, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(serviceName, serviceName, controllerName, actionName, requestBody));
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithJsonRequestBody(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(partitionCode, serviceName, controllerName, actionName, queryParams, requestBody));
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param queryParams
     * @param requestBody
     * @return
     */
    public ApiRest doPostWithJsonRequestBody(String serviceName, String controllerName, String actionName, Map<String, String> queryParams, String requestBody) {
        return ApiRest.fromJson(doPostOriginalWithJsonRequestBody(serviceName, serviceName, controllerName, actionName, queryParams, requestBody));
    }

    /**
     * GET 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    /**
     * GET 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().getForEntity(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName, requestParameters), byte[].class);
    }

    /**
     * POST 请求调用分区服务
     *
     * @param partitionCode
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(ProxyUtils.obtainUrl(partitionCode, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
    }

    /**
     * POST 请求调用公共服务
     *
     * @param serviceName
     * @param controllerName
     * @param actionName
     * @param requestParameters
     * @return
     */
    public ResponseEntity<byte[]> doPostOrdinaryWithRequestParameters(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return obtainRestTemplate().postForEntity(ProxyUtils.obtainUrl(null, serviceName, controllerName, actionName), ProxyUtils.buildApplicationFormUrlEncodedHttpEntity(requestParameters), byte[].class);
    }

    /**
     * GET 请求指定url
     *
     * @param url
     * @return
     */
    public ResponseEntity<byte[]> doGetOrdinaryWithRequestParameters(String url) {
        return obtainRestTemplate().getForEntity(url, byte[].class);
    }
}
