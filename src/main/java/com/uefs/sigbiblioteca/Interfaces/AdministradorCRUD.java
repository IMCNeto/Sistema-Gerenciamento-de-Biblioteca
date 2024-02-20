package com.uefs.sigbiblioteca.Interfaces;

import com.uefs.sigbiblioteca.model.Administrador;


/**
 * Interface para implementar o AdministradorDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface AdministradorCRUD extends CRUD<Administrador, Exception> {

    public Administrador readID(int id) throws Exception;

    public Administrador findbyname(String name,String senha) throws Exception;



}
