/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.tcp;

import com.discovery.core.DevicesConnectionHandler;
import com.discovery.core.DiscoveryDeviceFacade;

import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TCPDevicesConnectionHandler implements DevicesConnectionHandler {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TCPDevicesConnectionHandler.class);
    private List<String> ips;

    public TCPDevicesConnectionHandler(List<String> ips) {
        this.ips = ips;
    }

    public TCPDevicesConnectionHandler(String ip) {
        ips.add(ip);

    }

    public void run() {
        if (ips.size() > 0) {
            for (Iterator<String> it = ips.iterator(); it.hasNext();) {
                new TCPConnectionInitializer(this, it.next()).start();

            }
        }
        
        for(String s : ips){
         System.out.println(s);
        }
        
        
    }

    @Override
    public <T> void notifyConnection(T connection) {
        //En este pundo se debe acceder con spring al bean facade , para agregar una nueva instancia de conexión.
        Socket conn = (Socket)connection;
        
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanFactory beanFactory = appContext;
        DiscoveryDeviceFacade facade = (DiscoveryDeviceFacade) beanFactory.getBean("deviceFacade");
        
        TCPDevicesClient tdc = new TCPDevicesClient(conn);
        tdc.start();
        facade.addDeviceClient(conn.getInetAddress().getHostAddress(), tdc); 

    }  
}
