package com.grupo_1.grupo_1.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo_1.grupo_1.Modelo.Cliente;
import com.grupo_1.grupo_1.Repository.ClienteRepository;


@Service
public class ClienteService implements ICliente{
  @Autowired
    private ClienteRepository clienteR;
   
    @Override
    public Cliente getCliente() {
        
        return clienteR.getReferenceById(Long.MIN_VALUE);
    }

        
}
