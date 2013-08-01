/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.business.test;

import com.discovery.core.DeviceClient;

/**
 *
 * @author USER
 */
public class ComunicacionTest implements Runnable {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ComunicacionTest.class);
    DeviceClient deviceClient;

    public ComunicacionTest(DeviceClient deviceClient) {
        this.deviceClient = deviceClient;
    }

    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            logger.info("Escribiendo Mensaje "+i);
            String response = deviceClient.sendRequest("");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                logger.error("error intentando pausar hilo de ejecución", ex);
            }
        }

    }
}
