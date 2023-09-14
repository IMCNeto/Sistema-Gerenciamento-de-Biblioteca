package DAO;

public interface CRUD<T> {

    public T create(T obj);

    public list<T> read(T obj);

    public T readID(int id);

    public T update(T obj);

    public void delete(T obj);

    public void deleteMany();
}
