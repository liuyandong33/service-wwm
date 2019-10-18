package build.dream.wwm.models.organization;

import build.dream.wwm.models.UserBasicModel;

import javax.validation.constraints.NotNull;

public class SetRelationshipModel extends UserBasicModel {
    @NotNull
    private Long id;

    @NotNull
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
