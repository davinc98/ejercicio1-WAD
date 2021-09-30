/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
//import lombok.Data;
//import lombok.NoArgsConstructor;

/**
 *
 * @author leoj_
 */

public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private float precio;
    private int existencia;
    private int stockMinimo;
    private int claveCategoria;

    public Producto() {
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getClaveCategoria() {
        return claveCategoria;
    }

    public void setClaveCategoria(int claveCategoria) {
        this.claveCategoria = claveCategoria;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idProducto = ").append(idProducto).append("\n");
        sb.append("nombreProducto = ").append(this.getNombreProducto()).append("\n");
        sb.append("descripcionProducto = ").append(this.getDescripcionProducto()).append("\n");
        return sb.toString();
    }
    
}
