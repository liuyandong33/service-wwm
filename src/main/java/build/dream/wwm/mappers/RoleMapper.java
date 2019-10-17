package build.dream.wwm.mappers;

import build.dream.wwm.domains.SysPrivilege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    long deleteRolePrivileges(@Param("roleId") long roleId);

    long insertPrivileges(@Param("roleId") long roleId, @Param("privilegeIds") List<Long> privilegeIds);

    List<SysPrivilege> obtainRolePrivileges(@Param("roleId") long roleId);
}
