/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@AllArgsConstructor
public class Venta {
    
    
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id 
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "vigencia")
    private Date vigencia;
    private double montoTotal;
    private String descrpcion;
    
    @OneToOne
    @JoinColumn(name = "id_oferta")
    private Oferta oferta;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
}
