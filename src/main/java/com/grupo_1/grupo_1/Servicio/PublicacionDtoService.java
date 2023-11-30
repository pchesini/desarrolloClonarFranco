/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Categoria;
import com.grupo_1.grupo_1.Modelo.Oferta;
import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Repository.OfertaRepository;
import com.grupo_1.grupo_1.Dto.PublicacionDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionDtoService implements IPublicacionDto {
     @Autowired
    private OfertaRepository ofertaR; 
    
    @Override
    public List<PublicacionDto> obtenerPublicacionesConInfo() {
        // Obtener todas las ofertas desde el repositorio
        List<Oferta> ofertas = ofertaR.findAll();

        // Mapear las ofertas a PublicacionDTO
        return ofertas.stream()
                .map(this::mapToPublicacionDto)
                .collect(Collectors.toList());
    }

    private PublicacionDto mapToPublicacionDto(Oferta oferta) {
        PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setOfertaId(oferta.getId());
        publicacionDto.setStock(oferta.getStock());
        publicacionDto.setPrecio(oferta.getPrecio());
        publicacionDto.setVigencia(oferta.getVigencia());

        // Obtener información del producto y la categoría
        Producto producto = oferta.getProducto();
        if (producto != null) {
            publicacionDto.setNombreProducto(producto.getNombre());
            publicacionDto.setDescripcionProducto(producto.getDescripcion());

            Categoria categoria = producto.getCategoria();
            if (categoria != null) {
                publicacionDto.setNombreCategoria(categoria.getDescripcion());
            }
        }

        return publicacionDto;
    }
}
