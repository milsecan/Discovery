/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.modbus;

import com.discovery.core.DeviceClient;
import com.discovery.core.message.Message;
import com.discovery.model.dtos.SensorDTO;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import net.sf.json.JSONObject;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadInputDiscretesRequest;
import net.wimpi.modbus.msg.ReadInputDiscretesResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

/**
 *
 * @author USER
 */
public class ModbusDevicesClient implements DeviceClient, Runnable {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ModbusDevicesClient.class);
    
    //hugo
    
    TCPMasterConnection con = null; //the connection
    ModbusTCPTransaction trans = null; //the transaction
    ReadInputDiscretesRequest req = null; //the request
    ReadInputDiscretesResponse res = null; //the response
    /*
     * Variables for storing the parameters
     */
    InetAddress addr = null; //the slave's address
    int port = 7070;//Modbus.DEFAULT_PORT;
    int ref = 0; //the reference; offset where to start reading from
    int count = 0; //the number of DI's to read
    int repeat = 1; //a loop for repeating the transaction
    private Thread runner = null;
    private Socket deviceSokect = null;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    private boolean connected = true;
    InputStreamReader isr = null;
    private final String TAG = ModbusDevicesClient.class.getName();

    public ModbusDevicesClient(TCPMasterConnection masterConnection) {

        this.con = masterConnection;
        
        this.deviceSokect = deviceSokect;
      
        try {
            reader = new BufferedReader(new InputStreamReader(this.deviceSokect.getInputStream()));
            isr = new InputStreamReader(this.deviceSokect.getInputStream());
            writer = new BufferedWriter(new OutputStreamWriter(this.deviceSokect.getOutputStream()));

        } catch (IOException ex) {           
            logger.error(ex.getMessage(), ex);
        }

    }

    @Override
    public void run() {
        //log.logger.log(Level.INFO, "el cliente " + deviceSokect.getInetAddress() + " se conecto");
        
        while (connected) {
            try {
                if (reader.ready()) {
                    String msg = reader.readLine();

                    //log.logger.log(Level.INFO, "cliente escribio : " + msg);
                    if (msg.equalsIgnoreCase("hola")) {

                        JSONObject json = new JSONObject();

                        json.put("email", "miche@hola.com");
                        json.put("nombre", "miche");

                        writer.write(json.toString());
                        writer.flush();

                    }
                }
            } catch (IOException e) {
               
                
            }
        }
    }

    //
    public void start() {
        
        runner = new Thread(this);
        runner.start();
    }

    @Override
    public String sendRequest(Message mensaje , SensorDTO destino) {
        
        throw new UnsupportedOperationException("Not supported yet.");      
        
    }
}
