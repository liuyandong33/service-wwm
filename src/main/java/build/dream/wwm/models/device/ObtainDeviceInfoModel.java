package build.dream.wwm.models.device;

import build.dream.wwm.models.UserBasicModel;

import javax.validation.constraints.NotNull;

public class ObtainDeviceInfoModel extends UserBasicModel {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
