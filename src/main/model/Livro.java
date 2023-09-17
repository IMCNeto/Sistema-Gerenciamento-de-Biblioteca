package main.model;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private String ISBN;
    private int status; // condição: 0-Livre 1-Emprestado 2-Reservado
    private String categoria;
    private int ano;


    public Livro(String titulo, String autor, String editora, String ISBN, int status, String categoria, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ISBN = ISBN;
        this.categoria = categoria;
        this.ano = ano;
        this.status = status;

    }

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }





    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    //verifica se o livro está disponível
    public String  getStatus() {
        if (status == 0) {
            return "Livre";
        } else if (status == 1) {
            return "Emprestado";
        } else {
            return "Reservado";
        }
    }


    public void liberarLivro(){
        this.status = 0;
    }

    public void emprestarLivro(){
        this.status = 1;
    }

    public void reservarLivro(){
        this.status = 2;
    }

}
