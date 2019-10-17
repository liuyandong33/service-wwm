package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.SysRole;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchCondition;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    /**
     * 分页查询角色信息
     *
     * @param listRolesModel
     * @return
     */
    @Transactional(readOnly = true)
    public ApiRest listRoles(ListRolesModel listRolesModel) {
        Long waterWorksId = listRolesModel.obtainWaterWorksId();
        int page = listRolesModel.getPage();
        int rows = listRolesModel.getRows();

        List<SearchCondition> searchConditions = new ArrayList<SearchCondition>();
        searchConditions.add(new SearchCondition(SysRole.ColumnName.DELETED, Constants.SQL_OPERATION_SYMBOL_EQUAL, 0));
        searchConditions.add(new SearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId));

        SearchModel searchModel = SearchModel.builder()
                .searchConditions(searchConditions)
                .build();
        long count = DatabaseHelper.count(SysRole.class, searchModel);
        List<SysRole> sysRoles = null;
        if (count > 0) {
            PagedSearchModel pagedSearchModel = PagedSearchModel.builder()
                    .searchConditions(searchConditions)
                    .page(page)
                    .rows(rows)
                    .build();
            sysRoles = DatabaseHelper.findAllPaged(SysRole.class, pagedSearchModel);
        } else {
            sysRoles = new ArrayList<SysRole>();
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("total", count);
        data.put("rows", sysRoles);
        return ApiRest.builder().data(sysRoles).message("查询角色信息成功！").successful(true).build();
    }
}
