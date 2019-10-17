package build.dream.wwm.models.organization;

import build.dream.wwm.models.UserBasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class SaveOrganizationModel extends UserBasicModel {
    private Long id;

    @NotNull
    @Length(max = 20)
    private String code;

    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
