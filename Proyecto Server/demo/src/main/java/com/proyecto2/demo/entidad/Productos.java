package com.proyecto2.demo.entidad;

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
@Table(name="producto")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_producto")
    @NotEmpty
    private String nombre;

    @Column(name = "color")
    @NotEmpty
    private String color;

    @Column(name = "talla")
    private String talla;

    @ManyToOne
    @JoinColumn(name = "categoria_producto_id")
    Catproducto catproducto;

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

    public Catproducto getCatproducto() {
        return catproducto;
    }

    public void setCatproducto(Catproducto catproducto) {
        this.catproducto = catproducto;
    }

    
}
