/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.Venta;
import com.grupo_1.grupo_1.Servicio.IVentaService;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IVentaService iVenta;

    //peticion get
    @RolesAllowed("SYS_ADMIN")
    @GetMapping("/mostrar")
    public List<Venta> getVentas() {
        return iVenta.getVentas();
       }

}