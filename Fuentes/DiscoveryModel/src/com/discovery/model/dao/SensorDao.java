/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.model.dao;


import com.discovery.model.dtos.SensorDTO;
import java.util.List;



/**
 *
 * @author USER
 */
public  interface  SensorDao  {   
    
    public SensorDTO findSensorById(int id);
    public List<SensorDTO> findSensorByDispositivo(int dispositivoId);
    public boolean save(SensorDTO sensor);
    
    
}
