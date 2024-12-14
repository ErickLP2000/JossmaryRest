package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IServiciosDAO;
import com.proyecto2.demo.entidad.Servicios;

@Service
public class ServiciosServiceImp extends ICRUDImp<Servicios , Long>{

    @Autowired
    private IServiciosDAO serviciosDAO;

    @Override
    public JpaRepository<Servicios, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return serviciosDAO;
    }

    
}
