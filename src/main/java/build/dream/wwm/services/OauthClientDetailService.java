package build.dream.wwm.services;

import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.OauthClientDetail;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OauthClientDetailService {
    @Transactional(readOnly = true)
    public OauthClientDetail obtainOauthClientDetail(String clientId) {
        SearchModel searchModel = SearchModel.builder()
                .autoSetDeletedFalse()
                .addSearchCondition(OauthClientDetail.ColumnName.CLIENT_ID, Constants.SQL_OPERATION_SYMBOL_EQUAL, clientId)
                .build();
        return DatabaseHelper.find(OauthClientDetail.class, searchModel);
    }
}
