package com.triptrop.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow for all endpoints
                        .allowedOrigins("http://localhost:5173") // Allow frontend URL only
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods.
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true); // Allow cookies as needed
            }
        };
    }
}
