package build.dream.wwm.mappers;

import build.dream.wwm.domains.SysPrivilege;
import build.dream.wwm.domains.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    SysUser findByLoginNameOrEmailOrMobile(@Param("loginName") String loginName);

    List<SysPrivilege> obtainAllPrivileges(@Param("userId") long userId);
}
