package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;

import java.util.List;

public interface LivroCRUD extends CRUD<Livro, Exception>{
    public Livro readISBN(String isbn) throws Exception;

    public Livro readTitulo(String titulo) throws Exception;

    public Livro readAutor(String autor) throws Exception;

    public Livro readCategoria(String categoria) throws Exception;

}
