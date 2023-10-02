package main.Interfaces;

import main.model.Bibliotecario;

import java.util.List;


/**
 * Interface para implementar o BibliotecárioDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface BibliotecarioCRUD extends CRUD<Bibliotecario, Exception> {
    public Bibliotecario readID(int id) throws Exception;

}
