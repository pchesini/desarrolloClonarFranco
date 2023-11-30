/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Modelo.Usuario;
import com.grupo_1.grupo_1.Repository.UsuarioRepository;
import com.grupo_1.grupo_1.Servicio.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/proveedor")
public class ProveedorController {
   
   
    @Autowired
    private IProveedorService iProvee;
    
    @Qualifier("usuarioRepository") 
    @Autowired
    private UsuarioRepository usuarioR;
  
    // asocia un proveedor con un usuario
    @PostMapping("alta")
    public String saveProveedor(@RequestBody Proveedor p, @RequestParam String email) {
    // Verificar si el usuario ya existe en la base de datos
    Usuario usuarioExistente = usuarioR.findByEmail(email);

    if (usuarioExistente != null) {
        // Asociar el proveedor al usuario existente
        p.setUsuario(usuarioExistente);

        // Guardar el proveedor con la asociación
        iProvee.saveProveedor(p);

        return "Proveedor dado de alta y asociado al usuario correctamente!";
    } else {
        // por ahora solo un mensaje , despues deberiamos implementar alguna exepcion
       // o la opcion de crear Usuario podria ser tambien
        return "Error: El usuario no existe, debe crearlo previamente.";
    }
}

   
    @PutMapping("editar/{id}")
    public Proveedor editarProveedor(@PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam("apellido") String nuevoApe,
                                    @RequestParam("direccion") String nuevaDire
                                    ){
        Proveedor provee = iProvee.buscarProveedor(id);
        provee.setNombre(nuevoNombre);
        provee.setApellido(nuevoApe);
        provee.setDireccion(nuevaDire);
        iProvee.saveProveedor(provee);
        return provee;
        
    }
}
