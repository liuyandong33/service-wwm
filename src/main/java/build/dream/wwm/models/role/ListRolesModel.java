package build.dream.wwm.models.role;

import build.dream.wwm.models.UserBasicModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ListRolesModel extends UserBasicModel {
    @NotNull
    @Min(1)
    private Integer page;

    @NotNull
    @Min(1)
    @Max(500)
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
