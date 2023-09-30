package main.model;

import main.dao.DAO;
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


    public Emprestimo(String datEmprestimo, Usuario usuario,Livro livro) throws Exception {
            if (usuario.getMulta() != 0){
                throw new IllegalArgumentException("Usuário tem multa ativa");
            }

            if(livro.isEmprestimo()) {
                throw new IllegalArgumentException("Livro não pode ser emprestado");
            }

            if (DAO.getEmprestimoDAO().findbyUserActive(usuario).size() >= 3){
                throw new IllegalArgumentException("Usuário atingiu número máximo de empréstimos");
            }

            if(livro.isReserva() & DAO.getReservaDAO().firstReservaLivro(livro).getUsuario().equals(usuario)){
                livro.setReserva(false);
            }
            else if(livro.isReserva() & !DAO.getReservaDAO().firstReservaLivro(livro).getUsuario().equals(usuario)){
                throw new Exception("Livro está reservado");

            }

            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.usuario = usuario;
            this.dataEmprestimo = LocalDate.parse(datEmprestimo,formatter);
            this.dataDevolver =  dataEmprestimo.plus(Period.ofDays(7));
            this.status = 0;
            this.livro = livro;
            this.livro.setEmprestimo(true);
    }



    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) throws Exception {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEmprestimo = LocalDate.parse(dataEmprestimo,formatter);
        DAO.getEmprestimoDAO().update(this);
    }

    public LocalDate getDataDevolver() {
        return dataDevolver;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) throws Exception {
        this.usuario = usuario;
        DAO.getEmprestimoDAO().update(this);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) throws Exception {
        this.status = status;
        DAO.getEmprestimoDAO().update(this);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) throws Exception {
        this.livro = livro;
        DAO.getEmprestimoDAO().update(this);
    }


    public void renovarEmprestimo(LocalDate dataAtual) throws Exception {
        //verifica se o usuário está tentando fazer 2 renovações consecutivas == PROIBIDO
        if (ChronoUnit.DAYS.between(dataEmprestimo, dataAtual) >= 14){
            throw new IllegalArgumentException("Limite de renovações atingido");
        }

        //verifica se o livro está reservado
        if (this.livro.isReserva()){
            throw new IllegalArgumentException("Livro está reservado");
        }

        //verifica se a data de devolução era igual à data atual, o usuário só pode renovar no dia da devolução
        if (!dataDevolver.equals(dataAtual)){
            System.out.println(this.dataDevolver);
            throw new IllegalArgumentException("Empréstimo não pode ser realizado");
        }

        //verifica se o usuário não está bloqueado
        if(DAO.getUsuarioDAO().usuariosBloqueados(DAO.getEmprestimoDAO().atrasados(dataAtual)).contains(this.usuario)){
            throw new IllegalArgumentException("Usuário não pode realizar empréstimo");
        }

        this.dataDevolver = this.dataDevolver.plus(Period.ofDays(7));
        DAO.getEmprestimoDAO().update(this);

        }


    //método para finalizar o empréstimo
    public void finalizarEmprestimo(LocalDate dataAtual) throws Exception {
        this.status = 1;
        livro.setEmprestimo(false);
        usuario.calcularMulta(dataDevolver,dataAtual);
        DAO.getEmprestimoDAO().update(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        this.id = id;
        DAO.getEmprestimoDAO().update(this);
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
