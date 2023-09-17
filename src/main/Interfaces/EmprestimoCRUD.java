package main.Interfaces;

import main.model.Emprestimo;
import main.model.Usuario;

import java.util.List;

public interface EmprestimoCRUD extends CRUD<Emprestimo>{
    public Emprestimo create(Emprestimo obj);

    public List<Emprestimo> read(Emprestimo obj);

    public List<Emprestimo> findbyID(Usuario user);

    public void delete(Emprestimo obj);

    public void deleteMany();

}
