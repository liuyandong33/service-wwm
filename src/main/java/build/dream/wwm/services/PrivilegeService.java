package build.dream.wwm.services;

import build.dream.wwm.domains.SysPrivilege;
import build.dream.wwm.orm.SearchModel;
import build.dream.wwm.utils.DatabaseHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrivilegeService {
    @Transactional(readOnly = true)
    public List<SysPrivilege> obtainAllPrivileges() {
        SearchModel searchModel = SearchModel.builder().autoSetDeletedFalse().build();
        return DatabaseHelper.findAll(SysPrivilege.class, searchModel);
    }
}
