package main.Interfaces;

import main.model.Bibliotecario;

import java.util.List;

public interface BibliotecarioCRUD extends CRUD<Bibliotecario, Exception> {
    public Bibliotecario readID(int id);

}
