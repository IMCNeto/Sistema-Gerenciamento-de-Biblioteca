package main.dao;

import main.Interfaces.AdministradorCRUD;
import main.model.Administrador;

import java.util.ArrayList;
import java.util.List;
public class AdministradorDAO implements AdministradorCRUD {

    private ArrayList<Administrador> lista;
    private int proxId;

    public AdministradorDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }


    @Override
    public Administrador create(Administrador objeto) throws Exception {
        try {
            this.lista.add(objeto);
            return objeto;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar Administrador");
        }


    }

    @Override
    public List<Administrador> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Administradores");
        }
    }

    @Override
    public Administrador readID(int id) throws Exception {
        try {
            for (Administrador adm : this.lista){
                if (adm.getId() == id){
                    return adm;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar Administrador por ID");
        }

    }

    @Override
    public Administrador update(Administrador adm) throws Exception{
        try {
            int index = this.lista.indexOf(adm);
            this.lista.set(index,adm);
            return adm;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Administrador");
        }

    }

    @Override
    public void delete(Administrador adm) throws Exception{

        try {
            this.lista.remove(adm);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Administrador");
        }
    }

    @Override
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            this.proxId = 0;
        }
        catch (Exception e){
            throw new Exception("Erro ao deletar Lista de Administradores");
        }

    }

}
