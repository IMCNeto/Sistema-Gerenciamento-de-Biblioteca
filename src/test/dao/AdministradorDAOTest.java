package test.dao;

import main.dao.DAO;
import main.model.Administrador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        DAO.getAdministradorDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
        Administrador atual = DAO.getAdministradorDAO().create(new Administrador("Neto","0094"));
        Administrador esperado = DAO.getAdministradorDAO().readID(4);

        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getAdministradorDAO().delete(Sara);
        int atual = DAO.getAdministradorDAO().read().size();
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getAdministradorDAO().deleteMany();
        int atual = DAO.getAdministradorDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setNome("Thiago");
        Tiago.setSenha("0099");
        Administrador atual = DAO.getAdministradorDAO().update(Tiago);
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getAdministradorDAO().read().size();
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Administrador atual = DAO.getAdministradorDAO().readID(1);
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }
}
