package com.uefs.sigbiblioteca.model;

import com.uefs.sigbiblioteca.dao.DAO;


/** Classe para objetos do tipo livro, onde serão contidos os valores e métodos para o mesmo;
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */

public class Livro {

    /**
     * Nome do título do objeto livro;
     */
    private String titulo;

    /**
     * Nome do autor do livro;
     */
    private String autor;

    /**
     * Nome da editora do livro;
     */
    private String editora;

    /**
     * Atributo referente ao ISBN(International Standard Book Number);
     */
    private String ISBN;

    /**
     * Condição referente ao estado atual do empréstimo do livro;
     */
    private boolean emprestimo;// true = emprestado; false = livre

    /**
     * Condição referente ao estado atual da reserva do livro;
     */
    private boolean reserva; // true = reservado; false = livre

    /**
     * String referente a categoria do livro;
     */
    private String categoria;

    /**
     * Ano de publicação;
     */
    private int ano;

    /**
     * ID - Atributo identificador único;
     */
    private int id;


    /**
     *
     * @param titulo título do livro;
     * @param autor autor do livro;
     * @param editora editora do livro;
     * @param ISBN  ISBN do livro;
     * @param categoria categoria do livro;
     * @param ano   ano de publicação;
     */
    public Livro(String titulo, String autor, String editora, String ISBN, String categoria, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ISBN = ISBN;
        this.categoria = categoria;
        this.ano = ano;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        this.titulo = titulo;
        DAO.getLivroDAO().update(this);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        this.autor = autor;
        DAO.getLivroDAO().update(this);
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) throws Exception {
        this.editora = editora;
        DAO.getLivroDAO().update(this);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) throws Exception {
        this.ISBN = ISBN;
        DAO.getLivroDAO().update(this);
    }


    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) throws Exception {
        this.categoria = categoria;
        DAO.getLivroDAO().update(this);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) throws Exception {
        this.ano = ano;
        DAO.getLivroDAO().update(this);
    }

    public boolean isEmprestimo() {
        return this.emprestimo;

    }

    public void setEmprestimo(boolean emprestimo) throws Exception {
        this.emprestimo = emprestimo;
        DAO.getLivroDAO().update(this);
    }

    public boolean isReserva() {
        return this.reserva;

    }

    public void setReserva(boolean reserva) throws Exception {
        this.reserva = reserva;
        DAO.getLivroDAO().update(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        this.id = id;
        DAO.getLivroDAO().update(this);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", emprestimo=" + emprestimo +
                ", reserva=" + reserva +
                ", categoria='" + categoria + '\'' +
                ", ano=" + ano +
                ", id=" + id +
                '}';
    }
}
