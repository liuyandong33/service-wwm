package build.dream.wwm.services;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.Organization;
import build.dream.wwm.models.organization.ObtainAllOrganizationsModel;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationService {
    @Transactional(readOnly = true)
    public ApiRest obtainAllOrganizations(ObtainAllOrganizationsModel obtainAllOrganizationsModel) {
        long waterWorksId = obtainAllOrganizationsModel.obtainWaterWorksId();

        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(Organization.ColumnName.WATER_WORKS_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, waterWorksId)
                .build();
        List<Organization> organizations = DatabaseHelper.findAll(Organization.class, searchModel);
        return ApiRest.builder().data(organizations).message("查询水厂信息成功！").successful(true).build();
    }
}
