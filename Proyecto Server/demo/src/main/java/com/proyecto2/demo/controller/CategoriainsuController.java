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

import com.proyecto2.demo.dto.CategoriainsuDTO;
import com.proyecto2.demo.entidad.Categoriainsu;
import com.proyecto2.demo.serviceImp.CategoriainsuServiceImp;

@RestController
@RequestMapping("/catinsumo")
public class CategoriainsuController {

    @Autowired
    private CategoriainsuServiceImp categoriainsuService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<CategoriainsuDTO> listar() throws Exception{
        return categoriainsuService.listar().stream()
                .map(categoriainsu -> modelMapper.map(categoriainsu, CategoriainsuDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public CategoriainsuDTO registrar(@RequestBody CategoriainsuDTO categoriainsuDTO) throws Exception{
        Categoriainsu bean = modelMapper.map(categoriainsuDTO, Categoriainsu.class);
        bean = categoriainsuService.registrar(bean);
        return modelMapper.map(bean, CategoriainsuDTO.class);
    }
    
    @PutMapping("/actualizar")
    public CategoriainsuDTO actualizar(@RequestBody CategoriainsuDTO categoriainsuDTO) throws Exception{
        Categoriainsu bean = modelMapper.map(categoriainsuDTO, Categoriainsu.class);
        bean = categoriainsuService.actualizar(bean);
        return modelMapper.map(bean, CategoriainsuDTO.class);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminar(@PathVariable("codigo") Long cod) throws Exception{
        categoriainsuService.eliminar(cod);
    }
}