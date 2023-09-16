package Interfaces;

import model.Usuario;
import model.Usuario;

import java.util.List;

public interface UsuarioCRUD extends CRUD<Usuario> {
    public Usuario create(Usuario obj);

    public List<Usuario> read(Usuario obj);

    public Usuario readID(int id);

    public Usuario update(Usuario obj);

    public void delete(Usuario obj);

    public void deleteMany();
}
