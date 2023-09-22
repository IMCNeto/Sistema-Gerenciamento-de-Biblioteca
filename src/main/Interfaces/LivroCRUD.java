package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;

import java.util.List;

public interface LivroCRUD extends CRUD<Livro, Exception>{
    public Livro create(Livro obj);

    public List<Livro> read();

    public Livro readID(String isbn);

    public void delete(Livro obj) throws Exception;

    public void deleteMany();
}
