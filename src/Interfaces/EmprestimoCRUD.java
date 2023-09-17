package Interfaces;

import model.Emprestimo;
import model.Usuario;

import java.util.List;

public interface EmprestimoCRUD extends CRUD<Emprestimo>{
    public Emprestimo create(Emprestimo obj);

    public List<Emprestimo> read(Emprestimo obj);

    public List<Emprestimo> findbyID(Usuario user);

    public void delete(Emprestimo obj);

    public void deleteMany();

}
