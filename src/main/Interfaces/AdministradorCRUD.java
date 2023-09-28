package main.Interfaces;

import main.model.Administrador;

import java.util.List;

public interface AdministradorCRUD extends CRUD<Administrador, Exception> {

    public Administrador readID(int id) throws Exception;


}
