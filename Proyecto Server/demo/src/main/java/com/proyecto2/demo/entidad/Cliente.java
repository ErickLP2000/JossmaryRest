package com.proyecto2.demo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    @NotEmpty
    private String nombre;

    @Column(name = "apellido_paterno")
    @NotEmpty
    private String paterno;

    @Column(name = "apellido_materno")
    @NotEmpty
    private String materno;

    @Column(name = "nro_documento")
    @NotNull
    private String numdoc;


    @Column(name = "direccion")
    @NotEmpty
    private String direccion;

    @Column(name = "celular")
    @NotNull
    private String celular;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "fecha_editado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editado;
    
    @ManyToOne
    @JoinColumn(name = "tipo_cliente_id")
    Tipocliente tipocliente;

    @ManyToOne
    @JoinColumn(name = "tipo_documento_id")
    Documento documento;
    
    @ManyToOne
    @JoinColumn(name = "distrito_id")
    Distrito distrito;

    @PrePersist
    private void registrarFecha(){
        this.registro = new Date();
    }

    @PreUpdate
    private void actualizarFecha(){
        this.editado = new Date();
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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public Tipocliente getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(Tipocliente tipocliente) {
        this.tipocliente = tipocliente;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
}
