package com.fn.logging;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
public class CustomURLFilter implements Filter {

    private static final String REQUEST_ID = "request_id";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String requestId = UUID.randomUUID().toString();
        servletRequest.setAttribute(REQUEST_ID, requestId);
        logRequest((HttpServletRequest) servletRequest, requestId);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void logRequest(HttpServletRequest request, String requestId) {
        if (request != null) {
            StringBuilder data = new StringBuilder();
            data.append("\nLOGGING REQUEST-----------------------------------\n")
                    .append("[PATH]: ").append(request.getRequestURI()).append("\n");
            data.append("LOGGING REQUEST-----------------------------------\n");

            log.info(data.toString());
        }
    }
}