/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Dto.PublicacionDto;
import com.grupo_1.grupo_1.Servicio.IPublicacionDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/home")
public class PublicacionDtoController {
    @Autowired
    private IPublicacionDto IPubliDto;  // Reemplaza con el nombre de tu servicio

    @GetMapping("/obtener")
    public ResponseEntity<List<PublicacionDto>> obtenerPublicacionesConInfo() {
        List<PublicacionDto> publicaciones = IPubliDto.obtenerPublicacionesConInfo();
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }
}
