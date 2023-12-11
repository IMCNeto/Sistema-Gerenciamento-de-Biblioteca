package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.AdministradorCRUD;
import com.uefs.sigbiblioteca.model.Administrador;
import com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos;

import java.io.File;
import java.util.ArrayList;

import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.*;

public class AdministradorDAODisco {
    File arquivo;
    private ArrayList<Administrador> lista;

    public AdministradorDAODisco() {
        arquivo = criar_arquivo("administrador");
        this.lista = carregar_arquivo(arquivo);

    }

    private int getProximoID() {
        int i = lista.size();
        return i++;
    }

    public Administrador create(Administrador objeto) throws Exception {

        try {
            int index = this.getProximoID();
            this.lista.add(objeto);
            objeto.setId(index);
            GerenciadorDeArquivos.salvar_arquivo(arquivo, this.lista);
            return objeto;
        } catch (Exception e) {
            throw new Exception("Erro ao criar Administrador");
        }

    }

    public ArrayList<Administrador> read() {
        return this.lista;
    }

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

    public Administrador update(Administrador adm) throws Exception{
        try {
            int index = this.lista.indexOf(adm);
            this.lista.set(index,adm);
            GerenciadorDeArquivos.salvar_arquivo(arquivo, this.lista);
            return adm;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar Administrador");
        }

    }

    public void delete(Administrador adm) throws Exception{

        try {
            this.lista.remove(adm);
            GerenciadorDeArquivos.salvar_arquivo(arquivo, this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar Administrador");
        }
    }

    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            GerenciadorDeArquivos.salvar_arquivo(arquivo, this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao deletar Lista de Administradores");
        }

    }

}





