package main.dao;

import main.Interfaces.BibliotecarioCRUD;
import main.model.Bibliotecario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecarioDAO implements BibliotecarioCRUD {

    private ArrayList<Bibliotecario> lista;
    private int prox_id;

    public BibliotecarioDAO(){
        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    private int getProx_id(){
        return this.prox_id++;
    }

    @Override
    public Bibliotecario create(Bibliotecario obj) throws Exception {
        try {
            this.lista.add(obj);
            obj.setId(this.getProx_id());
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar bibliotecário");
        }

    }

    @Override
    public List<Bibliotecario> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de bibliotecários");
        }
    }

    @Override
    public Bibliotecario readID(int id) throws Exception {
        try {
            for (Bibliotecario bibliotecario : this.lista){
                if (bibliotecario.getId() == id){
                    return bibliotecario;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar bibliotecário por ID");
        }

    }

    @Override
    public Bibliotecario update(Bibliotecario obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index,obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Bibliotecário");
        }
    }

    @Override
    public void delete(Bibliotecario obj) throws Exception{
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Bibliotecário");
        }
    }

    @Override
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            this.prox_id = 0;
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Lista de Bibliotecários");
        }


    }
}
