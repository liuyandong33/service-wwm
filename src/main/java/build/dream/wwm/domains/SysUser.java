package build.dream.wwm.domains;

public class SysUser extends BasicDomain {
    public static final String TABLE_NAME = "sys_user";
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 用户类型，1-超级管理员，2-普通用户
     */
    private Integer userType;
    /**
     * 密码
     */
    private String password;
    /**
     * 水厂ID
     */
    private long waterWorksId;
    /**
     * 账户是否没有过期，1-没有过期，0-已经过期
     */
    private boolean accountNonExpired = true;
    /**
     * 账户是否没有锁定，1-没有锁定，0-已经锁定
     */
    private boolean accountNonLocked = true;
    ;
    /**
     * 账户凭证是否没有过期，1-没有过期，0-已经过期
     */
    private boolean credentialsNonExpired = true;
    ;
    /**
     * 账户是否启用，1-启用，0-禁用
     */
    private boolean enabled = true;
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SysUser> {
        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder mobile(String mobile) {
            instance.setMobile(mobile);
            return this;
        }

        public Builder email(String email) {
            instance.setEmail(email);
            return this;
        }

        public Builder loginName(String loginName) {
            instance.setLoginName(loginName);
            return this;
        }

        public Builder userType(Integer userType) {
            instance.setUserType(userType);
            return this;
        }

        public Builder password(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder waterWorksId(long waterWorksId) {
            instance.setWaterWorksId(waterWorksId);
            return this;
        }

        public Builder accountNonExpired(boolean accountNonExpired) {
            instance.setAccountNonExpired(accountNonExpired);
            return this;
        }

        public Builder accountNonLocked(boolean accountNonLocked) {
            instance.setAccountNonLocked(accountNonLocked);
            return this;
        }

        public Builder credentialsNonExpired(boolean credentialsNonExpired) {
            instance.setCredentialsNonExpired(credentialsNonExpired);
            return this;
        }

        public Builder enabled(boolean enabled) {
            instance.setEnabled(enabled);
            return this;
        }

        @Override
        public SysUser build() {
            SysUser sysUser = super.build();
            sysUser.setName(instance.getName());
            sysUser.setMobile(instance.getMobile());
            sysUser.setEmail(instance.getEmail());
            sysUser.setLoginName(instance.getLoginName());
            sysUser.setUserType(instance.getUserType());
            sysUser.setPassword(instance.getPassword());
            sysUser.setWaterWorksId(instance.getWaterWorksId());
            sysUser.setAccountNonExpired(instance.isAccountNonExpired());
            sysUser.setAccountNonLocked(instance.isAccountNonLocked());
            sysUser.setCredentialsNonExpired(instance.isCredentialsNonExpired());
            sysUser.setEnabled(instance.isEnabled());
            return sysUser;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String NAME = "name";
        public static final String MOBILE = "mobile";
        public static final String EMAIL = "email";
        public static final String LOGIN_NAME = "login_name";
        public static final String USER_TYPE = "user_type";
        public static final String PASSWORD = "password";
        public static final String WATER_WORKS_ID = "water_works_id";
        public static final String ACCOUNT_NON_EXPIRED = "account_non_expired";
        public static final String ACCOUNT_NON_LOCKED = "account_non_locked";
        public static final String CREDENTIALS_NON_EXPIRED = "credentials_non_expired";
        public static final String ENABLED = "enabled";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String NAME = "name";
        public static final String MOBILE = "mobile";
        public static final String EMAIL = "email";
        public static final String LOGIN_NAME = "loginName";
        public static final String USER_TYPE = "userType";
        public static final String PASSWORD = "password";
        public static final String WATER_WORKS_ID = "waterWorksId";
        public static final String ACCOUNT_NON_EXPIRED = "accountNonExpired";
        public static final String ACCOUNT_NON_LOCKED = "accountNonLocked";
        public static final String CREDENTIALS_NON_EXPIRED = "credentialsNonExpired";
        public static final String ENABLED = "enabled";
    }
}
