package build.dream.wwm.domains;

public class SysRole extends BasicDomain {
    public static final String TABLE_NAME = "sys_role";
    /**
     * 商户ID
     */
    private long waterWorksId;
    /**
     * 角色编号
     */
    private String roleCode;
    /**
     * 角色名称
     */
    private String roleName;

    public long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SysRole> {
        public Builder waterWorksId(long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder roleCode(String roleCode) {
            instance.setRoleCode(roleCode);
            return this;
        }

        public Builder roleName(String roleName) {
            instance.setRoleName(roleName);
            return this;
        }

        @Override
        public SysRole build() {
            SysRole sysRole = super.build();
            sysRole.setWaterWorksId(instance.getWaterWorksId());
            sysRole.setRoleCode(instance.getRoleCode());
            sysRole.setRoleName(instance.getRoleName());
            return sysRole;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String ROLE_CODE = "role_code";
        public static final String ROLE_NAME = "role_name";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String ROLE_CODE = "roleCode";
        public static final String ROLE_NAME = "roleName";
    }
}
