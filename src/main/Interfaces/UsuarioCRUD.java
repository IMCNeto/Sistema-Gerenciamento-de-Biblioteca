package main.Interfaces;


import main.model.Usuario;

import java.util.List;

public interface UsuarioCRUD extends CRUD<Usuario, Exception> {
    public Usuario create(Usuario obj);

    public List<Usuario> read();

    public Usuario readID(int id);

    public Usuario update(Usuario obj) throws Exception;

    public void delete(Usuario obj) throws Exception;

    public void deleteMany();
}
