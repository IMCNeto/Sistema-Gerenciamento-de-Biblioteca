package test.dao;

import main.dao.DAO;
import main.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOTest {
    Usuario Tiago;
    Usuario Pedro;
    Usuario Maria;
    Usuario Sara;

    @BeforeEach
    void setUp() throws Exception {
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Maria = DAO.getUsuarioDAO().create(new Usuario("Maria","75982830092","R. C,12,Feira VI"));
        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getUsuarioDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
       Usuario atual = DAO.getUsuarioDAO().create(new Usuario("Rute","75982830094","R. E,8,Feira VI"));
       Usuario esperado = DAO.getUsuarioDAO().readID(4);

       assertEquals(esperado,atual,"Esse teste deveria passar!");
       assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getUsuarioDAO().delete(Sara);
        int atual = DAO.getUsuarioDAO().read().size();
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getUsuarioDAO().deleteMany();
        int atual = DAO.getUsuarioDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setNome("Thiago");
        Tiago.setTelefone("75982830099");
        Usuario atual = DAO.getUsuarioDAO().update(Tiago);
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getUsuarioDAO().read().size();
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Usuario atual = DAO.getUsuarioDAO().readID(1);
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }
    @Test
    void ususarioBloqueado(){

    }

}






