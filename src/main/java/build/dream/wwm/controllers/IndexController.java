package build.dream.wwm.controllers;

import build.dream.wwm.annotations.PermitAll;
import build.dream.wwm.constants.Constants;
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
        return Constants.OK;
    }
}
