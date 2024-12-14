package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.entidad.Espservicio;

public interface IEspservicioDAO extends JpaRepository<Espservicio,Long>{

    public List<Espservicio> findAllByOrderByNombre();
	public List<Espservicio> findByNombre(String nombre);
	public List<Espservicio> findByIdLessThan(Long id);
    
}
