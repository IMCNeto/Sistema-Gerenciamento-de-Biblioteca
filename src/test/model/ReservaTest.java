package test.model;

import main.dao.DAO;
import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    Emprestimo emprestimo1;
    Emprestimo emprestimo2;
    Emprestimo emprestimo3;
    Usuario Tiago;
    Usuario Sara;
    Usuario Pedro;
    Livro Livro1;
    Livro Livro2;
    Livro Livro3;
    ArrayList<Emprestimo> lista;
    @BeforeEach
    void setUp() throws Exception {

    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getLivroDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
    }

    @Test
    void finalizarReserva() throws Exception {
        Usuario usuario = DAO.getUsuarioDAO().create(new Usuario("Carlos","75988351212","Feira VI,Rua B")) ;
        Livro livro =DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2002));
        Reserva reserva = DAO.getReservaDAO().create(new Reserva(usuario,livro));

        assertTrue(reserva.isStatus());
        reserva.finalizarReserva();
        assertFalse(reserva.isStatus());

    }
}
