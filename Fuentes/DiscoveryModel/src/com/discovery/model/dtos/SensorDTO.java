/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discovery.model.dtos;

/**
 *
 * @author USER
 */
public class SensorDTO {    
    
    private int id;
    private String codigo;
    private String direccion;
    private int posicion_inicial;
    private int longitud;
    private int unidad_id;
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the posicion_inicial
     */
    public int getPosicion_inicial() {
        return posicion_inicial;
    }

    /**
     * @param posicion_inicial the posicion_inicial to set
     */
    public void setPosicion_inicial(int posicion_inicial) {
        this.posicion_inicial = posicion_inicial;
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the unidad_id
     */
    public int getUnidad_id() {
        return unidad_id;
    }

    /**
     * @param unidad_id the unidad_id to set
     */
    public void setUnidad_id(int unidad_id) {
        this.unidad_id = unidad_id;
    }   
    
    
}
