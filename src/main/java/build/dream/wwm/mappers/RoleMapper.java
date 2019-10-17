package build.dream.wwm.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    long deleteRolePrivileges(@Param("roleId") long roleId);

    long insertPrivileges(@Param("roleId") long roleId, @Param("privilegeIds") List<Long> privilegeIds);
}
