package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.UsuarioCRUD;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Usuário,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface UsuárioCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class UsuarioDAO implements UsuarioCRUD {

    /**
     * ArrayList que guarda todos os usuários, representa a implementação do DAO;
     */
    private ArrayList<Usuario> lista;

    /**
     * ID - Atributo identificador único
     */
    private int prox_id;

    /**
     * Construtor que inicializa a classe
     */
    public UsuarioDAO(){

        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    /**
     * Método que retorna um novo ID que ainda não foi utilizado;
     * @return INT - prox_id e incrementa 1 em prox_id;
     */
    private int getProx_id() {
        return this.prox_id++;
    }

    /**
     * Método que cria o objeto na lista de dados (Necessário para persistência de dados);
     *
     * @param obj Objeto do tipo usuário;
     * @return Objeto do tipo usuário;
     */
    @Override
    public Usuario create(Usuario obj) throws Exception {
        try {
            this.lista.add(obj);
            obj.setNum_id(this.getProx_id());
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar Usuário");
        }

    }

    /**
     * Método que atualiza os dados do usuário no arraylist
     *
     * @param obj Objeto do tipo Usuário;
     * @return Objeto do tipo Usuário;
     *
     */
    @Override
    public Usuario update(Usuario obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Usuário");
        }
    }

    /**
     * Método que retorna a lista completa de usuários;
     *
     * @return Lista de usuários;
     */
    @Override
    // lê toda lista;
    public ArrayList<Usuario> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de usuários");
        }

    }

    /**
     * Método que busca um usuário por um ID;
     *
     * @param id ID do usuário
     * @return Usuário
     */
    @Override
    public Usuario readID(int id) throws Exception {
        try {
            for (Usuario usuario : this.lista){
                if (usuario.getNum_id() == id){
                    return usuario;
                }

            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao encontrar usuário");
        }
    }

    /**
     * Método que deleta um usuário da ArrayList;
     *
     * @param obj Usuário;
     */
    @Override
    public void delete(Usuario obj) throws Exception {
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Usuário");
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
            this.prox_id = 0;
        }
        catch (Exception e){
            throw new Exception("Erro ao deletar lista de usuários");
        }
    }

    /**
     * Método que procura lista de usuários que estão bloqueados devido a atrasos de empréstimos;
     *
     * @param dataAtual Data atual para calcular os usuários;
     * @return Lista de usuários bloqueados;
     */
    @Override
    public List<Usuario> usuariosBloqueados(LocalDate dataAtual) throws Exception {
        try {
            List<Emprestimo> emp = DAO.getEmprestimoDAO().atrasados(dataAtual);
            List<Usuario> listaUsuariosBloqueados = new ArrayList<Usuario>();
            for(Emprestimo obj : emp){
                listaUsuariosBloqueados.add(obj.getUsuario());
                update(obj.getUsuario());
            }
            return listaUsuariosBloqueados;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de usuários bloqueados");
        }

    }
}
