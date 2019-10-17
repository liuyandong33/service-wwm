package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.beans.ZTreeNode;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.Organization;
import build.dream.wwm.models.organization.DeleteOrganizationModel;
import build.dream.wwm.models.organization.ObtainAllOrganizationsModel;
import build.dream.wwm.models.organization.SaveOrganizationModel;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
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
            zTreeNode.setPId(organization.getParentId().toString());
            return zTreeNode;
        }).collect(Collectors.toList());

        return ApiRest.builder().data(zTreeNodes).message("查询机构信息成功！").successful(true).build();
    }

    /**
     * 保存机构信息
     *
     * @param saveOrganizationModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ApiRest saveOrganization(SaveOrganizationModel saveOrganizationModel) {
        Long userId = saveOrganizationModel.obtainUserId();
        Long waterWorksId = saveOrganizationModel.obtainWaterWorksId();
        Long id = saveOrganizationModel.getId();
        String code = saveOrganizationModel.getCode();
        String name = saveOrganizationModel.getName();
        Long parentId = saveOrganizationModel.getParentId();

        Organization organization = null;
        if (Objects.isNull(id)) {
            organization = Organization.builder()
                    .code(code)
                    .name(name)
                    .parentId(parentId)
                    .createdUserId(userId)
                    .updatedUserId(userId)
                    .updatedRemark("新增机构信息！")
                    .build();
            DatabaseHelper.insert(organization);
        } else {
            SearchModel searchModel = SearchModel.builder()
                    .autoSetDeletedFalse()
                    .addSearchCondition(Organization.ColumnName.ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, id)
                    .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                    .build();
            organization = DatabaseHelper.find(Organization.class, searchModel);
            ValidateUtils.notNull(organization, "机构不存在！");

            organization.setName(name);
            organization.setParentId(parentId);
            DatabaseHelper.update(organization);
        }
        return ApiRest.builder().data(organization).message("保存机构信息成功！").successful(true).build();
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
}
