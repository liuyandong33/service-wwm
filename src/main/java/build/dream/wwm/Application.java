package build.dream.wwm;

import build.dream.wwm.api.ApiRest;
import build.dream.wwm.utils.JacksonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        System.out.println(JacksonUtils.writeValueAsString(ApiRest.builder().build()));
    }
}
