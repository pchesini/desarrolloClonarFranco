/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Venta;
import com.grupo_1.grupo_1.Repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaR;
    
    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaR.findAll();
        return listaVentas;
    }
    
}
