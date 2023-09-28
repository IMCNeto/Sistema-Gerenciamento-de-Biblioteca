package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;

import java.util.List;

public interface LivroCRUD extends CRUD<Livro, Exception>{
    public Livro readISBN(String isbn);

    public Livro readTitulo(String titulo);

    public Livro readAutor(String autor);

    public Livro readCategoria(String categoria);

}
