package test.dao;

import main.dao.DAO;
import main.model.Bibliotecario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BibliotecarioDAOTest {

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
        DAO.getBibliotecarioDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
        Bibliotecario atual = DAO.getBibliotecarioDAO().create(new Bibliotecario("Neto","0094"));
        Bibliotecario esperado = DAO.getBibliotecarioDAO().readID(4);

        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getBibliotecarioDAO().delete(Sara);
        int atual = DAO.getBibliotecarioDAO().read().size();
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getBibliotecarioDAO().deleteMany();
        int atual = DAO.getBibliotecarioDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setSenha("0099");
        Tiago.setNome("Thiago");
        Bibliotecario atual = DAO.getBibliotecarioDAO().update(Tiago);
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getBibliotecarioDAO().read().size();
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Bibliotecario atual = DAO.getBibliotecarioDAO().readID(1);
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }
}
