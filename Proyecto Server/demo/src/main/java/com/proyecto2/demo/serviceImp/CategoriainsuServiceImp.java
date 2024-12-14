package com.proyecto2.demo.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ICategoriainsuDAO;
import com.proyecto2.demo.entidad.Categoriainsu;

@Service
public class CategoriainsuServiceImp extends ICRUDImp<Categoriainsu, Long>{

    @Autowired
    private ICategoriainsuDAO categoriainsuDAO;

    @Override
    public JpaRepository<Categoriainsu, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return categoriainsuDAO;
    }

    
    
}
