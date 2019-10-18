package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.beans.ZTreeNode;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.Organization;
import build.dream.wwm.models.organization.*;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.orm.UpdateModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    /**
     * 查询机构信息
     *
     * @param obtainAllOrganizationsModel
     * @return
     */
    @Transactional(readOnly = true)
    public ApiRest obtainAllOrganizations(ObtainAllOrganizationsModel obtainAllOrganizationsModel) {
        long waterWorksId = obtainAllOrganizationsModel.obtainWaterWorksId();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .build();
        List<Organization> organizations = DatabaseHelper.findAll(Organization.class, searchModel);

        List<ZTreeNode> zTreeNodes = organizations.stream().map(organization -> {
            ZTreeNode zTreeNode = new ZTreeNode();
            zTreeNode.setId(organization.getId().toString());
            zTreeNode.setName(organization.getName());
            zTreeNode.setPid(organization.getParentId().toString());
            zTreeNode.setOpen(true);
            return zTreeNode;
        }).collect(Collectors.toList());

        return ApiRest.builder().data(zTreeNodes).message("查询机构信息成功！").successful(true).build();
    }

    /**
     * 新增机构信息
     *
     * @param addOrganizationModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest addOrganization(AddOrganizationModel addOrganizationModel) {
        Long userId = addOrganizationModel.obtainUserId();
        Long waterWorksId = addOrganizationModel.obtainWaterWorksId();
        String code = addOrganizationModel.getCode();
        String name = addOrganizationModel.getName();
        Long parentId = addOrganizationModel.getParentId();

        Organization organization = Organization.builder()
                .code(code)
                .name(name)
                .waterWorksId(waterWorksId)
                .parentId(parentId)
                .createdUserId(userId)
                .updatedUserId(userId)
                .updatedRemark("新增机构信息！")
                .build();
        DatabaseHelper.insert(organization);
        return ApiRest.builder().data(organization).message("新增机构信息成功！").successful(true).build();
    }

    /**
     * 修改机构信息
     *
     * @param updateOrganizationModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest updateOrganization(UpdateOrganizationModel updateOrganizationModel) {
        Long userId = updateOrganizationModel.obtainUserId();
        Long waterWorksId = updateOrganizationModel.obtainWaterWorksId();
        Long id = updateOrganizationModel.getId();
        String name = updateOrganizationModel.getName();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(Organization.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .build();
        Organization organization = DatabaseHelper.find(Organization.class, searchModel);
        ValidateUtils.notNull(organization, "机构不存在！");

        organization.setName(name);
        organization.setUpdatedUserId(userId);
        organization.setUpdatedRemark("修改机构信息！");
        DatabaseHelper.update(organization);
        return ApiRest.builder().data(organization).message("修改机构信息成功！").successful(true).build();
    }

    /**
     * 删除机构
     *
     * @param deleteOrganizationModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest deleteOrganization(DeleteOrganizationModel deleteOrganizationModel) {
        Long userId = deleteOrganizationModel.obtainUserId();
        Long waterWorksId = deleteOrganizationModel.obtainWaterWorksId();
        Long id = deleteOrganizationModel.getId();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(Organization.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .build();

        Organization organization = DatabaseHelper.find(Organization.class, searchModel);
        ValidateUtils.notNull(organization, "机构不存在！");

        organization.setUpdatedUserId(userId);
        organization.setUpdatedRemark("删除机构信息！");
        organization.setDeleted(true);
        organization.setDeletedTime(new Date());
        DatabaseHelper.update(organization);
        return ApiRest.builder().data(organization).message("删除机构信息成功！").successful(true).build();
    }

    /**
     * 设置机构上下级关系
     *
     * @param setRelationshipModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest setRelationship(SetRelationshipModel setRelationshipModel) {
        Long userId = setRelationshipModel.obtainUserId();
        Long waterWorksId = setRelationshipModel.obtainWaterWorksId();
        Long id = setRelationshipModel.getId();
        Long parentId = setRelationshipModel.getParentId();

        UpdateModel updateModel = UpdateModel.builder()
                .addContentValue(Organization.ColumnName.PARENT_ID, parentId, 1)
                .addContentValue(Organization.ColumnName.UPDATED_USER_ID, userId, 1)
                .addContentValue(Organization.ColumnName.UPDATED_REMARK, "设置机构上下级关系！", 1)
                .autoSetDeletedFalse()
                .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .addSearchCondition(Organization.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                .build();
        DatabaseHelper.universalUpdate(updateModel, Organization.TABLE_NAME);
        return ApiRest.builder().message("设置机构上下级关系成功！").successful(true).build();
    }
}
