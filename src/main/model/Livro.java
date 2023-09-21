package main.model;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private String ISBN;
    private boolean emprestimo;// true = emprestado; false = livre
    private boolean reserva; // true = reservado; false = livre
    private String categoria;
    private int ano;


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

    public String isEmprestimo() {
        if (emprestimo) {
            return "Emprestado";
        } else {
            return "Livre";
        }

    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public String isReserva() {
        if (reserva) {
            return "Reservado";
        } else {
            return "Livre";
        }

    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
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
                '}';
    }
}
