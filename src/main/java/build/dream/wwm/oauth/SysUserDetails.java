package build.dream.wwm.oauth;

public class SysUserDetails extends AbstractUserDetails {
    private long userId;
    private long waterWorksId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getWaterWorksId() {
        return waterWorksId;
    }

    public void setWaterWorksId(long waterWorksId) {
        this.waterWorksId = waterWorksId;
    }
}
