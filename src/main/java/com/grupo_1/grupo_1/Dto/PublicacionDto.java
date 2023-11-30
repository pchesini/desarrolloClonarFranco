/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Dto;

import java.sql.Date;
import lombok.AllArgsConstructor;



public class PublicacionDto {
    
    private Long ofertaId;
    private String nombreProducto;
    private float precio;
    private int stock;
    private Date vigencia;
    private String descripcionProducto;
    private String nombreCategoria;

    public PublicacionDto() {
    }

    public PublicacionDto(Long ofertaId, String nombreProducto, float precio, int stock, Date vigencia, String descripcionProducto, String nombreCategoria) {
        this.ofertaId = ofertaId;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.vigencia = vigencia;
        this.descripcionProducto = descripcionProducto;
        this.nombreCategoria = nombreCategoria;
    }

    
    
    public Long getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(Long ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
}
