package com.ecommerce.voucher.util;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(ConfigurationUtility.getProperty("contextPath")).allowedMethods(ConfigurationUtility.getProperty("corsAllowedMethods"))
        .allowedOrigins(ConfigurationUtility.getProperty("corsAllowedOrigins"));
    }
}
