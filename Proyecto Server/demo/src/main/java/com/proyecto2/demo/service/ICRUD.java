package com.proyecto2.demo.service;

import java.util.List;

public interface ICRUD<T, ID> {
    public T registrar(T bean) throws Exception;
    public T actualizar(T bean) throws Exception;
    public void eliminar(ID cod) throws Exception;
    public List<T> listar() throws Exception;
    public T buscar(ID cod) throws Exception;
        
}
