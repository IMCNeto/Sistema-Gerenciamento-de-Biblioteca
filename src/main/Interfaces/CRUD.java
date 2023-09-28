package main.Interfaces;

import java.util.List;

public interface CRUD<T, E extends Exception> {

    public T create(T obj) throws Exception;

    public List<T> read() throws Exception;

    public T update(T obj) throws Exception;

    public void delete(T obj) throws E;

    public void deleteMany() throws Exception;
}
