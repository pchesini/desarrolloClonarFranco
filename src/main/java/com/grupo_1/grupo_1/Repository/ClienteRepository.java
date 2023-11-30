package com.grupo_1.grupo_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo_1.grupo_1.Modelo.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
    
}
