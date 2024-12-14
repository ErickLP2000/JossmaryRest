package com.proyecto2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Cliente;

public interface IClientesDAO extends JpaRepository<Cliente, Long>{
    
}
