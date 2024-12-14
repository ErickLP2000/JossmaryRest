package com.proyecto2.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.demo.dto.DistritoDTO;
import com.proyecto2.demo.serviceImp.DistritoServiceImp;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    
    @Autowired
    private DistritoServiceImp distritoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<DistritoDTO> listar() throws Exception{
        return distritoService.listar().stream()
                .map(distritoService -> modelMapper.map(distritoService, DistritoDTO.class))
                .collect(Collectors.toList());
    }
}
