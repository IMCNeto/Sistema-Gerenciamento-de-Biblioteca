package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.model.Administrador;
import com.uefs.sigbiblioteca.model.Bibliotecario;
import com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.carregar_arquivo;
import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.criar_arquivo;

public class BibliotecarioDAODisco {

    File arquivo;
    private ArrayList<Bibliotecario> lista;

    public BibliotecarioDAODisco() {
        arquivo = criar_arquivo("bibliotecario");
        this.lista = carregar_arquivo(arquivo);
    }

    private int getProximoID() {
        int i = lista.size();
        return i++;
    }


    public Bibliotecario create(Bibliotecario obj) throws Exception {
        try {
            int index = this.getProximoID();
            this.lista.add(obj);
            obj.setId(index);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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

    public Bibliotecario update(Bibliotecario obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index,obj);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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

    public void delete(Bibliotecario obj) throws Exception{
        try {
            this.lista.remove(obj);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Bibliotecário");
        }
    }

    /**
     * Método que deleta todos os dados da ArrayList;
     *
     */
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Lista de Bibliotecários");
        }


    }



}
