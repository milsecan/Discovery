/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.web.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Milsiades
 */
public class ServiceContextListener implements ApplicationContextAware , ServletContextListener {

     static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ServiceContextListener.class);
    private ApplicationContext context;
    
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
    
    
    public void contextInitialized(ServletContextEvent sce) {
        
        logger.info("inicilizando contexto BBB BBBB BBBB");
      
    }

    public void contextDestroyed(ServletContextEvent sce){
      
    }

    
}
