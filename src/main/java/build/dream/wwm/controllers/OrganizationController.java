package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.organization.*;
import build.dream.wwm.services.OrganizationService;
import build.dream.wwm.utils.ApplicationHandler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        ModelAndView modelAndView = new ModelAndView("organization/index");
        modelAndView.addObject("accessToken", requestParameters.get("access_token"));
        return modelAndView;
    }

    /**
     * 设置机构下级关系
     *
     * @return
     */
    @RequestMapping(value = "/setRelationship", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = SetRelationshipModel.class, serviceClass = OrganizationService.class, serviceMethodName = "setRelationship", error = "设置机构上下级关系失败")
    public String setRelationship() {
        return null;
    }
}
