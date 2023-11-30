/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Modelo.Usuario;
import java.util.List;


public interface IProveedorService<T extends Usuario> {
        
    public List<T>getProveedor();
    
    public void saveProveedor(T Proveedor); 
    
     public void  deleteProveedor(Long id);
    
     public Proveedor buscarProveedor(Long id);
    
}
