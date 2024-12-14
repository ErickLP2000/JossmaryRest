package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProductosDAO;
import com.proyecto2.demo.entidad.Productos;


@Service
public class ProductosServiceImp extends ICRUDImp<Productos , Long>{

    @Autowired
    private IProductosDAO productosDAO;

    @Override
    public JpaRepository<Productos, Long> getJpaRepository() {
        // TODO Auto-generated method stub
        return productosDAO;
    }

    
}
