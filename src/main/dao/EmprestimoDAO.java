package main.dao;

import main.Interfaces.EmprestimoCRUD;
import main.model.Emprestimo;
import main.model.Reserva;
import main.model.Usuario;


import java.time.LocalDate;
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


    @Override
    public List<Emprestimo> atrasados(LocalDate dataAtual){
        List<Emprestimo> listaEmprestimosAtrasados = new ArrayList<Emprestimo>();
        for(Emprestimo x : this.lista){
            if(x.getUsuario().calcularMulta(x.getDataDevolver(),dataAtual) > 0){
                listaEmprestimosAtrasados.add(x);
            }
        }
        return listaEmprestimosAtrasados;
    }

    @Override
    public Emprestimo create(Emprestimo objeto){
        if (objeto != null) {
            objeto.setId(this.getProxId());
            this.lista.add(objeto);
            return objeto;
        }
        return null;

    }

    @Override
    public Emprestimo update(Emprestimo obj) throws Exception{
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;

    }

    @Override
    public List<Emprestimo> read(){
        return this.lista;
    }

    @Override
    public Emprestimo findbyID(int index){
        for(Emprestimo x : this.lista){
            if(x.getId() == index){
                return x;
            }
        }
        return null;
    }


    //Retorna lista com todos os empréstimos de um usuário
    @Override
    public List<Emprestimo> findbyUser(Usuario usuario) {
        List<Emprestimo> emp_usu = new ArrayList<Emprestimo>();
        for (Emprestimo obj : this.lista){
            if (obj.getUsuario() == usuario){
                emp_usu.add(obj);
            }
        }
        return emp_usu;
    }

    @Override
    public void delete(Emprestimo obj) throws Exception{

        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar um Empréstimo");
        }
    }

    @Override
    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
