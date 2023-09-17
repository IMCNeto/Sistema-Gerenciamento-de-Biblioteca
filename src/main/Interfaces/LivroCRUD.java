package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;

import java.util.List;

public interface LivroCRUD extends CRUD<Livro>{
    public Emprestimo create(Emprestimo obj);

    public List<Emprestimo> read(Emprestimo obj);

    public Livro readID(String isbn);

    public void delete(Emprestimo obj);

    public void deleteMany();
}
