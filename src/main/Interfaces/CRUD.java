package main.Interfaces;

import java.util.List;

public interface CRUD<T, E extends Exception> {

    public T create(T obj);

    public List<T> read();

    public void delete(T obj) throws E;

    public void deleteMany();
}
