package com.uefs.sigbiblioteca.Interfaces;


import com.uefs.sigbiblioteca.model.Bibliotecario;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;


/**
 * Interface para implementar o UsuárioDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface UsuarioCRUD extends CRUD<Usuario, Exception> {

    public List<Usuario> usuariosBloqueados(LocalDate dataAtual) throws Exception;

    public Usuario readID(int id) throws Exception;

    public Usuario updateIndex(int index, Usuario usuario);

    public Usuario findbyname(String name, String senha) throws Exception;

}
