package build.dream.wwm.models.role;

import build.dream.wwm.models.UserBasicModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel
public class ListRolesModel extends UserBasicModel {
    @ApiModelProperty(value = "页码", required = true)
    @NotNull
    @Min(1)
    private Integer page;

    @NotNull
    @Min(1)
    @Max(500)
    @ApiModelProperty(value = "页大小", required = true)
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
