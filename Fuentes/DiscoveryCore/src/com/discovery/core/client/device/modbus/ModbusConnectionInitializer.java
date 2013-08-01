/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.modbus;

import com.discovery.core.ConnectionInitializer;
import com.discovery.core.DevicesConnectionHandler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import net.wimpi.modbus.net.TCPMasterConnection;
import org.apache.log4j.Logger;


public class ModbusConnectionInitializer implements Runnable, ConnectionInitializer {

    static final org.apache.log4j.Logger logger = Logger.getLogger(ModbusConnectionInitializer.class);
    private Thread runner = null;
    private DevicesConnectionHandler devicesConnectionHandler;
    private String ip;
    private boolean isNotConnected;
    static final int MAX_INTENTOS = 5;
    private TCPMasterConnection tcpMasterConnection = null;

    public ModbusConnectionInitializer(DevicesConnectionHandler devicesConnectionHandler, String ip, String port) throws UnknownHostException {

        this.devicesConnectionHandler = devicesConnectionHandler;
        this.isNotConnected = true;
        tcpMasterConnection = new TCPMasterConnection(InetAddress.getByName(ip));
        tcpMasterConnection.setPort(Integer.parseInt(port));       

    }

    @Override
    public void run() {
        int intentos = 1;
        while (isNotConnected & (intentos <= MAX_INTENTOS)) {
            try {
                tcpMasterConnection.connect();
            } catch (Exception ex) {
                logger.error(ex.getCause(), ex);
                logger.debug("Falló en intento de conexión numero " + intentos, ex);
            }
            if (tcpMasterConnection.isConnected()) {
                isNotConnected = false;
                devicesConnectionHandler.notifyConnection(tcpMasterConnection);

            }

        }
    }


    public void start() {
        runner = new Thread(this);
        runner.start();
    }
}
