package com.proyecto2.demo.dto;


public class ProductosDTO {

    private Long id;
    private String nombre;
    private String color;
    private String talla;
    CatproductoDTO catproducto;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public CatproductoDTO getCatproducto() {
        return catproducto;
    }

    public void setCatproducto(CatproductoDTO catproducto) {
        this.catproducto = catproducto;
    }

    
}
