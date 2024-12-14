package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Categoriainsu;

public interface ICategoriainsuDAO extends JpaRepository<Categoriainsu, Long>{

    public List<Categoriainsu> findAllByOrderByNombre();
	public List<Categoriainsu> findByNombre(String nombre);
	public List<Categoriainsu> findByIdLessThan(Long id);
}
