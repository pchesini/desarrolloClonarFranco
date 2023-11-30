
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Oferta;
import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Repository.OfertaRepository;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaService implements IOfertaService {
    
    @Autowired 
    private OfertaRepository ofertaR;

    @Override
    public List<Oferta> getOfertas() {
        List<Oferta> listaOfertas = ofertaR.findAll();
        return listaOfertas;
    }

    @Override
    public void saveOferta(Oferta of) {
        ofertaR.save(of);
    }

    @Override
    public void deleteOferta(Long id) {
        ofertaR.deleteById(id);
    }

    @Override
    public Oferta buscarOferta(long id) {
         Oferta ofertaBuscada = ofertaR.findById(id).orElse(null);// aca deberia implemenarse una logica para devolver algun mensaje
        return ofertaBuscada;
    }

    @Override
    public void verOfertaPorNombre(String nombreProducto) {
        Optional<Oferta> ofertaEncontrada = ofertaR.findByProductoNombre(nombreProducto);

         if (ofertaEncontrada.isPresent()) {
            Oferta oferta = ofertaEncontrada.get();
            // Imprimir la información de la oferta
            System.out.println("ID: " + oferta.getId());
            System.out.println("Stock: " + oferta.getStock());
            System.out.println("Precio: " + oferta.getPrecio());
            System.out.println("Vigencia: " + oferta.getVigencia());

            // Imprimir la información del producto asociado
            Producto producto = oferta.getProducto();
            System.out.println("Producto asociado:");
            System.out.println("  Nombre: " + producto.getNombre());
            System.out.println("  Descripción: " + producto.getDescripcion());
        } else {
            System.out.println("Oferta no encontrada para el producto con nombre: " + nombreProducto);
        }
    
    }    
        // cambia correctamente a la vigencia a la fecha actual
    @Override
    public void detenerOfertaPorId(Long id) {
   Oferta oferta = ofertaR.findById(id).orElse(null);

        if (oferta != null) {
           oferta.setVigencia(new java.sql.Date(System.currentTimeMillis()));
            ofertaR.save(oferta);
        } else {
            System.out.println("No se encontró la oferta con el ID proporcionado: " + id);
        }
    }    
    //detiene las ofertas cuya vigencia es posterior a la fecha ingresada por parametro 
    // osea me devuelve las Ofertas que cumplen con esa fecha
    @Override
    public List<Oferta> detenerOfertasPorFecha(Date fecha) {
        return ofertaR.findByVigenciaBefore(fecha);   
    }
}
