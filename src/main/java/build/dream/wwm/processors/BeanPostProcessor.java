package build.dream.wwm.processors;

import org.springframework.beans.BeansException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by liuyandong on 2017/6/21.
 */
@Component
public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    private FilterSecurityInterceptor filterSecurityInterceptor;
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    private boolean isSetFinished = false;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof FilterSecurityInterceptor && check(bean)) {
            filterSecurityInterceptor = (FilterSecurityInterceptor) bean;
        }

        if (bean instanceof FilterInvocationSecurityMetadataSource) {
            filterInvocationSecurityMetadataSource = (FilterInvocationSecurityMetadataSource) bean;
        }

        if (Objects.nonNull(filterSecurityInterceptor) && Objects.nonNull(filterInvocationSecurityMetadataSource) && !isSetFinished) {
            filterSecurityInterceptor.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
            isSetFinished = true;
        }
        return bean;
    }

    public boolean check(Object bean) {
        try {
            FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = ((FilterSecurityInterceptor) bean).getSecurityMetadataSource();
            Class<DefaultFilterInvocationSecurityMetadataSource> defaultFilterInvocationSecurityMetadataSourceClass = DefaultFilterInvocationSecurityMetadataSource.class;
            Field field = defaultFilterInvocationSecurityMetadataSourceClass.getDeclaredField("requestMap");
            field.setAccessible(true);
            Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = (Map<RequestMatcher, Collection<ConfigAttribute>>) field.get(filterInvocationSecurityMetadataSource);

            Set<RequestMatcher> requestMatchers = requestMap.keySet();
            for (RequestMatcher requestMatcher : requestMatchers) {
                if (!(requestMatcher instanceof AntPathRequestMatcher)) {
                    continue;
                }

                AntPathRequestMatcher antPathRequestMatcher = (AntPathRequestMatcher) requestMatcher;
                if ("ResourceServer".equals(antPathRequestMatcher.getPattern())) {
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
