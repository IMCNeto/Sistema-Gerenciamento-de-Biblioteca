package main.model;

import main.dao.DAO;
import main.dao.LivroDAO;

import java.util.ArrayList;


/** Classe para objetos do tipo reserva, onde serão contidos os valores e métodos para o mesmo;
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */

public class Reserva {

    /**
     * Objeto do tipo Usuário que está realizando a reserva;
     */
    private Usuario usuario;

    /**
     * Objeto do tipo Livro que está sendo emprestado;
     */
    private Livro livro;

    /**
     * Condição referente ao estado atual da reserva (True = Em andamento; False = Concluído);
     */
    private boolean status;

    /**
     * ID - Atributo identificador único;
     */
    private int id;


    /**
     *
     * @param usuario usuário que está realizando a reserva;
     * @param livro livro que está sendo reservado;
     *
     */
    public Reserva(Usuario usuario, Livro livro) throws Exception {
        if(!livro.isEmprestimo()){
        throw new IllegalArgumentException("Livro não está emprestado");
        }

        if (usuario.getMulta() != 0){
            throw new IllegalArgumentException("Usuário tem multa ativa");
        }
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

    /**
     * Método responsável por finalizar reserva, alterando os atributos referente a condição atual da reserva;
     */
    public void finalizarReserva() throws Exception {
        this.status = false;
        this.livro.setReserva(false);
        DAO.getReservaDAO().update(this);
    }
}
