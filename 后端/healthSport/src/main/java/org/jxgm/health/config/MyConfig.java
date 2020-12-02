package org.jxgm.health.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author luo
 * @date 2020/11/7 13:48
 * @description
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
