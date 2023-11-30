/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Oferta;
import java.sql.Date;
import java.util.List;

public interface IOfertaService {
    
    public List<Oferta> getOfertas();
    public void saveOferta(Oferta of);
    public void deleteOferta(Long id);
    public Oferta buscarOferta(long id);
    public void verOfertaPorNombre(String nombreProducto); 
    public void detenerOfertaPorId(Long id);
    public List<Oferta> detenerOfertasPorFecha(Date vigencia);
}
