package build.dream.wwm.fallbacks;

import build.dream.wwm.utils.ProxyUtils;

import java.util.Map;

public class MicroServiceCallerFallback {
    public String doGetOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(partitionCode, serviceName) + ")异常！";
    }

    public String doGetOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersFallback(String partitionCode, String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(partitionCode, serviceName) + ")异常！";
    }

    public String doPostOriginalWithRequestParametersFallback(String serviceName, String controllerName, String actionName, Map<String, String> requestParameters) {
        return "服务(" + ProxyUtils.obtainApplicationName(null, serviceName) + ")异常！";
    }
}
