package main.model;

import main.dao.LivroDAO;

import java.util.ArrayList;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private boolean status; // True = Aberto; False = Concluído
    private int id;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        livro.setReserva(true);
        this.status = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void finalizarReserva(){
        this.status = false;
        this.livro.setReserva(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
