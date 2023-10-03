package main.model;

import main.dao.DAO;
import main.dao.EmprestimoDAO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/** Classe para objetos do tipo empréstimo, onde serão contidos os valores e métodos para o mesmo
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */

public class Emprestimo {

    /**
     * Data que o empréstimo foi realizado;
     */
    private LocalDate dataEmprestimo;

    /**
     * Data que o empréstimo deve ser devolvido;
     */
    private LocalDate dataDevolver;

    /**
     * Objeto do tipo Usuário que está realizando o empréstimo;
     */
    private Usuario usuario;

    /**
     * Objeto do tipo Livro que está sendo emprestado;
     */
    private Livro livro;

    /**
     * Indicador que mostra se o empréstimo está ativo;
     */
    private int status; // 0 = Em andamento; 1 = Finalizado

    /**
     * ID - Atributo identificador único;
     */
    private int id;


    /**
     *
      * @param datEmprestimo  data que o empréstimo vai ser realizado;
     * @param usuario usuário que está realizando o empréstimo;
     * @param livro livro que está sendo emprestado;
     */
    public Emprestimo(String datEmprestimo, Usuario usuario,Livro livro) throws Exception {

        /*
          Verificando se o usuário está multado
         */
        if (usuario.getMulta() != 0){
                throw new IllegalArgumentException("Usuário tem multa ativa");
            }

        /*
          Verificando se o usuário está multado
         */
        if(livro.isEmprestimo()) {
                throw new IllegalArgumentException("Livro não pode ser emprestado");
            }

        /*
        Verificando se o usuário já atingiu o limite de empréstimos
         */
        if (DAO.getEmprestimoDAO().findbyUserActive(usuario).size() >= 3){
            throw new IllegalArgumentException("Usuário atingiu número máximo de empréstimos");
        }

        /*
        Verificando se o livro tem reserva ativa, se tiver verifica se a reserva é do usuário que está tentando realizar o empréstimo
         */
        if(livro.isReserva() && !DAO.getReservaDAO().findReservaActive().isEmpty() && DAO.getReservaDAO().firstReservaLivro(livro).getUsuario().equals(usuario)){
            livro.setReserva(false);
        }
        else if(livro.isReserva() && !DAO.getReservaDAO().firstReservaLivro(livro).getUsuario().equals(usuario)){
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

        /*
        Transforma uma string no formato "dd/MM/yyyy" para  um LocalDate
         */
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

    /**
     * Método utilizado para renovar um empréstimo ativo por 7 dias;
     * @param dataAtual Recebe a data que está tentando renovar o empréstimo;
     *
     */
    public void renovarEmprestimo(LocalDate dataAtual) throws Exception {
        /*
        Verifica se o usuário está tentando fazer 2 renovações consecutivas == PROIBIDO
         */
        if (ChronoUnit.DAYS.between(this.dataEmprestimo, dataAtual) >= 14){
            throw new IllegalArgumentException("Limite de renovações atingido");
        }

        /*
        Verifica se o livro está reservado
         */
        if (this.livro.isReserva()){
            throw new IllegalArgumentException("Livro está reservado");
        }

        /*
        Verifica se a data de devolução era igual à data atual, o usuário só pode renovar no dia da devolução
         */
        if (!dataDevolver.equals(dataAtual)){
            throw new IllegalArgumentException("Empréstimo não pode ser realizado");
        }

        /*
        Verifica se o usuário não está bloqueado
         */
        if(DAO.getUsuarioDAO().usuariosBloqueados(dataAtual).contains(this.usuario)){
            throw new IllegalArgumentException("Usuário não pode realizar empréstimo");
        }

        this.dataDevolver = this.dataDevolver.plus(Period.ofDays(7));
        DAO.getEmprestimoDAO().update(this);

    }


    /**
     * Método utilizado para finalizar um empréstimo, alterando seus atributos;
     * @param dataAtual  Recebe a data que está tentando renovar o empréstimo;
     *
     */
    public void finalizarEmprestimo(LocalDate dataAtual) throws Exception {
        this.status = 1;
        livro.setEmprestimo(false);
        usuario.calcularMulta(dataDevolver,dataAtual);
        DAO.getEmprestimoDAO().update(this);
    }
}
