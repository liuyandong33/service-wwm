package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    /**
     * 保存用户信息
     *
     * @return
     */
    @RequestMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = ListRolesModel.class, serviceClass = UserService.class, serviceMethodName = "listRoles", error = "保存用户信息失败")
    public String saveUser() {
        return null;
    }
}
