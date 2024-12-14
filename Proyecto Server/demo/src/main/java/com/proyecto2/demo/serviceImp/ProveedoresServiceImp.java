package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProveedoresDAO;
import com.proyecto2.demo.entidad.Proveedores;

@Service
public class ProveedoresServiceImp extends ICRUDImp<Proveedores , Long>{

    @Autowired
    private IProveedoresDAO proveedoresDAO;

    @Override
    public JpaRepository<Proveedores, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return proveedoresDAO;
    }

    
}
