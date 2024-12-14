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

import com.proyecto2.demo.dto.ServiciosDTO;
import com.proyecto2.demo.entidad.Servicios;
import com.proyecto2.demo.serviceImp.ServiciosServiceImp;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosServiceImp serviciosService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<ServiciosDTO> listar() throws Exception {
        return serviciosService.listar().stream()
            .map(servicios -> modelMapper.map(servicios, ServiciosDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public ServiciosDTO registrar(@RequestBody ServiciosDTO serviciosDTO) throws Exception {
        Servicios servicios = modelMapper.map(serviciosDTO, Servicios.class);
        servicios = serviciosService.registrar(servicios);
        return modelMapper.map(servicios, ServiciosDTO.class);
    }

    @PutMapping("/actualizar")
    public ServiciosDTO actualizar(@RequestBody ServiciosDTO serviciosDTO) throws Exception {
        Servicios servicios = modelMapper.map(serviciosDTO, Servicios.class);
        servicios = serviciosService.actualizar(servicios);
        return modelMapper.map(servicios, ServiciosDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        serviciosService.eliminar(id);
    }
}
