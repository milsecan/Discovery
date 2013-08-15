/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.XXXX
 */
package com.discovery.business;

import com.discovery.business.test.ComunicacionTest;
import com.discovery.core.DeviceClient;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class DiscoveryDeviceFacade {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DiscoveryDeviceFacade.class);
    private HashMap<String, DeviceClient> deviceClients = new HashMap<String, DeviceClient>();

    public void addDeviceClient(String identificador, DeviceClient deviceClient) {

        this.deviceClients.put(identificador, deviceClient);
        inicializarComunicacionPrueba(identificador);
    }

    public void inicializarComunicacionPrueba(String identificador) {

        Thread mThread = new Thread(new ComunicacionTest(deviceClients.get(identificador)));
        mThread.start();

        Thread mThread2 = new Thread(new ComunicacionTest(deviceClients.get(identificador)), "HIl000000000000000");
        mThread2.start();
    }

    public String testSpring() {
        return "utilizando spring xxxxxxxxxxxxxxxxxxxxxxxxxxx !!!!!";
    }
}
