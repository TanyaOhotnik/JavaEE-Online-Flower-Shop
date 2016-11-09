//package com.mkr.filters;
//
//import java.io.IOException;
//import javax.servlet.*;
//import org.jboss.security.SecurityAssociation;
///**
// * Created by Tanya Ohotnik on 07.11.2016.
// */
//
//public class LoginFilter implements Filter {
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,
//            ServletException {
//
//        String userName = SecurityAssociation.getPrincipal().getName();
//
//        System.out.println("Yeeey! Get me here and find me in the database: " + userName);
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//}