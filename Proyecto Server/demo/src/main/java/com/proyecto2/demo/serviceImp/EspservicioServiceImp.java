package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IEspservicioDAO;
import com.proyecto2.demo.entidad.Espservicio;

@Service
public class EspservicioServiceImp extends ICRUDImp<Espservicio , Long>{

    @Autowired
    private IEspservicioDAO espservicioDAO;

    @Override
    public JpaRepository<Espservicio, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return espservicioDAO;
    }

    
    
}
