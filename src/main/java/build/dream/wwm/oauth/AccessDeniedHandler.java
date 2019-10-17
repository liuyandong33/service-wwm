package build.dream.wwm.oauth;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.constants.ErrorConstants;
import build.dream.wwm.utils.JacksonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ApiRest apiRest = ApiRest.builder().error(ErrorConstants.ACCESS_DENIED_ERROR).successful(false).build();
        response.setContentType(Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);
        response.getOutputStream().write(JacksonUtils.writeValueAsString(apiRest).getBytes(Constants.CHARSET_UTF_8));
    }
}
