package main.dao;


import main.Interfaces.LivroCRUD;
import main.model.Livro;


import java.util.ArrayList;
import java.util.List;
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
    public Livro create(Livro objeto){
        this.lista.add(objeto);
        return objeto;

    }

    @Override
    public List<Livro> read(){
        return this.lista;
    }


    @Override
    public Livro readISBN(String isbn) {
        for (Livro obj : this.lista){
            if (obj.getISBN().equals(isbn)){
                return obj;
            }
        }
        return null;
    }

    @Override
    public Livro readTitulo(String titulo){
        for (Livro obj : this.lista){
            if (obj.getTitulo().equals(titulo)){
                return obj;
            }
        }
        return null;
    }

    @Override
    public Livro readAutor(String autor){
        for (Livro obj : this.lista){
            if (obj.getAutor().equals(autor)){
                return obj;
            }
        }
        return null;
    }

    @Override
    public Livro readCategoria(String categoria){
        for (Livro obj : this.lista){
            if (obj.getCategoria().equals(categoria)){
                return obj;
            }
        }
        return null;
    }


    @Override
    public Livro update(Livro obj) throws Exception{

        try {
            int index = this.lista.indexOf(obj);

            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar um Livro");

        }

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
    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
