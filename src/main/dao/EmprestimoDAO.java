package main.dao;

import main.Interfaces.EmprestimoCRUD;
import main.model.Emprestimo;
import main.model.Usuario;


import java.util.ArrayList;
import java.util.List;
public class EmprestimoDAO implements EmprestimoCRUD {

    private ArrayList<Emprestimo> lista;

    private int proxId;

    public EmprestimoDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }



    public Emprestimo create(Emprestimo objeto){
        if (objeto != null) {
            objeto.setId(this.getProxId());
            this.lista.add(objeto);
            return objeto;
        }
        return null;

    }




    public List<Emprestimo> read(){
        return this.lista;
    }

    public Emprestimo findbyID(int index){
        for(Emprestimo x : this.lista){
            if(x.getId() == index){
                return x;
            }
        }
        return null;
    }


    //Retorna lista com todos os empréstimos de um usuário
    public List<Emprestimo> findbyUser(Usuario usuario) {
        List<Emprestimo> emp_usu = new ArrayList<Emprestimo>();
        for (Emprestimo obj : this.lista){
            if (obj.getUsuario() == usuario){
                emp_usu.add(obj);
            }
        }
        return emp_usu;
    }



    public void delete(Emprestimo obj) throws Exception{

        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar um Empréstimo");
        }
    }

    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
