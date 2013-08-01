/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core;

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

     
    }

    public String testSpring() {
        return "utilizando spring xxxxxxxxxxxxxxxxxxxxxxxxxxx !!!!!";
    }
}
