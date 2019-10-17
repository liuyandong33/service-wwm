package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.SysPrivilege;
import build.dream.wwm.domains.SysRole;
import build.dream.wwm.domains.SysUser;
import build.dream.wwm.mappers.UserMapper;
import build.dream.wwm.models.user.SaveUserModel;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
     * @param saveUserModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest saveUser(SaveUserModel saveUserModel) {
        Long waterWorksId = saveUserModel.obtainWaterWorksId();
        Long userId = saveUserModel.obtainUserId();
        Long id = saveUserModel.getId();
        String name = saveUserModel.getName();
        String mobile = saveUserModel.getMobile();
        String email = saveUserModel.getEmail();
        String loginName = saveUserModel.getLoginName();

        SysUser sysUser = null;
        if (Objects.isNull(id)) {
            sysUser = SysUser.builder()
                    .name(name)
                    .mobile(mobile)
                    .email(email)
                    .loginName(loginName)
                    .userType(1)
                    .password("123456")
                    .waterWorksId(waterWorksId)
                    .build();
            DatabaseHelper.insert(sysUser);
        } else {
            SearchModel searchModel = SearchModel.builder()
                    .autoSetDeletedFalse()
                    .addSearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                    .addSearchCondition(SysRole.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                    .build();
            sysUser = DatabaseHelper.find(SysUser.class, searchModel);
            ValidateUtils.notNull(sysUser, "用户不存在！");

            sysUser.setName(name);
            sysUser.setMobile(mobile);
            sysUser.setEmail(email);
            sysUser.setLoginName(loginName);
            sysUser.setUpdatedUserId(userId);
            sysUser.setUpdatedRemark("修改用户信息！");
            DatabaseHelper.update(sysUser);
        }
        return ApiRest.builder().data(sysUser).message("保存用户信息成功！").successful(true).build();
    }
}
