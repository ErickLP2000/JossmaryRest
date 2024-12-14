package com.proyecto2.demo.dto;

public class ServiciosDTO {
    
    private Long id;
    private String descripcion;
    ClienteDTO cliente;
    EspservicioDTO espservicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public EspservicioDTO getEspservicio() {
        return espservicio;
    }

    public void setEspservicio(EspservicioDTO espservicio) {
        this.espservicio = espservicio;
    }
}
