package com.proyecto2.demo.dto;

public class InsumoDTO{

    private Long id;
    private String nombre;
    private String descripcion;
    private String color;
    CategoriainsuDTO categoriainsu;
    ProveedoresDTO proveedores;
    MarcainsuDTO marcainsu;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public ProveedoresDTO getProveedores() {
        return proveedores;
    }

    public void setProveedores(ProveedoresDTO proveedores) {
        this.proveedores = proveedores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriainsuDTO getCategoriainsu() {
        return categoriainsu;
    }

    public void setCategoriainsu(CategoriainsuDTO categoriainsu) {
        this.categoriainsu = categoriainsu;
    }


    public MarcainsuDTO getMarcainsu() {
        return marcainsu;
    }

    public void setMarcainsu(MarcainsuDTO marcainsu) {
        this.marcainsu = marcainsu;
    }
    
}
