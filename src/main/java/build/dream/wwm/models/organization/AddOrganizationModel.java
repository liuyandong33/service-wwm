package build.dream.wwm.models.organization;

import build.dream.wwm.models.UserBasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddOrganizationModel extends UserBasicModel {
    @NotNull
    @Length(max = 20)
    private String code;

    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    private Long parentId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
