package build.dream.wwm.mappers;

import java.util.List;

public interface PrivilegeMapper {
    long deleteRolePrivileges(long roleId);

    long insertPrivileges(long roleId, List<Long> privilegeIds);
}
