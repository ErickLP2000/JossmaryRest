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

import com.proyecto2.demo.dto.CatproductoDTO;
import com.proyecto2.demo.entidad.Catproducto;
import com.proyecto2.demo.serviceImp.CatproductoServiceImp;

@RestController
@RequestMapping("/catproducto")
public class CatproductoController {

    @Autowired
    private CatproductoServiceImp catproductoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public List<CatproductoDTO> listar() throws Exception {
        List<CatproductoDTO> lista=catproductoService.listar().stream()
        .map(catproducto -> modelMapper.map(catproducto, CatproductoDTO.class))
        .collect(Collectors.toList());
        return lista;
    }

    @PostMapping("/registrar")
	public CatproductoDTO registrar(@RequestBody CatproductoDTO catproductoDTO) throws Exception{
		Catproducto bean=null;
		bean=modelMapper.map(catproductoDTO, Catproducto.class);
		bean=catproductoService.registrar(bean);
		return modelMapper.map(bean, CatproductoDTO.class);
	}

    @PutMapping("/actualizar")
	public CatproductoDTO actualizar(@RequestBody CatproductoDTO doc) throws Exception{
		Catproducto bean=null;
		bean=modelMapper.map(doc, Catproducto.class);
		bean=catproductoService.actualizar(bean);
		return modelMapper.map(bean, CatproductoDTO.class);
	}
    
    @DeleteMapping("/eliminar/{codigo}")
	public void eliminar(@PathVariable("codigo") Long cod) throws Exception{
		catproductoService.eliminar(cod);
	}
}