package com.proyecto2.demo.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IClientesDAO;
import com.proyecto2.demo.entidad.Cliente;

@Service
public class ClientesServiceImp extends ICRUDImp<Cliente , Long>{
    
    @Autowired
	private IClientesDAO clientesDAO;

	@Override
	public JpaRepository<Cliente, Long> getJpaRepository() {
		// TODO Auto-generated method stub
		return clientesDAO;
	}
	
}
