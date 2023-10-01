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
    public Emprestimo create(Emprestimo objeto) throws Exception {
        try {
            if (objeto != null) {
                this.lista.add(objeto);
                objeto.setId(this.getProxId());
                return objeto;
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar empréstimo");
        }


    }

    @Override
    public Emprestimo update(Emprestimo obj) throws Exception{
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao atualizar empréstimo");
        }

    }



    @Override
    public List<Emprestimo> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de empréstimos");
        }

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
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            this.proxId = 0;
        }
        catch (Exception e){
            throw new Exception("Erro ao deletar lista de empréstimos");
        }

    }


    @Override
    public Emprestimo findbyID(int index) throws Exception {
        try {
            for(Emprestimo x : this.lista){
                if(x.getId() == index){
                    return x;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar empréstimo por ID");
        }

    }


    //Retorna lista com todos os empréstimos de um usuário
    @Override
    public List<Emprestimo> findbyUser(Usuario usuario) throws Exception {
        try {
            List<Emprestimo> emp_usu = new ArrayList<Emprestimo>();
            for (Emprestimo obj : this.lista){
                if (obj.getUsuario() == usuario){
                    emp_usu.add(obj);
                }
            }
            return emp_usu;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar empréstimos por usuário");
        }

    }


    //Retorna lista com os empréstimos ativos de um usuário
    @Override
    public List<Emprestimo> findbyUserActive(Usuario usuario) throws Exception{
        try {
            List<Emprestimo> emp_active = new ArrayList<>();
            for (Emprestimo obj : this.lista){
                if (obj.getUsuario() == usuario & obj.getStatus() == 0){
                    emp_active.add(obj);

                }
            }
            return emp_active;
        }
        catch (Exception e){
            throw new Exception("Erro ao encontrar empréstimos ativos do usuário");
        }

    }



    @Override
    public List<Emprestimo> atrasados(LocalDate dataAtual) throws Exception {
        try {
            List<Emprestimo> listaEmprestimosAtrasados = new ArrayList<Emprestimo>();
            for(Emprestimo x : this.lista){
                if(x.getUsuario().calcularMulta(x.getDataDevolver(),dataAtual) > 0){
                    listaEmprestimosAtrasados.add(x);
                }
            }
            return listaEmprestimosAtrasados;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de empréstimos atrasados");
        }

    }

    @Override
    public List<Emprestimo> findEmpActive() throws Exception {
        try {
            List<Emprestimo> listaEmprestimosAtivos = new ArrayList<Emprestimo>();
            for (Emprestimo x : this.lista){
                if(x.getStatus() == 0){
                    listaEmprestimosAtivos.add(x);
                }
            }
            return listaEmprestimosAtivos;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de empréstimos ativos");
        }
    }
}
