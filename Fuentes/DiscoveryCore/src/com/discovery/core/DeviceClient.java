/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core;

import com.discovery.core.message.Message;
import com.discovery.model.dtos.SensorDTO;

/**
 *
 * @author USER
 */
public interface DeviceClient {

    public  String sendRequest(Message mensaje, SensorDTO destino);
    public void start();
}
