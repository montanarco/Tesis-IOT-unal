package com.example.apiGarbageSimulation;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roa.fabio
 */
@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestOrigen = request.getHeader("Origin");
        requestOrigen = requestOrigen == null ? "" : requestOrigen;
        System.out.println("peticion desde ->"+requestOrigen);
        if (requestOrigen.equals("http://localhost:4200")
                || requestOrigen.equals("http://localhost:8080")
                || requestOrigen.equals("http://localhost:8082")
				|| requestOrigen.equals("http://localhost:80")
				|| requestOrigen.equals("http://localhost")
                || requestOrigen.equals("http://192.168.0.11:8080")) {

            response.setHeader("Access-Control-Allow-Origin", requestOrigen);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "origin,content-type,cache-control, accept, authorization, Access-Control-Allow-Headers,X-Auth-Token, X-Requested-With");
            response.setHeader("Access-Control-Expose-Headers", "Location");
            
        } else {
            if (!requestOrigen.isEmpty()) {
                System.out.println("acceso denegado al origen:---> " + requestOrigen);
            }

        }
        response.setHeader("allowOrigen", "Origen no permitido");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
