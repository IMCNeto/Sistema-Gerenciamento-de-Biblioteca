package main.dao;


import main.Interfaces.LivroCRUD;
import main.model.Livro;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    public Livro readISBN(String isbn) throws Exception {
        try {
            for (Livro obj : this.lista){
                if (obj.getISBN().equals(isbn)){
                    return obj;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por ISBN");
        }

    }

    @Override
    public Livro readTitulo(String titulo) throws Exception {
        try {
            for (Livro obj : this.lista){
                if (obj.getTitulo().equals(titulo)){
                    return obj;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por título");
        }

    }

    @Override
    public Livro readAutor(String autor) throws Exception {
        try {
            for (Livro obj : this.lista){
                if (obj.getAutor().equals(autor)){
                    return obj;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por autor");
        }

    }

    @Override
    public Livro readCategoria(String categoria) throws Exception {
        try {
            for (Livro obj : this.lista){
                if (obj.getCategoria().equals(categoria)){
                    return obj;
                }
            }
            return null;
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Livro por Categoria");
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

}
