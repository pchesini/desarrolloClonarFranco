/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.CuentaBancaria;
import java.util.List;

/**

 */
public interface ICuentaBAncaria {
     // traer cb
    public List<CuentaBancaria>getCuentaBancarias();
     
    // alta cb
    public void saveCuentaBancaria(CuentaBancaria cb); 
     // eliminar cb
     public void  deleteCuentaBancaria(Long id);
    // buscar cb por id
     public CuentaBancaria buscarCuentaBancaria(Long id);
}
