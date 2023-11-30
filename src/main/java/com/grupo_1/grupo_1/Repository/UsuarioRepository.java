/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Repository;

import com.grupo_1.grupo_1.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // uso de query metodh para buscar en la bd si existe el usuario para crearlo  o no
    Usuario findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    // metodo para buscar usuario por email y poder asociarlo a un proveedor.
    Usuario findByEmail(String email);
}

