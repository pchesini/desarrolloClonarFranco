
package com.grupo_1.grupo_1.Modelo;
import jakarta.persistence.Column;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Oferta {
   @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;// 
    private int stock;
    private float precio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date vigencia;
    
    @OneToOne
    @JoinColumn(name = "id_producto")
    
    private Producto producto;
    
    public Oferta(){}

    public Oferta(Long id, int stock, float precio, Date vigencia, Producto producto) {
        this.id = id;
        this.stock = stock;
        this.precio = precio;
        this.vigencia = vigencia;
        this.producto = producto;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
  
    
    

}