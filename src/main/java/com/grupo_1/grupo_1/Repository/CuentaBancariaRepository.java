package com.grupo_1.grupo_1.Repository;

import com.grupo_1.grupo_1.Modelo.CuentaBancaria;
import com.grupo_1.grupo_1.Modelo.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
}
