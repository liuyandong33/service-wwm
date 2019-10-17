package build.dream.wwm.models;

import build.dream.wwm.oauth.SysUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserBasicModel extends BasicModel {
    private Long _waterWorksId;
    private Long _userId;

    public UserBasicModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SysUserDetails sysUserDetails = (SysUserDetails) authentication.getPrincipal();
        this._waterWorksId = sysUserDetails.getWaterWorksId();
        this._userId = sysUserDetails.getUserId();
    }

    public Long obtainWaterWorksId() {
        return _waterWorksId;
    }

    public Long obtainUserId() {
        return _userId;
    }
}
