package main.Interfaces;

import main.model.Emprestimo;
import main.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoCRUD extends CRUD<Emprestimo, Exception>{

    public List<Emprestimo> atrasados(LocalDate dataAtual) throws Exception;

    public Emprestimo findbyID(int id) throws Exception;

    public List<Emprestimo> findbyUser(Usuario user) throws Exception;

    public List<Emprestimo> findbyUserActive(Usuario usuario) throws Exception;

    public List<Emprestimo> findEmpActive() throws Exception;

}
