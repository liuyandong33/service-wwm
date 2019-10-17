package build.dream.wwm.models.role;

import build.dream.wwm.models.UserBasicModel;

import javax.validation.constraints.NotNull;

public class ObtainRoleInfoModel extends UserBasicModel {
    @NotNull
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
