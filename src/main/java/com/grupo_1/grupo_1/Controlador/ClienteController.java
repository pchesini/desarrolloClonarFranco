package com.grupo_1.grupo_1.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo_1.grupo_1.Modelo.Cliente;
import com.grupo_1.grupo_1.Servicio.ICliente;

@RestController
@RequestMapping("ClienteBancaria")
public class ClienteController {

    @Autowired
    private ICliente clienteI;
   @GetMapping("/Cliente/mostrar")
    private Cliente getCliente(){
        return clienteI.getCliente();
    }

}
