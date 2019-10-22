package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.api.ApiRest;
import build.dream.wwm.models.role.*;
import build.dream.wwm.services.RoleService;
import build.dream.wwm.utils.ApplicationHandler;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
    /**
     * 分页查询角色
     *
     * @return
     */
    @ApiOperation(value = "listRoles", notes = "分页查询角色", response = ApiRest.class)
    @RequestMapping(value = "/listRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/addRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = AddRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "addRole", error = "新增角色失败")
    public String addRole() {
        return null;
    }

    /**
     * 修改角色信息
     *
     * @return
     */
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = UpdateRoleModel.class, serviceClass = RoleService.class, serviceMethodName = "updateRole", error = "修改角色失败")
    public String updateRole() {
        return null;
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/obtainRoleInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ObtainRoleInfoModel.class, serviceClass = RoleService.class, serviceMethodName = "obtainRoleInfo", error = "获取角色信息失败")
    public String obtainRoleInfo() {
        return null;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        ModelAndView modelAndView = new ModelAndView("role/index");
        modelAndView.addObject("accessToken", requestParameters.get("access_token"));
        return modelAndView;
    }
}
