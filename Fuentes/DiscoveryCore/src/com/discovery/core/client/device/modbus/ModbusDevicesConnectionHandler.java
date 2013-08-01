/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.modbus;


import com.discovery.core.DevicesConnectionHandler;
import com.discovery.core.DiscoveryDeviceFacade;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import net.wimpi.modbus.net.TCPMasterConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author USER
 */
public class ModbusDevicesConnectionHandler implements DevicesConnectionHandler{
    
    static final org.apache.log4j.Logger logger = Logger.getLogger(ModbusDevicesConnectionHandler.class);
    private List<String> ips;
    
    public ModbusDevicesConnectionHandler(List<String> ips) {
        this.ips = ips;
    }
    
    public ModbusDevicesConnectionHandler(String ip) {
        ips.add(ip);        
    }
    
    public void run() {
        
        String tempIP  = null;
        if (ips.size() > 0) {
            for (Iterator<String> it = ips.iterator(); it.hasNext();) {
                try {
                    
                    tempIP =it.next();
                    new ModbusConnectionInitializer(this, tempIP, "8575").start();
                    
                } catch (UnknownHostException ex) {                   
                    logger.error("Error inicializando conexion con ip "+tempIP, ex);
                }               

            }
        }
    }

    @Override
    public <T> void notifyConnection(T connection) {
        
       TCPMasterConnection conn = (TCPMasterConnection)connection;               
       
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanFactory beanFactory = appContext;
        DiscoveryDeviceFacade facade = (DiscoveryDeviceFacade) beanFactory.getBean("deviceFacade");
        facade.addDeviceClient(conn.getAddress().getHostAddress(), new ModbusDevicesClient(null));
        
    }    
    
    
}
