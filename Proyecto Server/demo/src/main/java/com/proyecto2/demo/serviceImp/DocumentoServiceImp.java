package com.proyecto2.demo.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IDocumentoDAO;
import com.proyecto2.demo.entidad.Documento;

@Service
public class DocumentoServiceImp extends ICRUDImp<Documento , Long>{
    
    @Autowired
    private IDocumentoDAO documentoDAO;

	@Override
	public JpaRepository<Documento, Long> getJpaRepository() {
		// TODO Auto-generated method stub
		return documentoDAO;
	}

}
