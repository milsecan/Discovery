/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.core.dao.impl;

import com.discovery.core.dtos.SensorDTO;
import com.discovery.core.mappers.SensorMapper;
import com.discovery.dao.SensorDao;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author USER
 */
public class SensorDaoImpl implements SensorDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SensorDTO findSensorById(int id) {

        final String query = "SELECT * FROM sensores WHERE id = ? ";
        SensorDTO sensor = jdbcTemplate.queryForObject(query, new Object[id], new SensorMapper());

        return sensor;
    }

    @Override
    public List<SensorDTO> findSensorByDispositivo(int dispositivoId) {

        final String query = "SELECT s.* from sensores s INNER JOIN sensores_dispositivo sd"
                + " ON s.id = sd.sensor_id"
                + " WHERE sd.id = ?";

        List<SensorDTO> sensores = jdbcTemplate.query(query, new Object[dispositivoId], new SensorMapper());

        return sensores;
    }

    @Override
    public boolean save(SensorDTO sensor) {
        final String query = "INSERT INTO sensores "
                + "(codigo, direccion, posicion_inicial, longitud, unidad_id) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(query, new Object[]{sensor.getCodigo(),
                        sensor.getDireccion(), sensor.getPosicion_inicial(), sensor.getLongitud(), sensor.getUnidad_id()});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
