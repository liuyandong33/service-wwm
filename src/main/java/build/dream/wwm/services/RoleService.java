package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.SysRole;
import build.dream.wwm.mappers.RoleMapper;
import build.dream.wwm.models.role.AddRoleModel;
import build.dream.wwm.models.role.DeleteRoleModel;
import build.dream.wwm.models.role.ListRolesModel;
import build.dream.wwm.models.role.UpdateRoleModel;
import build.dream.wwm.orm.PagedSearchModel;
import build.dream.wwm.orm.SearchCondition;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

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

    /**
     * 新增角色
     *
     * @param addRoleModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest saveRole(AddRoleModel addRoleModel) {
        Long waterWorksId = addRoleModel.obtainWaterWorksId();
        Long userId = addRoleModel.obtainUserId();
        String roleCode = addRoleModel.getRoleCode();
        String roleName = addRoleModel.getRoleName();
        List<Long> privilegeIds = addRoleModel.getPrivilegeIds();

        SysRole sysRole = SysRole.builder()
                .waterWorksId(waterWorksId)
                .roleCode(roleCode)
                .roleName(roleName)
                .createdUserId(userId)
                .updatedUserId(userId)
                .updatedRemark("新增角色信息！")
                .build();
        DatabaseHelper.insert(sysRole);
        roleMapper.insertPrivileges(sysRole.getId(), privilegeIds);
        return ApiRest.builder().data(sysRole).message("新增角色信息成功！").successful(true).build();
    }

    /**
     * 修改角色
     *
     * @param updateRoleModel
     * @return
     */
    public ApiRest updateRole(UpdateRoleModel updateRoleModel) {
        Long waterWorksId = updateRoleModel.obtainWaterWorksId();
        Long userId = updateRoleModel.obtainUserId();
        Long id = updateRoleModel.getId();
        String roleName = updateRoleModel.getRoleName();
        List<Long> privilegeIds = updateRoleModel.getPrivilegeIds();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .addSearchCondition(SysRole.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        SysRole sysRole = DatabaseHelper.find(SysRole.class, searchModel);
        ValidateUtils.notNull(sysRole, "角色不存在！");

        sysRole.setRoleName(roleName);
        sysRole.setUpdatedUserId(userId);
        sysRole.setUpdatedRemark("修改角色信息！");
        DatabaseHelper.update(sysRole);

        roleMapper.deleteRolePrivileges(id);
        roleMapper.insertPrivileges(id, privilegeIds);
        return ApiRest.builder().data(sysRole).message("修改角色信息成功！").successful(true).build();
    }

    /**
     * 删除角色
     *
     * @param deleteRoleModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest deleteRole(DeleteRoleModel deleteRoleModel) {
        Long waterWorksId = deleteRoleModel.obtainWaterWorksId();
        Long userId = deleteRoleModel.obtainUserId();
        Long id = deleteRoleModel.getId();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(SysRole.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .addSearchCondition(SysRole.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        SysRole sysRole = DatabaseHelper.find(SysRole.class, searchModel);
        ValidateUtils.notNull(sysRole, "角色不存在！");

        sysRole.setUpdatedUserId(userId);
        sysRole.setUpdatedRemark("删除角色！");
        sysRole.setDeleted(true);
        sysRole.setDeletedTime(new Date());
        DatabaseHelper.update(sysRole);
        roleMapper.deleteRolePrivileges(id);
        return ApiRest.builder().data(sysRole).message("删除角色信息成功！").successful(true).build();
    }
}
