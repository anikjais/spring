package com.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitilizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //bootstrap dispatcherservlet
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicatrionConfig.class);
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("mvc",new DispatcherServlet());
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}