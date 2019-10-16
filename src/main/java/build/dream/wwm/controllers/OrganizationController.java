package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.organization.ObtainAllOrganizationsModel;
import build.dream.wwm.services.OrganizationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {
    /**
     * 查询商品数量
     *
     * @return
     */
    @RequestMapping(value = "/obtainAllOrganizations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainAllOrganizationsModel.class, serviceClass = OrganizationService.class, serviceMethodName = "obtainAllOrganizations", error = "查询机构失败")
    public String obtainAllOrganizations() {
        return null;
    }
}
