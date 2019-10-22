package build.dream.wwm.controllers;

import build.dream.wwm.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
        return Constants.OK;
    }
}
