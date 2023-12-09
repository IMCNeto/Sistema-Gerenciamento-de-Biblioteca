package dao;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Administrador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe responsável por realizar os testes dos métodos da classe AdministradorDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class AdministradorDAOTest {

    Administrador Tiago;
    Administrador Pedro;
    Administrador Maria;
    Administrador Sara;

    @BeforeEach
    void setUp() throws Exception {
        Tiago = DAO.getAdministradorDAO().create(new Administrador("Tiago","0090"));
        Pedro = DAO.getAdministradorDAO().create(new Administrador("Pedro","0091"));
        Maria = DAO.getAdministradorDAO().create(new Administrador("Maria","0092"));
        Sara = DAO.getAdministradorDAO().create(new Administrador("Sara","0093"));
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
        Administrador atual = DAO.getAdministradorDAO().create(new Administrador("Neto","0094"));
        Administrador esperado = DAO.getAdministradorDAO().readID(4);

        /*
        Verificando se a lista esperada não está vazia e se é igual ao esperado, após criar um objeto no DAO
         */
        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getAdministradorDAO().delete(Sara);
        int atual = DAO.getAdministradorDAO().read().size();

        /*
        Excluindo um objeto da lista que tinha tamanho 4, a lista deve ser 3;
         */
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getAdministradorDAO().deleteMany();
        int atual = DAO.getAdministradorDAO().read().size();

         /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setNome("Thiago");
        Tiago.setSenha("0099");
        Administrador atual = DAO.getAdministradorDAO().update(Tiago);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getAdministradorDAO().read().size();

        /*
        Como adicionamos apenas 4 Administradores para realizar os testes, o tamanho da lista total deve ser 4;
         */
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Administrador atual = DAO.getAdministradorDAO().readID(1);

        /*
        Pedro é o administrador com ID 1, logo deve ser o atual;
         */
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }
}
