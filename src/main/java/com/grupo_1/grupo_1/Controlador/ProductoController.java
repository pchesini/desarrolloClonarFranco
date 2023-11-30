/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Controlador;

import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Servicio.IProductoService;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

/**r
 *
 * aca va a recibir las peticiones del cliente por medio de los metodos http
 * por lo que se debe configurar los endpoints
*/

@RestController 
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private IProductoService iProducto;// declaro una variable para usar los metodos de esa clase
    
    //peticion get
    //@RolesAllowed("SYS_ADMIN")
    @GetMapping("/lista")
    public List<Producto> getProductos(){
       return iProducto.getProductos();
    }
    //peticion Post
   // @RolesAllowed("SYS_ADMIN")
    @PostMapping("/alta")
    // el objeto va en el body por eso el @RequestBody
    public String saveProducto(@RequestBody Producto p){
        iProducto.saveProducto(p);
        return " Producto creado con exito!";
    }

    @DeleteMapping ("/borrar/{id}")
    public String deleteProducto(@PathVariable Long id){
        iProducto.deleteProducto(id);
        return "Producto Eliminado";
    }

    
   
    // lo dejamos por si hay algun error en la carga o alta del producto
    @PutMapping("editar/{id}")
    public Producto editarProducto(@PathVariable Long id,
                                    @RequestParam ("codigo") int nuevoCodigo,
                                    @RequestParam("nombre") String nuevoNombre,
                                    @RequestParam("descripcion") String nuevaDescripcion){
        //declaro una variable pord de tipo pporducto y la busco con el id que me trajo el parametro
        Producto prod = iProducto.buscarProducto(id);
        prod.setCodigo(nuevoCodigo);
        prod.setNombre(nuevoNombre);
        prod.setDescripcion(nuevaDescripcion);
        // guardo el producto y lo retorno 
        iProducto.saveProducto(prod);
        return prod;
    }
}
