package com.proyecto2.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.demo.dto.ClienteDTO;
import com.proyecto2.demo.entidad.Cliente;
import com.proyecto2.demo.serviceImp.ClientesServiceImp;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientesServiceImp clientesService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<ClienteDTO> listar() throws Exception {
        List<ClienteDTO> lista=clientesService.listar().stream()
        .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
        .collect(Collectors.toList());
        return lista;
    }

    @PostMapping("/registrar") 
    public ClienteDTO registrar(@RequestBody ClienteDTO clienteDTO) throws Exception { 
        Cliente bean=null; 
        bean = modelMapper.map(clienteDTO, Cliente.class); 
        bean = clientesService.registrar(bean); 
        return modelMapper.map(bean, ClienteDTO.class);
    }

    @PutMapping("/actualizar")
    public ClienteDTO actualizar(@RequestBody ClienteDTO clienteDTO) throws Exception {
        Cliente bean=null; 
        bean = modelMapper.map(clienteDTO, Cliente.class);
        bean = clientesService.actualizar(bean);
        return modelMapper.map(bean, ClienteDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        clientesService.eliminar(id);
    }
}
