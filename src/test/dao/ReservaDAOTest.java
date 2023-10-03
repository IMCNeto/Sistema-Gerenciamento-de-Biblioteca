package test.dao;

import main.dao.DAO;
import main.dao.ReservaDAO;
import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe responsável por realizar os testes dos métodos da classe ReservaDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class ReservaDAOTest {
    Reserva reserva1;
    Reserva reserva2;
    Usuario Tiago;
    Usuario Pedro;
    Usuario Sara;
    Livro Livro1;
    Livro Livro2;

    public ReservaDAOTest() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2000));
        Livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJR20","Romance",2000));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("20/09/2023",Tiago,Livro1));
        Emprestimo emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("20/09/2023",Pedro,Livro2));
        reserva1 = DAO.getReservaDAO().create(new Reserva(Tiago,Livro1));
        reserva2 = DAO.getReservaDAO().create(new Reserva(Pedro,Livro2));

    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getReservaDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
        DAO.getLivroDAO().deleteMany();
        DAO.getEmprestimoDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
        Reserva atual = DAO.getReservaDAO().create(new Reserva(Sara,Livro1));
        Reserva esperado = DAO.getReservaDAO().findReserva(Sara,Livro1);

        /*
        Verificando se a lista esperada não está vazia e se é igual ao esperado, após criar um objeto no DAO
         */
        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getReservaDAO().delete(reserva1);
        int atual = DAO.getReservaDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(1,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getReservaDAO().deleteMany();
        int atual = DAO.getReservaDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        reserva2.setLivro(Livro1);
        reserva2.setUsuario(Sara);
        Reserva atual = DAO.getReservaDAO().update(reserva2);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(reserva2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getReservaDAO().read().size();

        /*
        Como adicionamos apenas 2 reservas para realizar os testes, o tamanho da lista total deve ser 2;
         */
        assertEquals(2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Reserva atual = DAO.getReservaDAO().findReserva(Tiago,Livro1);
        assertEquals(reserva1,atual,"Esse teste deveria passar!");
    }

    @Test
    void findReserva() throws Exception {
        Reserva esperada = DAO.getReservaDAO().findReserva(Tiago, Livro1);

    /*
    reserva1 foi realizada pelo usuário Tiago, reservando o livro, logo esperada tem que ser igual a reserva1;
     */
        assertEquals(esperada,reserva1);
    }

    @Test
    void firstReservaLivro() throws Exception {
        Reserva esperada = DAO.getReservaDAO().firstReservaLivro(Livro2);

        /*
        A única reserva do Livro 2 foi a reserva 2, logo ela é a primeira e deve ser comparada com a esperada
         */

        assertEquals(esperada,reserva2);

    }

    @Test
    void lerReservaAtiva() throws Exception{
        /*
        Alterando o status da reserva2, uma das duas reservas existentes, para false. Logo, a lista de reservas ativas deverá conter um elemento que é a reserva1!
         */
        reserva2.setStatus(false);
        DAO.getReservaDAO().update(reserva2);
        List<Reserva> atual = DAO.getReservaDAO().findReservaActive();
        List<Reserva> esperado = new ArrayList<>();
        esperado.add(reserva1);

        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");

    }
}


