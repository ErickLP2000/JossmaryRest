package com.proyecto2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Insumo;

public interface IInsumoDAO extends JpaRepository<Insumo,Long>{
    
}
