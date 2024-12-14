package com.proyecto2.demo.entidad;

public class Insumo{

    private Long id;
    private String nombre;
    private String descripcion;
    private String color;
    Categoriainsu categoriainsu;
    Proveedores proveedores;
    Marcainsu marcainsu;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
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

    public Categoriainsu getCategoriainsu() {
        return categoriainsu;
    }

    public void setCategoriainsu(Categoriainsu categoriainsu) {
        this.categoriainsu = categoriainsu;
    }


    public Marcainsu getMarcainsu() {
        return marcainsu;
    }

    public void setMarcainsu(Marcainsu marcainsu) {
        this.marcainsu = marcainsu;
    }
    
}
