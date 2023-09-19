package main.Interfaces;

import java.util.List;

public interface CRUD<T> {

    public T create(T obj);

    public List<T> read();

    public void delete(T obj);

    public void deleteMany();
}
