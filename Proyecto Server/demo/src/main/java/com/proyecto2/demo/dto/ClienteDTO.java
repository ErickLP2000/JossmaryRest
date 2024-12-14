package com.proyecto2.demo.dto;

import java.util.Date;

public class ClienteDTO{
    
    private Long id;
    private String nombre;
    private String paterno;
    private String materno;
    private String numdoc;
    private String direccion;
    private String celular;
    private Date registro;
    private Date editado;
    TipoclienteDTO tipocliente;
    DocumentoDTO documento;
    DistritoDTO distrito;

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

    public TipoclienteDTO getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(TipoclienteDTO tipocliente) {
        this.tipocliente = tipocliente;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public DocumentoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDTO documento) {
        this.documento = documento;
    }

    public DistritoDTO getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoDTO distrito) {
        this.distrito = distrito;
    }
    
}
