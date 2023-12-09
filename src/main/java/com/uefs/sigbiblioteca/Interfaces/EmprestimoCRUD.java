package com.uefs.sigbiblioteca.Interfaces;

import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;


/**
 * Interface para implementar o EmpréstimoDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface EmprestimoCRUD extends CRUD<Emprestimo, Exception>{

    public List<Emprestimo> atrasados(LocalDate dataAtual) throws Exception;

    public Emprestimo findbyID(int id) throws Exception;

    public List<Emprestimo> findbyUser(Usuario user) throws Exception;

    public List<Emprestimo> findbyUserActive(Usuario usuario) throws Exception;

    public List<Emprestimo> findEmpActive() throws Exception;

}
