package main.Interfaces;

import main.model.Bibliotecario;

import java.util.List;

public interface BibliotecarioCRUD extends CRUD<Bibliotecario> {
    public Bibliotecario create(Bibliotecario obj);

    public List<Bibliotecario> read();

    public Bibliotecario readID(int id);

    public Bibliotecario update(Bibliotecario obj);

    public void delete(Bibliotecario obj);

    public void deleteMany();
}
