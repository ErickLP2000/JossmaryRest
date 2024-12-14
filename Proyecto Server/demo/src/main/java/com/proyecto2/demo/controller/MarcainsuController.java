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

import com.proyecto2.demo.dto.MarcainsuDTO;
import com.proyecto2.demo.entidad.Marcainsu;
import com.proyecto2.demo.serviceImp.MarcainsuServiceImp;

@RestController
@RequestMapping("/marca")
public class MarcainsuController {

    @Autowired
    private MarcainsuServiceImp marcainsuService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<MarcainsuDTO> listar() throws Exception {
        return marcainsuService.listar().stream()
            .map(marcainsu -> modelMapper.map(marcainsu, MarcainsuDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public MarcainsuDTO registrar(@RequestBody MarcainsuDTO marcainsuDTO) throws Exception {
        Marcainsu marcainsu = modelMapper.map(marcainsuDTO, Marcainsu.class);
        marcainsu = marcainsuService.registrar(marcainsu);
        return modelMapper.map(marcainsu, MarcainsuDTO.class);
    }

    @PutMapping("/actualizar")
    public MarcainsuDTO actualizar(@RequestBody MarcainsuDTO marcainsuDTO) throws Exception {
        Marcainsu marcainsu = modelMapper.map(marcainsuDTO, Marcainsu.class);
        marcainsu = marcainsuService.actualizar(marcainsu);
        return modelMapper.map(marcainsu, MarcainsuDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        marcainsuService.eliminar(id);
    }
}
