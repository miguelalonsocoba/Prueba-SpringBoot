package com.mac.management_of_employees;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The AppConfig class is a configuration class that implements the WebMvcConfigurer interface.
 * It is responsible for adding and configuring custom interceptors in the application's web MVC context.
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * A HandlerInterceptor instance that logs HTTP request headers.
     * This interceptor is registered in the application's WebMvc configuration
     * and is responsible for processing headers of incoming HTTP requests.

     * The interceptor is applied to all HTTP requests by default through the interceptor registry setup.
     */
    HandlerInterceptor headerLoggingInterceptor;

    public AppConfig(@Qualifier("headerLoggingInterceptor") HandlerInterceptor headerLoggingInterceptor) {
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }

    /**
     * Adds custom interceptors to the application's interceptor registry.
     * This method registers the "headerLoggingInterceptor" to intercept all HTTP requests
     * by matching the specified path pattern.
     *
     * @param registry the {@link InterceptorRegistry} used to register custom interceptors
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerLoggingInterceptor).addPathPatterns("/**");
    }
}
