package test.dao;

import main.dao.DAO;
import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaDAOTest {
    Reserva reserva1;
    Reserva reserva2;
    Usuario Tiago;
    Usuario Pedro;
    Usuario Sara;
    Livro Livro1;
    Livro Livro2;

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

        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getReservaDAO().delete(reserva1);
        int atual = DAO.getReservaDAO().read().size();
        assertEquals(1,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getReservaDAO().deleteMany();
        int atual = DAO.getReservaDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        reserva2.setLivro(Livro1);
        reserva2.setUsuario(Sara);
        Reserva atual = DAO.getReservaDAO().update(reserva2);
        assertEquals(reserva2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getReservaDAO().read().size();
        assertEquals(2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Reserva atual = DAO.getReservaDAO().findReserva(Tiago,Livro1);
        assertEquals(reserva1,atual,"Esse teste deveria passar!");
    }
}


