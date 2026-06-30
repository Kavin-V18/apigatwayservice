package com.example.APIgateway.config;

import com.example.APIgateway.util.UserContext;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            Long userId = UserContext.getUserId();

            if (userId != null) {
                template.header("X-User-Id", userId.toString());
            }
        };
    }
}
