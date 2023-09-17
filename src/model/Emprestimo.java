package model;

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


    public Emprestimo(String datEmprestimo, Usuario usuario,Livro livro) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEmprestimo = LocalDate.parse(datEmprestimo,formatter);
        this.dataDevolver =  dataEmprestimo.plus(Period.ofDays(7));
        this.usuario = usuario;
        this.livro = livro;
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


    public int calcularMulta(LocalDate dataDevolver){
        LocalDate hoje  = LocalDate.now();//recolhe a data atual
        long d1 = ChronoUnit.DAYS.between(dataDevolver, hoje); // subtrai a diferença entre as datas
        if (d1 <= 0){
            return 0;
        }
        else {
            return (int)d1;
        }
    }

    public Emprestimo realizarEmprestimo(){
        if (usuario.getMulta() == 0){
            if(livro.getStatus().equals("Livre")) {
                this.status = 0;
                return this;
            }
        }
        return null;

    }



    //método para finalizar o empréstimo
    public void finalizarEmprestimo(){
        this.status = 1;
        livro.liberarLivro();
        int multa = calcularMulta(dataDevolver);
        usuario.setMulta(multa);
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
}
