/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.client.device.tcp;


import com.discovery.core.DeviceClient;
import com.discovery.core.message.Message;
import com.discovery.model.dtos.DeviceMessage;
import com.discovery.model.dtos.SensorDTO;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 *
 * @author mcantillo
 */
public class TCPDevicesClient implements Runnable, DeviceClient {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TCPDevicesClient.class);
    private Thread runner = null;
    private Socket deviceSokect = null;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    private boolean connected = true;
    
    InputStreamReader isr = null;
    private final String TAG = TCPDevicesClient.class.getName();
    private boolean flagRepuestaSincrona = false;
    private final Boolean monitor = true;

    public TCPDevicesClient(Socket deviceSokect) {
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
        logger.info("arrancando proceso de escucha");
        while (this.deviceSokect.isConnected()) {
            // while (connected) {

            try {
                if (reader.ready()) {
                    String msg = reader.readLine();

                    logger.info("dispositivo  respondió : " + msg);
                    //En este punto se debe tratar el mensaje para saber si es de petición o de notificación
                    
                    
                    //si llegó la respuesta asicrona entonces se despierta al hila que la está esperando
                    if (msg.equalsIgnoreCase("S")) {


                        synchronized (monitor) {
                            flagRepuestaSincrona = true;
                            monitor.notify();
                        }

                    }
                }
            } catch (IOException e) {
                logger.error("Error de comunicación con dispositivo", e);
                this.connected = false;

            }
        }
    }

    //
    public void start() {
        runner = new Thread(this);
        runner.start();
    }

    public synchronized String sendRequest(String mensaje) {


        JSONObject json = new JSONObject();
        json.put("email", "miche@hola.com");
        json.put("nombre", "miche");

        try {
            writer.write(json.toString());
            writer.newLine();
            writer.flush();

        } catch (IOException ex) {
            logger.error("Error al enviar mensaje a dispositivo " + deviceSokect.getInetAddress().getHostAddress(), ex);
        }

        while (!flagRepuestaSincrona) {
            try {
                synchronized (monitor) {
                    logger.info("bloqueando al hilo " + Thread.currentThread().getName());
                    monitor.wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TCPDevicesClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        logger.info("hilo desbloqueado " + Thread.currentThread().getName());

        flagRepuestaSincrona = false;
        return "exito";

    }

    private DeviceMessage readJsonResponse(String jsonText) {
        return null;
    }
    
    

    @Override
    public synchronized String sendRequest(Message mensaje, SensorDTO destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
