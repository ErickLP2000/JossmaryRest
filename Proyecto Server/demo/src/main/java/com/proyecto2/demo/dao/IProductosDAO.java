package com.proyecto2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Productos;

public interface IProductosDAO extends JpaRepository<Productos,Long>{
    
}
