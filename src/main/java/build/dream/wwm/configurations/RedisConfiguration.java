package build.dream.wwm.configurations;

import build.dream.wwm.constants.Constants;
import build.dream.wwm.redis.CommonRedisCondition;
import build.dream.wwm.redis.PartitionRedisCondition;
import build.dream.wwm.redis.RedisProperties;
import build.dream.wwm.utils.RedisHelper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {
    @Bean(name = "commonRedisProperties")
    @ConfigurationProperties(prefix = "common.redis")
    public RedisProperties commonRedisProperties() {
        return new RedisProperties();
    }

    @Bean(name = "partitionRedisProperties")
    @ConfigurationProperties(prefix = "partition.redis")
    public RedisProperties partitionRedisProperties() {
        return new RedisProperties();
    }

    @Primary
    @Bean(name = Constants.COMMON_REDIS_CONNECTION_FACTORY)
    @Conditional(value = CommonRedisCondition.class)
    public RedisConnectionFactory commonRedisConnectionFactory() {
        return RedisHelper.createRedisConnectionFactory(commonRedisProperties());
    }

    @Bean(name = Constants.PARTITION_REDIS_CONNECTION_FACTORY)
    @Conditional(value = PartitionRedisCondition.class)
    public RedisConnectionFactory partitionRedisConnectionFactory() {
        return RedisHelper.createRedisConnectionFactory(partitionRedisProperties());
    }

    @Primary
    @Bean(name = Constants.REDIS_TEMPLATE)
    @Conditional(value = CommonRedisCondition.class)
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(commonRedisConnectionFactory());
        return redisTemplate;
    }

    @Primary
    @Bean(name = Constants.COMMON_STRING_REDIS_TEMPLATE)
    @Conditional(value = CommonRedisCondition.class)
    public StringRedisTemplate commonStringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(commonRedisConnectionFactory());
        return stringRedisTemplate;
    }

    @Bean(name = Constants.PARTITION_STRING_REDIS_TEMPLATE)
    @Conditional(value = PartitionRedisCondition.class)
    public StringRedisTemplate partitionStringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(partitionRedisConnectionFactory());
        return stringRedisTemplate;
    }
}
