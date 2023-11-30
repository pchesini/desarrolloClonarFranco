/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Modelo.Usuario;
import java.util.List;

public interface IUsuario {
    
    public Usuario findByEmail(String email);
    public Usuario findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    public List<Usuario>getUsuarios();
    public void saveUsuario(Usuario usu); 
     
 
}
