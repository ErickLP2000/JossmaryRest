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

import com.proyecto2.demo.dto.ProductosDTO;
import com.proyecto2.demo.entidad.Productos;
import com.proyecto2.demo.serviceImp.ProductosServiceImp;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosServiceImp productosService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<ProductosDTO> listar() throws Exception {
        return productosService.listar().stream()
            .map(productos -> modelMapper.map(productos, ProductosDTO.class))
            .collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    public ProductosDTO registrar(@RequestBody ProductosDTO productosDTO) throws Exception {
        Productos productos = modelMapper.map(productosDTO, Productos.class);
        productos = productosService.registrar(productos);
        return modelMapper.map(productos, ProductosDTO.class);
    }

    @PutMapping("/actualizar")
    public ProductosDTO actualizar(@RequestBody ProductosDTO productosDTO) throws Exception {
        Productos productos = modelMapper.map(productosDTO, Productos.class);
        productos = productosService.actualizar(productos);
        return modelMapper.map(productos, ProductosDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Long id) throws Exception {
        productosService.eliminar(id);
    }
}
