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

import com.proyecto2.demo.dto.EspservicioDTO;
import com.proyecto2.demo.entidad.Espservicio;
import com.proyecto2.demo.serviceImp.EspservicioServiceImp;

@RestController
@RequestMapping("/espservicio")
public class EspservicioController {

    @Autowired
    private EspservicioServiceImp espservicioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<EspservicioDTO> listar() throws Exception {
        List<EspservicioDTO> lista=espservicioService.listar().stream()
        .map(espservicio -> modelMapper.map(espservicio, EspservicioDTO.class))
        .collect(Collectors.toList());
        return lista;
    }

    @PostMapping("/registrar")
    public EspservicioDTO registrar(@RequestBody EspservicioDTO espservicioDTO) throws Exception {
        Espservicio espservicio = modelMapper.map(espservicioDTO, Espservicio.class);
        espservicio = espservicioService.registrar(espservicio);
        return modelMapper.map(espservicio, EspservicioDTO.class);
    }

    @PutMapping("/actualizar")
    public EspservicioDTO actualizar(@RequestBody EspservicioDTO espservicioDTO) throws Exception {
        Espservicio espservicio = modelMapper.map(espservicioDTO, Espservicio.class);
        espservicio = espservicioService.actualizar(espservicio);
        return modelMapper.map(espservicio, EspservicioDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        espservicioService.eliminar(id);
    }
}
