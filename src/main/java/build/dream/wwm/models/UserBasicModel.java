package build.dream.wwm.models;

public class UserBasicModel extends BasicModel {
    private Long _waterWorksId;
    private Long _userId;

    public Long obtainWaterWorksId() {
        return _waterWorksId;
    }

    public Long obtainUserId() {
        return _userId;
    }
}
