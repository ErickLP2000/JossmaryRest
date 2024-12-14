package com.proyecto2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Servicios;


public interface IServiciosDAO extends JpaRepository<Servicios,Long>{
    
}
