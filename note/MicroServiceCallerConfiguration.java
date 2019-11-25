package build.dream.wwm.configurations;

import build.dream.wwm.fallbacks.MicroServiceCallerFallback;
import build.dream.wwm.utils.MicroServiceCaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicroServiceCallerConfiguration {
    @Bean
    public MicroServiceCaller microServiceCaller() {
        MicroServiceCallerFallback microServiceCallerFallback = new MicroServiceCallerFallback();
        MicroServiceCaller microServiceCaller = new MicroServiceCaller();
        microServiceCaller.setMicroServiceCallerFallback(microServiceCallerFallback);
        return microServiceCaller;
    }
}
