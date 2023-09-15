package DAO;

import model.Bibliotecario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecarioDAO implements CRUD<Bibliotecario> {

    private ArrayList<Bibliotecario> lista;
    private int prox_id;

    public void listaOperadoresDAO(){
        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    private int getProx_id(){
        return this.prox_id++;
    }

    @Override
    public Bibliotecario create(Bibliotecario obj) {
        this.lista.add(obj);
        return obj;
    }

    @Override
    public List<Bibliotecario> read(Bibliotecario obj) {
        return this.lista;
    }

    @Override
    public Bibliotecario readID(int id) {
        for (Bibliotecario bibliotecario : this.lista){
            if (bibliotecario.getId() == id){
                return bibliotecario;
            }
        }
        return null;
    }

    @Override
    public Bibliotecario update(Bibliotecario obj) {
        int index = this.lista.indexOf(obj);
        this.lista.set(index,obj);
        return obj;
    }

    @Override
    public void delete(Bibliotecario obj) {
        this.lista.remove(obj);

    }

    @Override
    public void deleteMany() {
        this.lista.clear();
        this.prox_id = 0;

    }
}
