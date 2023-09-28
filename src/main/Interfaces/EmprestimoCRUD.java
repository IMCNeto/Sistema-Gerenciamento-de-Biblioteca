package main.Interfaces;

import main.model.Emprestimo;
import main.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoCRUD extends CRUD<Emprestimo, Exception>{

    public List<Emprestimo> atrasados(LocalDate dataAtual);

    public Emprestimo findbyID(int id);

    public List<Emprestimo> findbyUser(Usuario user);


}
