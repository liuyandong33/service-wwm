package build.dream.wwm.oauth;

public class SysUserDetails extends AbstractUserDetails {
    private Long userId;
    private Long waterWorksId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(Long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }
}
