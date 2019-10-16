package build.dream.wwm.redis;

import build.dream.wwm.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PartitionRedisCondition implements Condition {
    private Environment environment;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        environment = context.getEnvironment();
        if (containsProperty(Constants.PARTITION_REDIS_HOST)
                && containsProperty(Constants.PARTITION_REDIS_PORT)
                && containsProperty(Constants.PARTITION_REDIS_PASSWORD)) {
            return true;
        }
        return false;
    }

    private boolean containsProperty(String key) {
        return StringUtils.isNotBlank(environment.getProperty(key));
    }
}
