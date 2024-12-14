package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
    
}
