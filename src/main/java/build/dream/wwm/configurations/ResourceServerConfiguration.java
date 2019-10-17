package build.dream.wwm.configurations;

import build.dream.wwm.annotations.PermitAll;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.domains.SysPrivilege;
import build.dream.wwm.oauth.AccessDeniedHandler;
import build.dream.wwm.oauth.WWMFilterInvocationSecurityMetadataSource;
import build.dream.wwm.services.PrivilegeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    //    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    private static final String[] PERMIT_ALL_ANT_PATTERNS = {
            "/favicon.ico",
            "/actuator/**"
    };

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("wwm");
        resources.tokenStore(tokenStore());
//        resources.authenticationEntryPoint(authenticationEntryPoint);
        resources.accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("ResourceServer").permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    private RequestMatcher buildAntPathRequestMatcher(String controllerName, String actionName) {
        return new AntPathRequestMatcher("/" + controllerName + "/" + actionName);
    }

    private List<ConfigAttribute> buildAuthenticatedConfigAttributes() {
        List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        configAttributes.add(new SecurityConfig(Constants.AUTHENTICATED));
        return configAttributes;
    }

    private List<ConfigAttribute> buildPermitAllConfigAttributes() {
        List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        configAttributes.add(new SecurityConfig(Constants.PERMIT_ALL));
        return configAttributes;
    }

    private LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildPermitAllRequestMap() {
        Map<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        Map<Class<?>, List<Map.Entry<RequestMappingInfo, HandlerMethod>>> map = requestMappingInfoHandlerMethodMap.entrySet().stream().collect(Collectors.groupingBy(requestMappingInfoHandlerMethodEntry -> requestMappingInfoHandlerMethodEntry.getValue().getBeanType()));

        List<String> permitAllAntPatterns = new ArrayList<String>();
        permitAllAntPatterns.addAll(Arrays.asList(PERMIT_ALL_ANT_PATTERNS));

        for (Map.Entry<Class<?>, List<Map.Entry<RequestMappingInfo, HandlerMethod>>> entry : map.entrySet()) {
            Class<?> controllerClass = entry.getKey();
            List<Map.Entry<RequestMappingInfo, HandlerMethod>> value = entry.getValue();

            if (AnnotationUtils.findAnnotation(controllerClass, PermitAll.class) != null) {
                for (Map.Entry<RequestMappingInfo, HandlerMethod> item : value) {
                    RequestMappingInfo requestMappingInfo = item.getKey();
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    permitAllAntPatterns.addAll(patternsCondition.getPatterns());
                }
            } else {
                for (Map.Entry<RequestMappingInfo, HandlerMethod> item : value) {
                    if (AnnotationUtils.findAnnotation(item.getValue().getMethod(), PermitAll.class) == null) {
                        continue;
                    }

                    RequestMappingInfo requestMappingInfo = item.getKey();
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    permitAllAntPatterns.addAll(patternsCondition.getPatterns());
                }
            }
        }

        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> permitAllRequestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        for (String permitAllAntPattern : permitAllAntPatterns) {
            permitAllRequestMap.put(new AntPathRequestMatcher(permitAllAntPattern), buildPermitAllConfigAttributes());
        }
        return permitAllRequestMap;
    }

    private List<ConfigAttribute> buildHasAuthorityConfigAttributes(String privilegeCode) {
        List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        configAttributes.add(new SecurityConfig(String.format(Constants.HAS_AUTHORITY_FORMAT, privilegeCode)));
        return configAttributes;
    }

    private LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildPrivilegeRequestMap() {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> privilegeMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        List<SysPrivilege> sysPrivileges = privilegeService.obtainAllPrivileges();
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            String controllerName = sysPrivilege.getControllerName();
            String actionName = sysPrivilege.getActionName();
            if (StringUtils.isNoneBlank(controllerName) && StringUtils.isNoneBlank(actionName)) {
                privilegeMap.put(buildAntPathRequestMatcher(controllerName, actionName), buildHasAuthorityConfigAttributes(sysPrivilege.getPrivilegeCode()));
            }
        }
        return privilegeMap;
    }

    @Bean
    public WWMFilterInvocationSecurityMetadataSource wwmFilterInvocationSecurityMetadataSource() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
        requestMap.putAll(buildPrivilegeRequestMap());
        requestMap.putAll(buildPermitAllRequestMap());
        requestMap.put(AnyRequestMatcher.INSTANCE, buildAuthenticatedConfigAttributes());
        return new WWMFilterInvocationSecurityMetadataSource(requestMap);
    }
}
