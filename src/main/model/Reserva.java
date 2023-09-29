package main.model;

import main.dao.DAO;
import main.dao.LivroDAO;

import java.util.ArrayList;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private boolean status; // True = Aberto; False = Concluído
    private int id;

    public Reserva(Usuario usuario, Livro livro) throws Exception {
        this.usuario = usuario;
        this.livro = livro;
        livro.setReserva(true);
        this.status = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) throws Exception {
        this.usuario = usuario;
        DAO.getReservaDAO().update(this);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) throws Exception {
        this.livro = livro;
        DAO.getReservaDAO().update(this);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) throws Exception {
        this.status = status;
        DAO.getReservaDAO().update(this);
    }

    public void finalizarReserva() throws Exception {
        this.status = false;
        this.livro.setReserva(false);
        DAO.getReservaDAO().update(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        this.id = id;
        DAO.getReservaDAO().update(this);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", livro=" + livro +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
