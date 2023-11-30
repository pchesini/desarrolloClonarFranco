/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Producto;
import com.grupo_1.grupo_1.Repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *ca se implementan cada metodo declarado en la interface del porducto
 */
@Service
public class ProductoService implements IProductoService{
    // le inyecto el producto
    @Autowired
    private ProductoRepository ProductoR;

    @Override
    //declaro el metodo como un alista de objetos Producto
    // declaro una variable de tiṕo Lista que guarda los productos 
    // el objeto ProductoR entiende el mensaje findAll
    public List<Producto> getProductos() {
        List<Producto> listaProductos = ProductoR.findAll();
        return listaProductos;
     
    }

    @Override
    public void saveProducto(Producto p) {
     ProductoR.save(p);
    }

    @Override
    public void deleteProducto(Long id) {
        ProductoR.deleteById(id);
    }

    @Override
    public Producto buscarProducto(Long id) {
        Producto productoBuscado = ProductoR.findById(id).orElse(null);
        return productoBuscado;
    }
    
}
