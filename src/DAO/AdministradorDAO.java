package DAO;

import Interfaces.CRUD;
import model.Administrador;

import java.util.ArrayList;
import java.util.List;
public class AdministradorDAO implements CRUD<Administrador> {

    private ArrayList<Administrador> lista;
    private int proxId;

    public void listaOperadoresDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }


    @Override
    public Administrador create(Administrador objeto){
        return objeto;

    }

    @Override
    public List<Administrador> read(Administrador objeto){
        return this.lista;
    }

    @Override
    public Administrador readID(int id) {
        for (Administrador adm : this.lista){
            if (adm.getId() == id){
                return adm;
            }
        }
        return null;
    }

    @Override
    public Administrador update(Administrador adm){
        int index = this.lista.indexOf(adm);
        this.lista.set(index,adm);
        return adm;

    }


    public void delete(Administrador adm){
        this.lista.remove(adm);
    }

    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
