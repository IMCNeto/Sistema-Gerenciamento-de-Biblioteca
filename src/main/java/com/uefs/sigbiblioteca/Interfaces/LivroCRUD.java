package com.uefs.sigbiblioteca.Interfaces;

import com.uefs.sigbiblioteca.model.Livro;

import java.time.LocalDate;
import java.util.List;


/**
 * Interface para implementar o LivroDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface LivroCRUD extends CRUD<Livro, Exception>{
    public List<Livro> readByISBN(String isbn) throws Exception;

    public List<Livro> readByTitulo(String titulo) throws Exception;

    public List<Livro> readByAutor(String autor) throws Exception;

    public List<Livro> readByCategoria(String categoria) throws Exception;

    public List<String> readMoreUsed(int n) throws Exception;

    public  Livro updateIndex(int index,Livro livro);

    public Livro findbyIndex(int index);

    public int numBorrowed(LocalDate dataAtual) throws Exception;

    public int numReserved() throws Exception;

    public int numEmp() throws Exception;
}
