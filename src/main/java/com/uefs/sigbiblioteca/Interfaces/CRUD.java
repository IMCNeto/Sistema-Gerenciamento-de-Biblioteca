package com.uefs.sigbiblioteca.Interfaces;

import java.util.List;


/**
 * Interface que implementa o padrão CRUD (Create, Read, Update, Delete)
 *
 * @version 1.0
 */
public interface CRUD<T, E extends Exception> {

    public T create(T obj) throws Exception;

    public List<T> read() throws Exception;

    public T update(T obj) throws Exception;

    public void delete(T obj) throws E;

    public void deleteMany() throws Exception;
}
