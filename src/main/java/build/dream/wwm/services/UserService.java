package build.dream.wwm.services;

import build.dream.wwm.domains.SysUser;
import build.dream.wwm.utils.DatabaseHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Transactional(readOnly = true)
    public SysUser findByLoginNameOrEmailOrMobile(String loginName) {
        return DatabaseHelper.find(SysUser.class, 1);
    }
}
