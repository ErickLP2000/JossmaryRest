package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Documento;

public interface IDocumentoDAO extends JpaRepository<Documento, Long>{
    
    public List<Documento> findAllByOrderByNombre();
	   public List<Documento> findByNombre(String nombre);
	   public List<Documento> findByIdLessThan(Long id);
}
