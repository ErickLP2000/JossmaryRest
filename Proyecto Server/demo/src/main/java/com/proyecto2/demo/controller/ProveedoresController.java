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

import com.proyecto2.demo.dto.ProveedoresDTO;
import com.proyecto2.demo.entidad.Proveedores;
import com.proyecto2.demo.serviceImp.ProveedoresServiceImp;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresServiceImp proveedoresService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<ProveedoresDTO> listar() throws Exception {
        return proveedoresService.listar().stream()
            .map(proveedores -> modelMapper.map(proveedores, ProveedoresDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public ProveedoresDTO registrar(@RequestBody ProveedoresDTO proveedoresDTO) throws Exception {
        Proveedores proveedores = modelMapper.map(proveedoresDTO, Proveedores.class);
        proveedores = proveedoresService.registrar(proveedores);
        return modelMapper.map(proveedores, ProveedoresDTO.class);
    }

    @PutMapping("/actualizar")
    public ProveedoresDTO actualizar(@RequestBody ProveedoresDTO proveedoresDTO) throws Exception {
        Proveedores proveedores = modelMapper.map(proveedoresDTO, Proveedores.class);
        proveedores = proveedoresService.actualizar(proveedores);
        return modelMapper.map(proveedores, ProveedoresDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        proveedoresService.eliminar(id);
    }
}
