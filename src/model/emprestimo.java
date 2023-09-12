package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class emprestimo {

        private Date dataEmprestimo;
        private Date dataDevolver;
        private Usuario usuario;
        private int status;


    public emprestimo(String dataEmprestimo, Usuario usuario, int status) {
        try {
            this.dataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmprestimo);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.usuario = usuario;
        this.status = status;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolver() {
        return dataDevolver;
    }

    public void setDataDevolver(Date dataDevolver) {
        this.dataDevolver = dataDevolver;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
