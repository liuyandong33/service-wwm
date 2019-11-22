package build.dream.wwm.controllers;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.models.user.DeleteUserModel;
import build.dream.wwm.models.user.UpdateUserModel;
import build.dream.wwm.models.user.AddUserModel;
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
    @RequestMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = AddUserModel.class, serviceClass = UserService.class, serviceMethodName = "addUser", error = "新增用户信息失败")
    public String addUser() {
        return null;
    }

    /**
     * 保存用户信息
     *
     * @return
     */
    @RequestMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = UpdateUserModel.class, serviceClass = UserService.class, serviceMethodName = "updateUser", error = "修改用户信息失败")
    public String updateUser() {
        return null;
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @RequestMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiRestAction(modelClass = DeleteUserModel.class, serviceClass = UserService.class, serviceMethodName = "deleteUser", error = "删除用户信息失败")
    public String deleteUser() {
        return null;
    }
}
