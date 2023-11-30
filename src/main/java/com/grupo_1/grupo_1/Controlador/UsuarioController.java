/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Modelo.Usuario;
import com.grupo_1.grupo_1.Servicio.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Primary
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuario iUsuario;

    //@RolesAllowed("SYS_ADMIN")
    @PostMapping("/alta")
    // el objeto va en el body por eso el @RequestBody
    public String saveUsuario(@RequestBody Usuario usu){
           // Verificar si el usuario ya existe en la base de datos
    Usuario usuarioExistente = iUsuario.findByNombreUsuarioOrEmail(usu.getNombreUsuario(), usu.getEmail());

    if (usuarioExistente != null) {
        return "El usuario ya existe en la base de datos.";
    } else {
        // El usuario no existe, se puede guardar en la base de datos
        iUsuario.saveUsuario(usu);
        return "Usuario dado de alta!";
    }

    }
}
