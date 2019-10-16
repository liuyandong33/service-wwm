package build.dream.wwm.oauth;

import build.dream.wwm.domains.SysUser;
import build.dream.wwm.services.UserService;
import build.dream.wwm.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.findByLoginNameOrEmailOrMobile(username);
        ValidateUtils.notNull(sysUser, "用户不存在！");

        ValidateUtils.isTrue(sysUser.isAccountNonExpired(), "账号已过期！");
        ValidateUtils.isTrue(sysUser.isAccountNonLocked(), "账号已锁定！");
        ValidateUtils.isTrue(sysUser.isCredentialsNonExpired(), "凭证已过期！");
        ValidateUtils.isTrue(sysUser.isEnabled(), "账号已禁用！");


        SysUserDetails sysUserDetails = new SysUserDetails();
        sysUserDetails.setAuthorities(Collections.EMPTY_LIST);
        sysUserDetails.setUsername(username);
        sysUserDetails.setPassword(sysUser.getPassword());
        sysUserDetails.setAccountNonExpired(sysUser.isAccountNonExpired());
        sysUserDetails.setAccountNonLocked(sysUser.isAccountNonLocked());
        sysUserDetails.setCredentialsNonExpired(sysUser.isCredentialsNonExpired());
        sysUserDetails.setEnabled(sysUser.isEnabled());
        sysUserDetails.setUserId(sysUser.getId());
        sysUserDetails.setWaterWorksId(1);
        return sysUserDetails;
    }
}
