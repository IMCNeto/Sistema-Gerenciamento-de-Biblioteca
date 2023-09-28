package main.model;

import main.dao.EmprestimoDAO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

        private LocalDate dataEmprestimo;
        private LocalDate dataDevolver;
        private Usuario usuario;
        private Livro livro;
        private int status; // 0 = Em andamento; 1 = Finalizado
        private int id;


    public Emprestimo(String datEmprestimo, Usuario usuario,Livro livro) {
            if (usuario.getMulta() == 0){
                this.usuario = usuario;
            }
            else{
                throw new IllegalArgumentException("Usuário não pode realizar Empréstimo");
            }

            if(livro.isEmprestimo().equals("Livre")) {
                this.livro = livro;
            }
            else {
                throw new IllegalArgumentException("Livro não pode ser emprestado");
            }
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dataEmprestimo = LocalDate.parse(datEmprestimo,formatter);
            this.dataDevolver =  dataEmprestimo.plus(Period.ofDays(7));
            this.status = 0;
                }



    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEmprestimo = LocalDate.parse(dataEmprestimo,formatter);
    }

    public LocalDate getDataDevolver() {
        return dataDevolver;
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

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }


    //método para finalizar o empréstimo
    public void finalizarEmprestimo(LocalDate dataAtual){
        this.status = 1;
        livro.setEmprestimo(false);
        usuario.calcularMulta(dataDevolver,dataAtual);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataEmprestimo=" + dataEmprestimo +
                ", dataDevolver=" + dataDevolver +
                ", usuario=" + usuario +
                ", livro=" + livro +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
