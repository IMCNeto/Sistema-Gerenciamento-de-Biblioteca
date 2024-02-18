package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.AdministradorCRUD;
import com.uefs.sigbiblioteca.model.Administrador;
import com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos;

import java.io.File;
import java.util.ArrayList;

import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.*;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Administrador,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface AdministradorCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */

public class AdministradorDAODisco implements AdministradorCRUD {

    /**
     * Arquivo que armazena as informações sobre os administradores;
     */
    File arquivo;

    /**
     * ArrayList que guarda todos os administradores;
     */
    private ArrayList<Administrador> lista;

    /**
     * Construtor que inicializa a classe;
     */
    public AdministradorDAODisco() {
        arquivo = criar_arquivo("administrador");
        this.lista = carregar_arquivo(arquivo);

    }

    /**
     * Método que retorna um novo ID que ainda não foi utilizado;
     * @return INT - prox_id e incrementa 1 em prox_id;
     */
    private int getProximoID() {
        int i = lista.size();
        return i++;
    }

    /**
     * Método que cria o objeto na lista de dados (Necessário para persistência de dados);
     *
     * @param objeto Objeto do tipo Administrador;
     * @return Objeto do tipo Administrador;
     */
    public Administrador create(Administrador objeto) throws Exception {

        try {
            int index = this.getProximoID();
            this.lista.add(objeto);
            objeto.setId(index);
            salvar_arquivo(arquivo, this.lista);
            return objeto;
        } catch (Exception e) {
            throw new Exception("Erro ao criar Administrador");
        }

    }

    /**
     * Método que retorna a lista completa de Administradores;
     *
     * @return Lista de Administradores;
     */
    public ArrayList<Administrador> read() {
        return this.lista;
    }

    /**
     * Método que busca um Administrador por um ID;
     *
     * @param id ID do Administrador;
     * @return Administrador;
     */
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
    public Administrador update(Administrador adm) throws Exception{
        try {
            int index = this.lista.indexOf(adm);
            this.lista.set(index,adm);
            salvar_arquivo(arquivo, this.lista);
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
    public void delete(Administrador adm) throws Exception{

        try {
            this.lista.remove(adm);
            salvar_arquivo(arquivo, this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Administrador");
        }
    }

    /**
     * Método que deleta todos os dados da ArrayList;
     *
     */
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            salvar_arquivo(arquivo, this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao deletar Lista de Administradores");
        }

    }

}





