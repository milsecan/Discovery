/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.model.mappers;

import com.discovery.model.dtos.SensorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author USER
 */
public class SensorMapper implements RowMapper<SensorDTO>{   
   

    @Override
    public SensorDTO mapRow(ResultSet rs, int i) throws SQLException {
        
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setCodigo(rs.getString("codigo"));
        
        return sensorDTO;
    }
    
    
     
    
    
}
