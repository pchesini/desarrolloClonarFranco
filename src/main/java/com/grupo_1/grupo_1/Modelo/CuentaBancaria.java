package com.grupo_1.grupo_1.Modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
@AllArgsConstructor
public class CuentaBancaria {
    
    
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id 
    private Long id;
    private String cuu;
    private double saldo;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @OneToOne
    private EntidadBancaria entidadBancaria;
    
}
