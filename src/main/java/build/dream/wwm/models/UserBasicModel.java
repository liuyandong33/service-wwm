package build.dream.wwm.models;

public class UserBasicModel extends BasicModel {
    private long _waterWorksId;
    private long _userId;

    public long obtainWaterWorksId() {
        return _waterWorksId;
    }

    public long obtainUserId() {
        return _userId;
    }
}
