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

    @AfterEach
    void tearDown() throws Exception {
        DAO.getLivroDAO().deleteMany();
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
        DAO.getReservaDAO().deleteMany();
        DAO.getBibliotecarioDAO().deleteMany();
        DAO.getAdministradorDAO().deleteMany();
    }

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

    @Test
    void deletarObj() throws Exception {
        DAO.getEmprestimoDAO().delete(emprestimo1);
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(1,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getEmprestimoDAO().deleteMany();
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

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

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getEmprestimoDAO().read().size();

        /*
        Como adicionamos apenas 2 Empréstimos para realizar os testes, o tamanho da lista total deve ser 2;
         */
        assertEquals(2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Emprestimo atual = DAO.getEmprestimoDAO().findbyID(0);
        assertEquals(emprestimo1,atual,"Esse teste deveria passar!");
    }


}
