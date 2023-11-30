package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.EntidadBancaria;
import com.grupo_1.grupo_1.Servicio.IEntidadBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("EntidadBancaria")
public class EntidadBancariaController {

    
    @Autowired
    private IEntidadBancaria entidadBancariaI;
   
    @GetMapping("/lista")
    public List<EntidadBancaria> getEntidadBancaria(){
        return entidadBancariaI.getEntidadBancaria();
    }

}


