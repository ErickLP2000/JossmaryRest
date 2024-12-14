package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ICatproductoDAO;
import com.proyecto2.demo.entidad.Catproducto;

@Service
public class CatproductoServiceImp extends ICRUDImp<Catproducto , Long>{

    @Autowired
    private ICatproductoDAO catproductoDAO;

    @Override
    public JpaRepository<Catproducto, Long> getJpaRepository(){
        return catproductoDAO;        
    }
    
    
}
