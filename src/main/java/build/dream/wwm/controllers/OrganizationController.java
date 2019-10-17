package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.organization.AddOrganizationModel;
import build.dream.wwm.models.organization.DeleteOrganizationModel;
import build.dream.wwm.models.organization.ObtainAllOrganizationsModel;
import build.dream.wwm.models.organization.UpdateOrganizationModel;
import build.dream.wwm.services.OrganizationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {
    /**
     * 查询机构信息
     *
     * @return
     */
    @RequestMapping(value = "/obtainAllOrganizations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainAllOrganizationsModel.class, serviceClass = OrganizationService.class, serviceMethodName = "obtainAllOrganizations", error = "查询机构失败")
    public String obtainAllOrganizations() {
        return null;
    }

    /**
     * 新增机构信息
     *
     * @return
     */
    @RequestMapping(value = "/addOrganization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = AddOrganizationModel.class, serviceClass = OrganizationService.class, serviceMethodName = "addOrganization", error = "新增机构信息失败")
    public String saveOrganization() {
        return null;
    }

    /**
     * 修改机构信息
     *
     * @return
     */
    @RequestMapping(value = "/updateOrganization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = UpdateOrganizationModel.class, serviceClass = OrganizationService.class, serviceMethodName = "updateOrganization", error = "修改机构信息失败")
    public String updateOrganization() {
        return null;
    }

    /**
     * 删除机构
     *
     * @return
     */
    @RequestMapping(value = "/deleteOrganization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = DeleteOrganizationModel.class, serviceClass = OrganizationService.class, serviceMethodName = "deleteOrganization", error = "删除机构信息失败")
    public String deleteOrganization() {
        return null;
    }
}
