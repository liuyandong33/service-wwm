package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.services.OrganizationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    /**
     * 分页查询角色
     *
     * @return
     */
    @RequestMapping(value = "/listRoles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ListRolesModel.class, serviceClass = OrganizationService.class, serviceMethodName = "listRoles", error = "查询角色失败")
    public String listRoles() {
        return null;
    }
}
