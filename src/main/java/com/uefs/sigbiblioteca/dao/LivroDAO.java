package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.LivroCRUD;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Classe que implementa o DAO(Decentralized Autonomous Organization) do model Livro,
 * responsável por realizar a troca de informações entre dados e objetos;
 * Implementa os métodos da Interface LivroCRUD;
 *
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class LivroDAO implements LivroCRUD {

    /**
     * ArrayList que guarda todos os livros, representa a implementação do DAO;
     */
    private ArrayList<Livro> lista;

    /**
     * ID - Atributo identificador único
     */
    private int proxId;

    /**
     * Construtor que inicializa a classe
     */
    public LivroDAO(){
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
     * @param objeto Objeto do tipo Livro;
     * @return Objeto do tipo Livro;
     */
    @Override
    public Livro create(Livro objeto) throws Exception {

            this.lista.add(objeto);
            objeto.setId(getProxId());
            return objeto;

    }

    /**
     * Método que retorna a lista completa de Livros;
     *
     * @return Lista de Livros;
     */
    @Override
    public List<Livro> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Livros");
        }

    }

    /**
     * Método que atualiza os dados do Livro no arraylist
     *
     * @param obj Objeto do tipo Livro;
     * @return Objeto do tipo Livro;
     *
     */
    @Override
    public Livro update(Livro obj) throws Exception{

        int index = this.lista.indexOf(obj);
        this.lista.set(index, obj);
        return obj;



    }

    /**
     * Método que deleta um Livro da ArrayList;
     *
     * @param obj Livro;
     */
    @Override
    public void delete(Livro obj) throws Exception{
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar um Livro");
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
            throw new Exception("Erro ao deletar lista de Livros");
        }

    }

    /**
     * Método que busca livros por um ISBN;
     * @param isbn string referente ao ISBN;
     * @return Lista de livros que contém aquele ISBN;
     *
     */
    @Override
    public List<Livro> readByISBN(String isbn) throws Exception {
        try {
            List<Livro> livrosISBN = new ArrayList<>();
            for (Livro obj : this.lista){
                if (obj.getISBN().equals(isbn)){
                    livrosISBN.add(obj);
                }
            }
            if (!livrosISBN.isEmpty()){
                return livrosISBN;
            }

        }
        catch (Exception e) {
            throw new Exception("Erro ao procurar Livro por ISBN");
        }
    throw new IllegalArgumentException("Não existem livros com esse ISBN");
    }

    /**
     * Método que busca livros por título;
     * @param titulo string referente ao título do livro;
     * @return Lista de livros que contém aquele título;
     *
     */
    @Override
    public List<Livro> readByTitulo(String titulo) throws Exception {
        try {
            List<Livro> livrosTitulo = new ArrayList<>();
            for (Livro obj : this.lista){
                if (obj.getTitulo().equals(titulo)){
                    livrosTitulo.add(obj);
                }
            }
            if (!livrosTitulo.isEmpty()){
                return livrosTitulo;
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por título");
        }
        throw new IllegalArgumentException("Não existem livros com esse título");
    }

    /**
     * Método que busca livros por autor;
     *
     * @param autor string referente ao autor do livro;
     * @return Lista de livros que contém aquele autor;
     *
     */
    @Override
    public List<Livro> readByAutor(String autor) throws Exception {
        try {
            List<Livro> livrosAutor = new ArrayList<>();
            for (Livro obj : this.lista){
                if (obj.getAutor().equals(autor)){
                    livrosAutor.add(obj);
                }
            }
            if(!livrosAutor.isEmpty()){
                return livrosAutor;
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por autor");
        }
        throw new IllegalArgumentException("Não existem livros desse Autor");
    }

    /**
     * Método que busca livros por categoria;
     *
     * @param categoria string referente a categoria do livro;
     * @return Lista de livros que contém aquela categoria;
     *
     */
    @Override
    public List<Livro> readByCategoria(String categoria) throws Exception {
        try {
            List<Livro> livrosCategoria = new ArrayList<>();
            for (Livro obj : this.lista){
                if (obj.getCategoria().equals(categoria)){
                    livrosCategoria.add(obj);
                }
            }
            if(!livrosCategoria.isEmpty()){
                return livrosCategoria;
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por Categoria");
        }
        throw new IllegalArgumentException("Não existem livros dessa categoria");
    }

    /**
     * Método que busca os livros mais populares;
     * @param n Recebe um inteiro referente a quantidade que deseja saber dos Livros mais populares(Top3/top5/top1000)
     * @return Lista com o ISBN dos livros mais populares;
     */
    @Override
    public List<String> readMoreUsed(int n) throws Exception {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        List<String> listaFinal = new ArrayList<>();
        for (Emprestimo x : DAO.getEmprestimoDAO().read()){
            if (!map.containsKey(x.getLivro().getISBN())){
                map.put(x.getLivro().getISBN(),-1);
            }
            else {
                Integer i = map.get(x.getLivro().getISBN());
                map.put(x.getLivro().getISBN(), --i );
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> x : list){
            listaFinal.add(x.getKey());
        }

        return listaFinal.subList(0,Math.min(list.size(),n));
    }

    /**
     * Método responsável por retornar número de livros atrasados no determinado momento (Requisito do problema)
     * @param dataAtual Localdate referente a data momentânea
     * @return INT - retorna a quantidade de livros atrasados
     *
     */
    @Override
    public int numBorrowed(LocalDate dataAtual) throws Exception {
        return DAO.getEmprestimoDAO().atrasados(dataAtual).size();
    }

    /**
     * Método que
     * @return
     * @throws Exception
     */
    @Override
    public int numEmp() throws Exception {
        return DAO.getEmprestimoDAO().findEmpActive().size();
    }

    @Override
    public int numReserved() throws Exception {
        return DAO.getReservaDAO().findReservaActive().size();
    }
}
