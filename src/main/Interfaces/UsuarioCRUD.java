package main.Interfaces;


import main.model.Emprestimo;
import main.model.Usuario;

import java.util.List;


/**
 * Interface para implementar o UsuárioDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface UsuarioCRUD extends CRUD<Usuario, Exception> {

    public List<Usuario> usuariosBloqueados(List<Emprestimo> emp) throws Exception;


    public Usuario readID(int id) throws Exception;

}
