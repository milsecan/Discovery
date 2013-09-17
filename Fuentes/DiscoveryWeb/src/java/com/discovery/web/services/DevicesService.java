/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.web.services;

import org.springframework.core.task.TaskExecutor;

/**
 *
 * @author Milsiades
 */
public class DevicesService {
    
    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DevicesService.class);

    private TaskExecutor taskExecutor;

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        logger.info("Entrando al constructor XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        this.taskExecutor = taskExecutor;
    }

    public void start() {
        logger.info("Entrando al servicio XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
