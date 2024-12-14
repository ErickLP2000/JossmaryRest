package com.proyecto2.demo.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IDistritoDAO;
import com.proyecto2.demo.entidad.Distrito;

@Service
public class DistritoServiceImp extends ICRUDImp<Distrito , Long>{

    @Autowired
    private IDistritoDAO distritoDAO;

    @Override
    public JpaRepository<Distrito, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return distritoDAO;
    }

    
    
}
