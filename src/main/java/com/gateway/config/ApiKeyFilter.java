package com.gateway.config;

import com.gateway.service.RequestLoggingService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY = "secret123";

    private final RequestLoggingService loggingService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String apiKey = request.getHeader("X-API-KEY");

        //  Unauthorized
        if (apiKey == null || !apiKey.equals(API_KEY)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            //  Save log
            loggingService.log(request.getRequestURI(), request.getMethod(), response.getStatus());

            response.getWriter().write("Invalid or Missing API Key");
            return;
        }

        //  Continue request
        filterChain.doFilter(request, response);

        //  Save log AFTER success
        loggingService.log(request.getRequestURI(), request.getMethod(), response.getStatus()
        );
    }
}