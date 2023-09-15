package DAO;

import model.Emprestimo;
import model.Usuario;


import java.util.ArrayList;
import java.util.List;
public class EmprestimoDAO  {

    private ArrayList<Emprestimo> lista;
    private int proxId;

    public void listaOperadoresDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }



    public Emprestimo create(Emprestimo objeto){
        return objeto;

    }


    public List<Emprestimo> read(Emprestimo objeto){
        return this.lista;
    }


    public Emprestimo readID(Usuario usuario) {
        for (Emprestimo obj : this.lista){
            if (obj.getUsuario() == usuario){
                return obj;
            }
        }
        return null;
    }


    public Emprestimo update(Emprestimo obj){
        int index = this.lista.indexOf(obj);
        this.lista.set(index,obj);
        return obj;

    }


    public void delete(Emprestimo obj){
        this.lista.remove(obj);
    }

    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
