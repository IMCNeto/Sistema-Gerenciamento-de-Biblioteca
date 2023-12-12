package dao;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe responsável por realizar os testes dos métodos da classe EmprestimoDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class EmprestimoDAOTest {

    Emprestimo emprestimo1;
    Emprestimo emprestimo2;
    Usuario Tiago;
    Usuario Pedro;
    Usuario Sara;
    Livro Livro1;
    Livro Livro2;
    Livro Livro3;
    ArrayList<Emprestimo> lista;

    /**
     * Método executado antes de cada teste para preenchimento dos dados para realizar os testes;
     *
     */
    @BeforeEach
    void setUp() throws Exception {
        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2000));
        Livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJR20","Romance",2000));
        Livro3 = DAO.getLivroDAO().create(new Livro("Enrolados", "Abreu", "D", "DAR20", "Romance", 2000));
        emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,Livro1));
        emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("16/09/2023",Pedro,Livro2));

    }

    /**
     * Método executado após cada teste, responsável por apagar os dados do armazenamento, para que não ocorra erros
     * nos testes;
     *
     */
    @AfterEach
    void tearDown() throws Exception {
        DAO.getLivroDAO().deleteMany();
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
        DAO.getReservaDAO().deleteMany();
        DAO.getBibliotecarioDAO().deleteMany();
        DAO.getAdministradorDAO().deleteMany();
    }

    /**
     * Caso de teste que verifica se está funcionando a implementação de um novo empréstimo no armazenamento de dados
     * através do DAO;
     *
     */
    @Test
    void criar() throws Exception {
        Emprestimo atual = DAO.getEmprestimoDAO().create(new Emprestimo("19/09/2023",Sara,Livro3));
        Emprestimo esperado = DAO.getEmprestimoDAO().findbyID(2);

        /*
        Verificando se a lista esperada não está vazia e se é igual ao esperado, após criar um objeto no DAO
         */
        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    /**
     * Caso de teste que verifica se ao tentar deletar um empréstimo do DAO, ele deleta;
     * Inicialmente a lista contém 2 empréstimos, utilizamos o método de DELETE e verificamos se a lista diminuiu;
     */
    @Test
    void deletarObj() throws Exception {
        DAO.getEmprestimoDAO().delete(emprestimo1);
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(1,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se todos os dados sobre empréstimos são apagados se utilizar o método de deletar tudo;
     *
     */
    @Test
    void deletarTudo() throws Exception{
        DAO.getEmprestimoDAO().deleteMany();
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    /**
     * Caso de teste que verifica se a atualização de dados está sendo feita de forma correta pelo DAO;
     *
     */
    @Test
    void atualizar() throws Exception {
        emprestimo1.setDataEmprestimo("20/09/2023");
        emprestimo1.setUsuario(Sara);
        Emprestimo atual = DAO.getEmprestimoDAO().update(emprestimo1);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(emprestimo1,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se a lista completa de empréstimos está sendo retornada corretamente;
     *
     */
    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Como adicionamos apenas 2 Empréstimos para realizar os testes, o tamanho da lista total deve ser 2;
         */
        assertEquals(2,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se quando buscamos um empréstimo por um ID, ele está sendo retornado;
     *
     */
    @Test
    void lerID() throws Exception{
        Emprestimo atual = DAO.getEmprestimoDAO().findbyID(0);
        assertEquals(emprestimo1,atual,"Esse teste deveria passar!");
    }


}
