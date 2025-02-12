package com.mac.management_of_employees.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

/**
 * Interceptor implementation used for logging HTTP request headers.
 * This interceptor is designed to log all headers present in incoming HTTP requests,
 * allowing better visibility and debugging during the request lifecycle.
 */
@Component
public class HeaderLoggingInterceptor implements HandlerInterceptor {

    /**
     * Logger instance for the HeaderLoggingInterceptor class.
     * Used to log informational and debugging messages related to HTTP request headers.
     * This helps in tracking and analyzing the headers present in incoming HTTP requests.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderLoggingInterceptor.class);


    /**
     * Logs all HTTP request headers for debugging and tracking purposes.
     * This method is executed before the actual handler (controller) method.
     *
     * @param request the HTTP request being processed
     * @param response the HTTP response to be sent to the client
     * @param handler the chosen handler to execute, for type and/or instance examination
     * @return true to indicate that the execution chain should proceed to the next interceptor or the handler itself
     * @throws Exception in case of any errors during processing
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("Ditails of the request headers:");
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                LOGGER.info("HeaderS: {}: {}", headerName, headerValue);
            }
        }
        return true;
    }
}
