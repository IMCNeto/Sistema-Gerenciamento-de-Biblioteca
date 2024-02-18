package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.UsuarioCRUD;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Usuario;
import com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.carregar_arquivo;
import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.criar_arquivo;

public class UsuarioDAODisco implements UsuarioCRUD {

    /**
     * Arquivo que armazena as informações sobre os bibliotecarioss;
     */
    File arquivo;

    /**
     * ArrayList que guarda todos os administradores;
     */
    private ArrayList<Usuario> lista;

    /**
     * Construtor que inicializa a classe;
     */
    public UsuarioDAODisco() {
        arquivo = criar_arquivo("usuario");
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
     * @param obj Objeto do tipo usuário;
     * @return Objeto do tipo usuário;
     */
    @Override
    public Usuario create(Usuario obj) throws Exception {
        try {
            int index = this.getProximoID();
            this.lista.add(obj);
            obj.setNum_id(index);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
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
