package main.dao;


import main.Interfaces.LivroCRUD;
import main.model.Emprestimo;
import main.model.Livro;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class LivroDAO implements LivroCRUD {

    private ArrayList<Livro> lista;
    private int proxId;

    public LivroDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }


    @Override
    public Livro create(Livro objeto) throws Exception {

            this.lista.add(objeto);
            objeto.setId(getProxId());
            return objeto;

    }

    @Override
    public List<Livro> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Livros");
        }

    }

    @Override
    public Livro update(Livro obj) throws Exception{

        int index = this.lista.indexOf(obj);
        this.lista.set(index, obj);
        return obj;



    }

    @Override
    public void delete(Livro obj) throws Exception{
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar um Livro");
        }
    }

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


    @Override
    public HashMap<String, Integer> readMoreUsed() throws Exception {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
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

        return map;
    }
}
