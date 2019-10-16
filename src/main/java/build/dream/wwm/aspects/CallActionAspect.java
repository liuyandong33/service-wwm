package build.dream.wwm.aspects;

import build.dream.wwm.annotations.ApiRestAction;
import build.dream.wwm.utils.AspectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order
public class CallActionAspect {
    @Around(value = "execution(public * build.dream.wwm.controllers.*.*(..)) && @annotation(apiRestAction)")
    public Object callApiRestAction(ProceedingJoinPoint proceedingJoinPoint, ApiRestAction apiRestAction) {
        return AspectUtils.callApiRestAction(proceedingJoinPoint, apiRestAction);
    }
}