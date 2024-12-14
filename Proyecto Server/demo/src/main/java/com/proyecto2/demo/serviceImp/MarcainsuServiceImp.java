package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IMarcainsuDAO;
import com.proyecto2.demo.entidad.Marcainsu;

@Service
public class MarcainsuServiceImp extends ICRUDImp<Marcainsu , Long>{

    @Autowired
    private IMarcainsuDAO marcainsuDAO;

    @Override
    public JpaRepository<Marcainsu, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return marcainsuDAO;
    }

    
}
