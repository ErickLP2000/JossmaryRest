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

import com.proyecto2.demo.dto.InsumoDTO;
import com.proyecto2.demo.entidad.Insumo;
import com.proyecto2.demo.serviceImp.InsumoServiceImp;

@RestController
@RequestMapping("/insumo")
public class InsumoController {

    @Autowired
    private InsumoServiceImp insumoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<InsumoDTO> listar() throws Exception {
        return insumoService.listar().stream()
            .map(insumo -> modelMapper.map(insumo, InsumoDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public InsumoDTO registrar(@RequestBody InsumoDTO insumoDTO) throws Exception {
        Insumo insumo = modelMapper.map(insumoDTO, Insumo.class);
        insumo = insumoService.registrar(insumo);
        return modelMapper.map(insumo, InsumoDTO.class);
    }

    @PutMapping("/actualizar")
    public InsumoDTO actualizar(@RequestBody InsumoDTO insumoDTO) throws Exception {
        Insumo insumo = modelMapper.map(insumoDTO, Insumo.class);
        insumo = insumoService.actualizar(insumo);
        return modelMapper.map(insumo, InsumoDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        insumoService.eliminar(id);
    }
}
