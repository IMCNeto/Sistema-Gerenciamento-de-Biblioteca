package main.Interfaces;

import main.model.Usuario;

import java.util.List;

public interface UsuarioCRUD extends CRUD<Usuario> {
    public Usuario create(Usuario obj);

    public List<Usuario> read();

    public Usuario readID(int id);

    public Usuario update(Usuario obj);

    public void delete(Usuario obj);

    public void deleteMany();
}
