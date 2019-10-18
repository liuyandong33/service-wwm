package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.SysPrivilege;
import build.dream.wwm.domains.SysRole;
import build.dream.wwm.domains.SysUser;
import build.dream.wwm.mappers.UserMapper;
import build.dream.wwm.models.role.DeleteUserModel;
import build.dream.wwm.models.role.UpdateUserModel;
import build.dream.wwm.models.user.AddUserModel;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public SysUser findByLoginNameOrEmailOrMobile(String loginName) {
        return userMapper.findByLoginNameOrEmailOrMobile(loginName);
    }

    @Transactional(readOnly = true)
    public List<SysPrivilege> obtainAllPrivileges(long userId) {
        return userMapper.obtainAllPrivileges(userId);
    }

    /**
     * 保存用户信息
     *
     * @param addUserModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest addUser(AddUserModel addUserModel) {
        Long waterWorksId = addUserModel.obtainWaterWorksId();
        Long userId = addUserModel.obtainUserId();
        String name = addUserModel.getName();
        String mobile = addUserModel.getMobile();
        String email = addUserModel.getEmail();
        String loginName = addUserModel.getLoginName();
        List<Long> roleIds = addUserModel.getRoleIds();

        SysUser sysUser = SysUser.builder()
                .name(name)
                .mobile(mobile)
                .email(email)
                .loginName(loginName)
                .userType(1)
                .password("123456")
                .waterWorksId(waterWorksId)
                .createdUserId(userId)
                .updatedUserId(userId)
                .updatedRemark("新增用户信息！")
                .build();
        DatabaseHelper.insert(sysUser);
        if (CollectionUtils.isNotEmpty(roleIds)) {
            userMapper.insetRoles(sysUser.getId(), roleIds);
        }
        return ApiRest.builder().data(sysUser).message("新增用户信息成功！").successful(true).build();
    }

    /**
     * 修改用户信息
     *
     * @param updateUserModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest updateUser(UpdateUserModel updateUserModel) {
        Long waterWorksId = updateUserModel.obtainWaterWorksId();
        Long userId = updateUserModel.obtainUserId();
        Long id = updateUserModel.getId();
        String name = updateUserModel.getName();
        String mobile = updateUserModel.getMobile();
        String email = updateUserModel.getEmail();
        String loginName = updateUserModel.getLoginName();
        List<Long> roleIds = updateUserModel.getRoleIds();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .addSearchCondition(SysRole.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        SysUser sysUser = DatabaseHelper.find(SysUser.class, searchModel);
        ValidateUtils.notNull(sysUser, "用户不存在！");

        sysUser.setName(name);
        sysUser.setMobile(mobile);
        sysUser.setEmail(email);
        sysUser.setLoginName(loginName);
        sysUser.setUpdatedUserId(userId);
        sysUser.setUpdatedRemark("修改用户信息！");
        DatabaseHelper.update(sysUser);
        userMapper.deleteAllRoles(id);
        if (CollectionUtils.isNotEmpty(roleIds)) {
            userMapper.insetRoles(id, roleIds);
        }
        return ApiRest.builder().data(sysUser).message("修改用户信息成功！").successful(true).build();
    }

    /**
     * 删除用户信息
     *
     * @param deleteUserModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest deleteUser(DeleteUserModel deleteUserModel) {
        Long waterWorksId = deleteUserModel.obtainWaterWorksId();
        Long userId = deleteUserModel.obtainUserId();
        Long id = deleteUserModel.getId();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .addSearchCondition(SysRole.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        SysUser sysUser = DatabaseHelper.find(SysUser.class, searchModel);
        ValidateUtils.notNull(sysUser, "用户不存在！");

        sysUser.setDeleted(true);
        sysUser.setDeletedTime(new Date());
        sysUser.setUpdatedUserId(userId);
        DatabaseHelper.update(sysUser);
        userMapper.deleteAllRoles(id);

        return ApiRest.builder().data(sysUser).message("删除用户信息成功！").successful(true).build();
    }
}
