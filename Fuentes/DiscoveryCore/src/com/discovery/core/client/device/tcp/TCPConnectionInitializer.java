/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.tcp;


import com.discovery.core.ConnectionInitializer;
import com.discovery.core.DevicesConnectionHandler;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import net.wimpi.modbus.net.TCPMasterConnection;

/**
 *
 * @author USER
 */
public class TCPConnectionInitializer implements Runnable, ConnectionInitializer {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TCPConnectionInitializer.class);
    private Thread runner = null;
    private DevicesConnectionHandler devicesConnectionHandler;
    private String ip;
    private boolean isNotConnected;
    private Socket deviceSocket;
    static final int MAX_INTENTOS = 5;
    TCPMasterConnection tcpMasterConnection = null;

    public TCPConnectionInitializer(TCPDevicesConnectionHandler devicesConnectionHandler, String ip) {
        
        this.devicesConnectionHandler = devicesConnectionHandler; 
        this.isNotConnected = true;
        
    }

    @Override
    public void run() {
        int intentos = 1;
        while (isNotConnected & (intentos <= MAX_INTENTOS)) {
            try {
                deviceSocket = new Socket(this.ip, 5555);
                //deviceSocket = new Socket(ip, port)
                
                if (deviceSocket.isConnected()) {
                    isNotConnected = false;
                    devicesConnectionHandler.notifyConnection(deviceSocket);
                }

            } catch (UnknownHostException ex) {
                logger.error(ex.getCause(), ex);
                logger.debug("Falló en intento de conexión numero " + intentos, ex);
            } catch (IOException ex) {
                logger.error(ex.getCause(), ex);
                logger.debug("Falló en intento de conexión numero " + intentos, ex);
            }
        }
    }

    public void start() {
        runner = new Thread(this);
        runner.start();
    }
}
