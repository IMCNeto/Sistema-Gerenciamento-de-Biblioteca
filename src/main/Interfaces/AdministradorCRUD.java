package main.Interfaces;

import main.model.Administrador;

import java.util.List;

public interface AdministradorCRUD extends CRUD<Administrador> {

    public Administrador create(Administrador obj);

    public List<Administrador> read();

    public Administrador readID(int id);

    public Administrador update(Administrador obj);

    public void delete(Administrador obj);

    public void deleteMany();
}
