package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.AdministradorCRUD;
import com.uefs.sigbiblioteca.model.Administrador;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Administrador,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface AdministradorCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */
public class AdministradorDAO implements AdministradorCRUD {

    /**
     * ArrayList que guarda todos os administradores, representa a implementação do DAO;
     */
    private ArrayList<Administrador> lista;

    /**
     * ID - Atributo identificador único;
     */
    private int proxId;

    /**
     * Construtor que inicializa a classe;
     */
    public AdministradorDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    /**
     * Método que retorna um novo ID que ainda não foi utilizado;
     * @return INT - prox_id e incrementa 1 em prox_id;
     */
    private int getProximoID(){
        return this.proxId++;
    }

    /**
     * Método que cria o objeto na lista de dados (Necessário para persistência de dados);
     *
     * @param objeto Objeto do tipo Administrador;
     * @return Objeto do tipo Administrador;
     */
    @Override
    public Administrador create(Administrador objeto) throws Exception {
        try {
            objeto.setId(this.getProximoID());
            this.lista.add(objeto);
            return objeto;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar Administrador");
        }


    }

    /**
     * Método que retorna a lista completa de Administradores;
     *
     * @return Lista de Administradores;
     */
    @Override
    public List<Administrador> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Administradores");
        }
    }

    /**
     * Método que busca um Administrador por um ID;
     *
     * @param id ID do Administrador;
     * @return Administrador;
     */
    @Override
    public Administrador readID(int id) throws Exception {
        try {
            for (Administrador adm : this.lista){
                if (adm.getId() == id){
                    return adm;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar Administrador por ID");
        }

    }

    /**
     * Método que atualiza os dados do Administrador no arraylist;
     *
     * @param adm Objeto do tipo Administrador;
     * @return Objeto do tipo Administrador;
     *
     */
    @Override
    public Administrador update(Administrador adm) throws Exception{
        try {
            int index = this.lista.indexOf(adm);
            this.lista.set(index,adm);
            return adm;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Administrador");
        }

    }

    /**
     * Método que deleta um Administrador da ArrayList;
     *
     * @param adm Administrador;
     */
    @Override
    public void delete(Administrador adm) throws Exception{

        try {
            this.lista.remove(adm);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Administrador");
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
            throw new Exception("Erro ao deletar Lista de Administradores");
        }

    }

}
