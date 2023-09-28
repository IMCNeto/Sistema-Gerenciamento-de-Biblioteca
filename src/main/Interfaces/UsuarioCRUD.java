package main.Interfaces;


import main.model.Emprestimo;
import main.model.Usuario;

import java.util.List;

public interface UsuarioCRUD extends CRUD<Usuario, Exception> {

    public List<Usuario> usuariosBloqueados(List<Emprestimo> emp) throws Exception;

    public Usuario readID(int id) throws Exception;

}
