package com.proyecto2.demo.serviceImp;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.service.ICRUD;

public abstract class ICRUDImp<T, ID> implements ICRUD<T, ID>{

    public abstract JpaRepository<T, ID> getJpaRepository();

    

    @Override
    public T actualizar(T bean) throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().save(bean);
    }

    @Override
    public T buscar(ID cod) throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().findById(cod).orElse(null);
    }

    


    @Override
    public List<T> listar() throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().findAll();
    }



    @Override
    public void eliminar(ID cod) throws Exception {
        // TODO Auto-generated method stub
        getJpaRepository().deleteById(cod);
    }



    @Override
    public T registrar(T bean) throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().save(bean);
    }
}
