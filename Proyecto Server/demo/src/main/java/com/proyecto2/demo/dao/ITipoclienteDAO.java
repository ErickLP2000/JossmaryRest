package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Tipocliente;

public interface ITipoclienteDAO extends JpaRepository<Tipocliente,Long>{


    public List<Tipocliente> findAllByOrderByNombre();
	   public List<Tipocliente> findByNombre(String nombre);
	   public List<Tipocliente> findByIdLessThan(Long id);
    
    
}
