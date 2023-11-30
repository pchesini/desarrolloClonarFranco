/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Producto;
import java.util.List;

/**
 se crea una interface para declararse los metodos de abml y ser usados en la clase concreta
 * productoService
 */
public interface IProductoService {
    // traer productos
    public List<Producto>getProductos();
     
    // alta producto
    public void saveProducto(Producto p); 
     // eliminar Producto
     public void  deleteProducto(Long id);
    // buscar producto por id
     public Producto buscarProducto(Long id);
}
