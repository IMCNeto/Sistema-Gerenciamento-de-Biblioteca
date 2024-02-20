package com.uefs.sigbiblioteca.Interfaces;

import com.uefs.sigbiblioteca.model.Administrador;
import com.uefs.sigbiblioteca.model.Bibliotecario;


/**
 * Interface para implementar o BibliotecárioDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface BibliotecarioCRUD extends CRUD<Bibliotecario, Exception> {
    public Bibliotecario readID(int id) throws Exception;

    public Bibliotecario findbyname(String name, String senha) throws Exception;


}
