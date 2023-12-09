package dao;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Bibliotecario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Classe responsável por realizar os testes dos métodos da classe BibliotecárioDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class BibliotecarioDAOTest {

    Bibliotecario Tiago;
    Bibliotecario Pedro;
    Bibliotecario Maria;
    Bibliotecario Sara;

    @BeforeEach
    void setUp() throws Exception {
        Tiago = DAO.getBibliotecarioDAO().create(new Bibliotecario("Tiago","0090"));
        Pedro = DAO.getBibliotecarioDAO().create(new Bibliotecario("Pedro","0091"));
        Maria = DAO.getBibliotecarioDAO().create(new Bibliotecario("Maria","0092"));
        Sara = DAO.getBibliotecarioDAO().create(new Bibliotecario("Sara","0093"));
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
        Bibliotecario atual = DAO.getBibliotecarioDAO().create(new Bibliotecario("Neto","0094"));
        Bibliotecario esperado = DAO.getBibliotecarioDAO().readID(4);

        /*
        Verificando se a lista esperada não está vazia e se é igual ao esperado, após criar um objeto no DAO
         */
        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getBibliotecarioDAO().delete(Sara);
        int atual = DAO.getBibliotecarioDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getBibliotecarioDAO().deleteMany();
        int atual = DAO.getBibliotecarioDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setSenha("0099");
        Tiago.setNome("Thiago");
        Bibliotecario atual = DAO.getBibliotecarioDAO().update(Tiago);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getBibliotecarioDAO().read().size();

        /*
        Como adicionamos apenas 4 livros para realizar os testes, o tamanho da lista total deve ser 4;
         */
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Bibliotecario atual = DAO.getBibliotecarioDAO().readID(1);

        /*
        Pedro é o bibliotecário com ID 1, logo deve ser o atual;
         */
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }
}
