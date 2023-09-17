package dao;

import Interfaces.EmprestimoCRUD;
import model.Emprestimo;
import model.Usuario;


import java.util.ArrayList;
import java.util.List;
public class EmprestimoDAO implements EmprestimoCRUD {

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
        if (objeto != null) {
            this.lista.add(objeto);
            return objeto;
        }
        return null;

    }


    public List<Emprestimo> read(Emprestimo objeto){
        return this.lista;
    }


    //Retorna lista com todos os empréstimos de um usuário
    public List<Emprestimo> findbyID(Usuario usuario) {
        List<Emprestimo> emp_usu = new ArrayList<Emprestimo>();
        for (Emprestimo obj : this.lista){
            if (obj.getUsuario() == usuario){
                emp_usu.add(obj);
            }
        }
        return emp_usu;
    }



    public void delete(Emprestimo obj){
        this.lista.remove(obj);
    }

    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
