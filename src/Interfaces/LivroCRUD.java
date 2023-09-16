package Interfaces;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.util.List;

public interface LivroCRUD extends CRUD<Livro>{
    public Emprestimo create(Emprestimo obj);

    public List<Emprestimo> read(Emprestimo obj);

    public Livro readID(String isbn);

    public void delete(Emprestimo obj);

    public void deleteMany();
}
