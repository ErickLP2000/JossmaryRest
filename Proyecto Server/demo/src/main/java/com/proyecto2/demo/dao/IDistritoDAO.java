package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Distrito;

public interface IDistritoDAO extends JpaRepository<Distrito, Long>{

    public List<Distrito> findAllByOrderByNombre();
	   public List<Distrito> findByNombre(String nombre);
	   public List<Distrito> findByIdLessThan(Long id);
    
}
