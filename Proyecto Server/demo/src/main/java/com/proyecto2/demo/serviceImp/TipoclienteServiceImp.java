package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ITipoclienteDAO;
import com.proyecto2.demo.entidad.Tipocliente;

@Service
public class TipoclienteServiceImp extends ICRUDImp<Tipocliente , Long>{

    @Autowired
    private ITipoclienteDAO tipoclienteDAO;

	@Override
	public JpaRepository<Tipocliente, Long> getJpaRepository() {
		// TODO Auto-generated method stub
		return tipoclienteDAO;
	}

    
    
}
