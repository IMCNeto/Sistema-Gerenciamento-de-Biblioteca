package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;

import java.util.HashMap;
import java.util.List;

public interface LivroCRUD extends CRUD<Livro, Exception>{
    public List<Livro> readByISBN(String isbn) throws Exception;

    public List<Livro> readByTitulo(String titulo) throws Exception;

    public List<Livro> readByAutor(String autor) throws Exception;

    public List<Livro> readByCategoria(String categoria) throws Exception;

    public HashMap<String,Integer> readMoreUsed() throws Exception;
}
