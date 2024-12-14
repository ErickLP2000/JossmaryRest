package com.proyecto2.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.demo.dto.TipoclienteDTO;
import com.proyecto2.demo.serviceImp.TipoclienteServiceImp;

@RestController
@RequestMapping("/tipocliente")
public class TipoClienteController {

    @Autowired
    private TipoclienteServiceImp tipoclienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<TipoclienteDTO> listar() throws Exception{
        return tipoclienteService.listar().stream()
                .map(tipoclienteService -> modelMapper.map(tipoclienteService, TipoclienteDTO.class))
                .collect(Collectors.toList());
    }
    
}
