package com.knowledgetracker.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class WebConfigurer implements ServletContextInitializer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment environment;

    public WebConfigurer(Environment env) {
        this.environment = env;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (environment.getActiveProfiles().length != 0) {
            log.info("using profiles: {}", (Object[]) environment.getActiveProfiles());
        }
        log.info("Web app started");
    }

    
    @Bean
    public CorsFilter corsFilter() {
    	final CorsConfiguration configuration = new CorsConfiguration();
    	configuration.setAllowedOrigins(Collections.singletonList("*"));
    	configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
    	configuration.setAllowCredentials(true);
    	configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
            log.debug("Registering CORS filter");
            source.registerCorsConfiguration("/api/**", configuration);
        return new CorsFilter(source);
    }

}
