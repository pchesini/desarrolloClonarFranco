/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.Proveedor;
import com.grupo_1.grupo_1.Modelo.Usuario;
import com.grupo_1.grupo_1.Repository.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService implements IProveedorService<Proveedor> {
    
    @Autowired
    private ProveedorRepository proveeR;

    @Override
    public List getProveedor() {
       // List <Proveedor> listaProveedores = proveeR.findAll();
        return proveeR.findAll();
    }

    @Override
    public void saveProveedor(Proveedor p) {
        proveeR.save(p);
    }

    @Override
    public void deleteProveedor(Long id) {
        proveeR.deleteById(id);
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
        Usuario usuBuscado = proveeR.findById(id).orElse(null);
        if (usuBuscado instanceof Proveedor) {
            return (Proveedor) usuBuscado;
        } else {
            return null;
        }
    }
}
    
