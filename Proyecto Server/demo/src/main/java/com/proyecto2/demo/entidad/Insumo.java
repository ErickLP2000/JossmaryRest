package com.proyecto2.demo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "insumos")
public class Insumo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @NotEmpty
    private String nombre;

    @Column(name = "descripcion")
    @NotEmpty
    private String descripcion;

    @Column(name = "color")
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @ManyToOne
    @JoinColumn(name = "categoria_insumo_id")
    Categoriainsu categoriainsu;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    Proveedores proveedores;
    
    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @ManyToOne
    @JoinColumn(name = "marca_insumo_id")
    Marcainsu marcainsu;

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
