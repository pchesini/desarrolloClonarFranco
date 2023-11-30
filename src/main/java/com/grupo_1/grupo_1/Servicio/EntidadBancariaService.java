package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.EntidadBancaria;
import com.grupo_1.grupo_1.Repository.EntidadBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadBancariaService implements IEntidadBancaria{
    @Autowired
    private EntidadBancariaRepository EntidadBancariaR;


    @Override
    public List<EntidadBancaria> getEntidadBancaria() {
        List<EntidadBancaria> listaEntidadesBancarias = EntidadBancariaR.findAll();
        return listaEntidadesBancarias;
    }
}
