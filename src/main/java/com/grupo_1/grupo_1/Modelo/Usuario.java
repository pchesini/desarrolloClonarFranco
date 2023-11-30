/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public  class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Basic 
    private String nombreUsuario;
    private String email;
  
    

    // Constructor
    public Usuario(){}
    
    public Usuario(String nombreUsuario,String email) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
       
    }
    @OneToOne(mappedBy = "usuario")
    private Proveedor proveedor;  
}
