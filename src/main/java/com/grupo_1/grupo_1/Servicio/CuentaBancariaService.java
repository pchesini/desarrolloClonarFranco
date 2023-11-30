package com.grupo_1.grupo_1.Servicio;

import com.grupo_1.grupo_1.Modelo.CuentaBancaria;
import com.grupo_1.grupo_1.Repository.CuentaBancariaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CuentaBancariaService implements ICuentaBAncaria{
    @Autowired
    private CuentaBancariaRepository CuentaBancariaR;

    @Override
    public List<CuentaBancaria> getCuentaBancarias() {
        List<CuentaBancaria> listaCuentaBancarias = CuentaBancariaR.findAll();
        return listaCuentaBancarias;
     
    }

    @Override
    public void saveCuentaBancaria(CuentaBancaria cb) {
     CuentaBancariaR.save(cb);
    }

    @Override
    public void deleteCuentaBancaria(Long id) {
        CuentaBancariaR.deleteById(id);
    }

    @Override
    public CuentaBancaria buscarCuentaBancaria(Long id) {
        CuentaBancaria cuentaBancariaBuscado = CuentaBancariaR.findById(id).orElse(null);
        return cuentaBancariaBuscado;
    }
    
}
