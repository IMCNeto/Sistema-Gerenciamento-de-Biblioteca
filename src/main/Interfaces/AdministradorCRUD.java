package main.Interfaces;

import main.model.Administrador;

import java.util.List;


/**
 * Interface para implementar o AdministradorDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface AdministradorCRUD extends CRUD<Administrador, Exception> {

    public Administrador readID(int id) throws Exception;


}
