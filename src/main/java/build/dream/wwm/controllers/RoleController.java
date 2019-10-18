package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.role.AddRoleModel;
import build.dream.wwm.models.role.DeleteRoleModel;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.models.role.ObtainRoleInfoModel;
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
     * 新增角色信息
     *
     * @return
     */
    @RequestMapping(value = "/addRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = AddRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "addRole", error = "新增角色失败")
    public String addRole() {
        return null;
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequestMapping(value = "/deleteRole", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = DeleteRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "deleteRole", error = "删除角色失败")
    public String deleteRole() {
        return null;
    }

    /**
     * 获取角色信息
     *
     * @return
     */
    @RequestMapping(value = "/obtainRoleInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainRoleInfoModel.class, serviceClass = RoleService.class, serviceMethodName = "obtainRoleInfo", error = "获取角色信息失败")
    public String obtainRoleInfo() {
        return null;
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "role/index";
    }
}
