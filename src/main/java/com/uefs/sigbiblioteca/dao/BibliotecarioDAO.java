package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.BibliotecarioCRUD;
import com.uefs.sigbiblioteca.model.Bibliotecario;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Bibliotecário,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface BibliotecárioCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */
public class BibliotecarioDAO implements BibliotecarioCRUD {

    /**
     * ArrayList que guarda todos os bibliotecários, representa a implementação do DAO;
     */
    private ArrayList<Bibliotecario> lista;

    /**
     * ID - Atributo identificador único;
     */
    private int prox_id;

    /**
     * Construtor que inicializa a classe;
     */
    public BibliotecarioDAO(){
        this.lista = new ArrayList<>();
        this.prox_id = 0;

    }

    /**
     * Método que retorna um novo ID que ainda não foi utilizado;
     * @return INT - prox_id e incrementa 1 em prox_id;
     */
    private int getProx_id(){
        return this.prox_id++;
    }

    /**
     * Método que cria o objeto na lista de dados (Necessário para persistência de dados);
     *
     * @param obj Objeto do tipo Bibliotecário;
     * @return Objeto do tipo Bibliotecário;
     */
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

    /**
     * Método que retorna a lista completa de Bibliotecários;
     *
     * @return Lista de Bibliotecários;
     */
    @Override
    public List<Bibliotecario> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de bibliotecários");
        }
    }

    /**
     * Método que busca um Bibliotecário por um ID;
     *
     * @param id ID do Bibliotecário;
     * @return Bibliotecário;
     */
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

    /**
     * Método que atualiza os dados do Bibliotecário no arraylist
     *
     * @param obj Objeto do tipo Bibliotecário;
     * @return Objeto do tipo Bibliotecário;
     *
     */
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

    /**
     * Método que deleta um Bibliotecário da ArrayList;
     *
     * @param obj Bibliotecário;
     */
    @Override
    public void delete(Bibliotecario obj) throws Exception{
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Bibliotecário");
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
            throw new Exception("Erro ao Deletar Lista de Bibliotecários");
        }


    }
}
