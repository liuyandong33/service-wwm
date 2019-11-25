package build.dream.wwm.configurations;

import build.dream.wwm.constants.Constants;
import build.dream.wwm.utils.ConfigurationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        String connectTimeout = ConfigurationUtils.getConfiguration(Constants.REST_TEMPLATE_CONNECT_TIMEOUT);
        String readTimeout = ConfigurationUtils.getConfiguration(Constants.REST_TEMPLATE_READ_TIMEOUT);

        RestTemplate restTemplate = null;
        if (StringUtils.isNotBlank(connectTimeout) && StringUtils.isNotBlank(readTimeout)) {
            SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
            simpleClientHttpRequestFactory.setConnectTimeout(Integer.parseInt(connectTimeout));
            simpleClientHttpRequestFactory.setReadTimeout(Integer.parseInt(readTimeout));
            restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        } else {
            restTemplate = new RestTemplate();
        }
        return restTemplate;
    }
}
