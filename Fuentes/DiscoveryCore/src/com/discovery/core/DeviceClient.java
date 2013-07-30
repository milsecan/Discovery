/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core;

/**
 *
 * @author USER
 */
public interface DeviceClient {

    public String sendRequest(String mensaje);
    public void start();
}
