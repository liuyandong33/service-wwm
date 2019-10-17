package build.dream.wwm.models.organization;

import build.dream.wwm.models.UserBasicModel;

import javax.validation.constraints.NotNull;

public class DeleteOrganizationModel extends UserBasicModel {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
