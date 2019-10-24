package build.dream.wwm.controllers;

import build.dream.wwm.annotations.PermitAll;
import build.dream.wwm.api.ApiRest;
import build.dream.wwm.utils.JacksonUtils;
import build.dream.wwm.utils.ProxyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@PermitAll
public class IndexController {
    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        ApiRest apiRest = ProxyUtils.doGetWithRequestParameters("platform", "agent", "obtainAgentInfo", null);
        return JacksonUtils.writeValueAsString(apiRest);
//        return Constants.OK;
    }
}
