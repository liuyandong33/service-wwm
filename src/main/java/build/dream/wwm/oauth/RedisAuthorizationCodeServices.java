package build.dream.wwm.oauth;

import build.dream.wwm.constants.Constants;
import build.dream.wwm.utils.CommonRedisUtils;
import build.dream.wwm.utils.ObjectUtils;
import build.dream.wwm.utils.ValidateUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RedisAuthorizationCodeServices implements AuthorizationCodeServices {
    @Override
    public String createAuthorizationCode(OAuth2Authentication authentication) {
        String code = DigestUtils.sha256Hex(UUID.randomUUID().toString().getBytes(Constants.CHARSET_UTF_8));
        CommonRedisUtils.setex(code.getBytes(Constants.CHARSET_UTF_8), 300, ObjectUtils.serialize(authentication));
        return code;
    }

    @Override
    public OAuth2Authentication consumeAuthorizationCode(String code) throws InvalidGrantException {
        byte[] key = code.getBytes(Constants.CHARSET_UTF_8);
        byte[] value = CommonRedisUtils.get(key);
        ValidateUtils.isTrue(ArrayUtils.isNotEmpty(value), "Invalid authorization code: " + code);
        CommonRedisUtils.del(key);
        return ObjectUtils.deserialize(value);
    }
}
