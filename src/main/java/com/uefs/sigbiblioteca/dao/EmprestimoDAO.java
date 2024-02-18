package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.EmprestimoCRUD;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Empréstimo,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface EmpréstimoCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class EmprestimoDAO implements EmprestimoCRUD {

    /**
     * ArrayList que guarda todos os empréstimos, representa a implementação do DAO;
     */
    private ArrayList<Emprestimo> lista;

    /**
     * ID - Atributo identificador único
     */
    private int proxId;

    /**
     * Construtor que inicializa a classe
     */
    public EmprestimoDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    /**
     * Método que retorna um novo ID que ainda não foi utilizado;
     * @return INT - prox_id e incrementa 1 em prox_id;
     */
    private int getProxId(){
        return this.proxId++;
    }

    /**
     * Método que cria o objeto na lista de dados (Necessário para persistência de dados);
     *
     * @param objeto Objeto do tipo Empréstimo;
     * @return Objeto do tipo Empréstimo;
     */
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

    /**
     * Método que atualiza os dados do Empréstimo no arraylist
     *
     * @param obj Objeto do tipo Empréstimo;
     * @return Objeto do tipo Empréstimo;
     *
     */
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

    /**
     * Método que retorna a lista completa de Empréstimos;
     *
     * @return Lista de Empréstimos;
     */
    @Override
    public List<Emprestimo> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de empréstimos");
        }

    }

    /**
     * Método que deleta um Empréstimo da ArrayList;
     *
     * @param obj Empréstimo;
     */
    @Override
    public void delete(Emprestimo obj) throws Exception{

        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar um Empréstimo");
        }
    }

    /**
     * Método que deleta todos os dados da ArrayList;
     *
     */
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

    /**
     * Método que busca um empréstimo por um ID;
     *
     * @param index ID - Atributo identificador único;
     * @return Empréstimo;
     */
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

    /**
     * Método que retorna lista com todos os empréstimos de um usuário;
     *
     * @param usuario Objeto do tipo usuário;
     * @return Lista de empréstimos;
     *
     */
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

    /**
     * Método que busca lista com todos os empréstimos ativos de um usuário;
     * @param usuario Objeto do tipo Usuário;
     * @return Lista de empréstimos;
     *
     */
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

    /**
     * Método que busca todos os empréstimos atrasados no determinado momento;
     *
     * @param dataAtual Data do momento atual
     * @return Lista de empréstimos atrasados
     *
     */
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

    /**
     * Método que busca todos os empréstimos ativos;
     *
     * @return Lista de empréstimos ativos
     *
     */
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
