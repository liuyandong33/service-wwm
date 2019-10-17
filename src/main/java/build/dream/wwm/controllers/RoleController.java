package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.models.role.SaveRoleModel;
import build.dream.wwm.services.RoleService;
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
    @ApiRestAction(modelClass = ListRolesModel.class, serviceClass = RoleService.class, serviceMethodName = "listRoles", error = "查询角色失败")
    public String listRoles() {
        return null;
    }

    /**
     * 保存角色信息
     *
     * @return
     */
    @RequestMapping(value = "/saveRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = SaveRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "saveRole", error = "保存角色失败")
    public String saveRole() {
        return null;
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequestMapping(value = "/deleteRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = SaveRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "deleteRole", error = "删除角色失败")
    public String deleteRole() {
        return null;
    }
}
