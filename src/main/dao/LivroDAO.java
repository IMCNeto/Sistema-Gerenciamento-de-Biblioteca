package main.dao;


import main.model.Livro;


import java.util.ArrayList;
import java.util.List;
public class LivroDAO {

    private ArrayList<Livro> lista;
    private int proxId;

    public void listaOperadoresDAO(){
        this.lista = new ArrayList<>();
        this.proxId = 0;

    }

    private int getProxId(){
        return this.proxId++;
    }



    public Livro create(Livro objeto){
        this.lista.add(objeto);
        return objeto;

    }


    public List<Livro> read(Livro objeto){
        return this.lista;
    }



    public Livro readID(String isbn) {
        for (Livro obj : this.lista){
            if (obj.getISBN().equals(isbn)){
                return obj;
            }
        }
        return null;
    }


    public Livro update(Livro obj){
        int index = this.lista.indexOf(obj);
        this.lista.set(index,obj);
        return obj;

    }


    public void delete(Livro obj){
        this.lista.remove(obj);
    }

    public void deleteMany(){
        this.lista.clear();
        this.proxId = 0;
    }

}
