/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.CuentaBancaria;
import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Servicio.CuentaBancariaService;
import com.grupo_1.grupo_1.Servicio.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banco-cuenta")
public class AsociarCuentaController {
     @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private CuentaBancariaService cuentaBancariaService;

    @PostMapping("/{idProveedor}")
    public ResponseEntity<String> asociarBancoCuenta(@PathVariable Long idProveedor, @RequestBody CuentaBancaria cuentaBancaria) {
        try {
            Proveedor proveedor = proveedorService.buscarProveedor(idProveedor);

            if (proveedor != null) {
                cuentaBancaria.setProveedor(proveedor);
                cuentaBancariaService.saveCuentaBancaria(cuentaBancaria);
                return ResponseEntity.ok("Cuenta bancaria asociada correctamente al proveedor con ID: " + idProveedor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado con ID: " + idProveedor);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
}
