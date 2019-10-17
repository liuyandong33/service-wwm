package build.dream.wwm.models.organization;

import build.dream.wwm.models.UserBasicModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UpdateOrganizationModel extends UserBasicModel {
    @NotNull
    private Long id;

    @NotNull
    @Length(max = 20)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
