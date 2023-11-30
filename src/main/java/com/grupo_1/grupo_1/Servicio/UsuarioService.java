/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Modelo.Usuario;
import com.grupo_1.grupo_1.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario {
    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioR;
    
   
    @Override
    public List<Usuario> getUsuarios() {
        List <Usuario> listaUsuarios = usuarioR.findAll();
        return listaUsuarios;
    }

    @Override
    public void saveUsuario(Usuario usu) {
        usuarioR.save(usu);
    }

    @Override
    public Usuario findByNombreUsuarioOrEmail(String nombreUsuario, String email) {
        return usuarioR.findByNombreUsuarioOrEmail(nombreUsuario, email);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioR.findByEmail(email);
    }

    

}
