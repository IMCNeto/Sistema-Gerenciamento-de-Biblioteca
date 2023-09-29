package main.model;

import main.dao.DAO;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private String ISBN;
    private boolean emprestimo;// true = emprestado; false = livre
    private boolean reserva; // true = reservado; false = livre
    private String categoria;
    private int ano;
    private int id;


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

    public String isReserva() {
        if (reserva) {
            return "Reservado";
        } else {
            return "Livre";
        }

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
