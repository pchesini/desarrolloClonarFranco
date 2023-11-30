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
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity  
public class Proveedor extends Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String apellido, String dni, String direccion, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    public Proveedor(Long id, String nombre, String apellido, String dni, String direccion, Usuario usuario, String nombreUsuario, String email) {
        super(nombreUsuario, email);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.usuario = usuario;
    }
    
    
    @OneToOne
    private Usuario usuario;
}
