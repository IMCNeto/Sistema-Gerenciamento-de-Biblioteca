package DAO;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class usuarioDAO implements CRUD<model.Usuario>{

    private ArrayList<Usuario> lista;
    private int prox_id;

    public void listaUsuariosDAO(){

        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    private int getProx_id() {
        return this.prox_id++;
    }

    @Override
    public Usuario create(Usuario obj) {
        obj.setNum_id(this.getProx_id());
        this.lista.add(obj);
        return obj;
    }

    @Override
    // lê toda lista;
    public ArrayList<Usuario> read(Usuario obj) {
        return this.lista;
    }

    @Override
    public Usuario readID(int id) {
        for (Usuario usuario : this.lista){
            if (usuario.getNum_id() == id){
                return usuario;
            }

        }
        return null;
    }
    @Override
    public Usuario update(Usuario obj) {
        int index = this.lista.indexOf(obj);
        this.lista.set(index,obj);
        return obj;
    }

    @Override
    //Deleta um objeto;
    public void delete(Usuario obj) {
        this.lista.remove(obj);
    }

    @Override
    //limpa toda lista;
    public void deleteMany() {
        this.lista.clear();
        this.prox_id = 0;
    }
}
