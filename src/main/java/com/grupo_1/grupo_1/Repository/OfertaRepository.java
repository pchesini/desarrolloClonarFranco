/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Repository;

import com.grupo_1.grupo_1.Modelo.Oferta;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfertaRepository extends JpaRepository <Oferta, Long> {
     // Método para buscar una oferta por el nombre del producto
    Optional<Oferta> findByProductoNombre(String nombreProducto);
    List<Oferta> findByVigencia(Date vigencia);
    List<Oferta> findByVigenciaBefore(Date fecha);
}
