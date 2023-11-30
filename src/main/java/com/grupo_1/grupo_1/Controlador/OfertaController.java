package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.Oferta;
import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Servicio.IOfertaService;
import com.grupo_1.grupo_1.Servicio.ProductoService;
import jakarta.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oferta")
public class OfertaController {

    @Autowired
    private IOfertaService ofertaI;
    @Autowired
    private ProductoService productoService;

    // @RolesAllowed("SYS_ADMIN")
    @GetMapping("/lista")
    public List<Oferta> getOfertas() {
        return ofertaI.getOfertas();
    }

    @PostMapping("/alta")
    public String saveOferta(@RequestParam Long idProducto, @RequestBody Oferta oferta) {
        // Buscar el producto por su ID
        Producto prodbuscado = productoService.buscarProducto(idProducto);

        if (prodbuscado != null) {

            oferta.setProducto(prodbuscado);

            // Guardar la oferta
            ofertaI.saveOferta(oferta);

            return "Oferta creada y asociada al producto correctamente.";
        } else {
            return "Error: No se encontró el producto con el ID proporcionado.";
        }
    }

    // implementar detener oferta por vigencia
    @DeleteMapping("eliminar")/// esto seria detener oferta
    public String deleteOferta(@PathVariable Long id) {
        ofertaI.deleteOferta(id);
        return " Oferta Eliminada";
    }

    // detiene la oferta seteandola la vigencia con la fecha actual
    @PutMapping("/detener/{id}")
    public String detenerOferta(@PathVariable Long id) {
        ofertaI.detenerOfertaPorId(id);
        
        return "Oferta en Stop!.";
    }

    @PutMapping("/editar/{id}")
    public Oferta editarOferta(@PathVariable Long id,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("stock") int nuevoStock,
            @RequestParam("codigoOferta") int nuevioCodigo,
            @RequestParam("precio") float nuevoPrecio,
            @RequestParam("vigencia") @DateTimeFormat(pattern = "dd-MM-yyyy") Date nuevaVigencia) {

        Oferta oferta = ofertaI.buscarOferta(0);
        oferta.setStock(nuevoStock);
        oferta.setStock(nuevoStock);
        oferta.setPrecio(0);
        java.sql.Date ConvertirASql = new java.sql.Date(nuevaVigencia.getTime());
        oferta.setVigencia(ConvertirASql);

        ofertaI.saveOferta(oferta);

        return oferta;
    }
}
