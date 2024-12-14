package com.proyecto2.demo.entidad;

public class Servicios {
    
    private Long id;
    private String descripcion;
    Cliente cliente;
    Espservicio espservicio;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Espservicio getEspservicio() {
        return espservicio;
    }

    public void setEspservicio(Espservicio espservicio) {
        this.espservicio = espservicio;
    }
}
