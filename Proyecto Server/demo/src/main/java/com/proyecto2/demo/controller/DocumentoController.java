package com.proyecto2.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto2.demo.dto.DocumentoDTO;
import com.proyecto2.demo.serviceImp.DocumentoServiceImp;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoServiceImp documentoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<DocumentoDTO> listar() throws Exception{
        return documentoService.listar().stream()
                .map(documentoService -> modelMapper.map(documentoService, DocumentoDTO.class))
                .collect(Collectors.toList());
    }
}
