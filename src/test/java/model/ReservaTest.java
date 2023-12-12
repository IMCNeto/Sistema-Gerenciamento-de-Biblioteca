package model;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Reserva;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe responsável por realizar os testes dos métodos da classe Reserva
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class ReservaTest {

    Emprestimo emprestimo1;
    Emprestimo emprestimo2;
    Emprestimo emprestimo3;
    Usuario Tiago;
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

    }

    /**
     * Método executado após cada teste, responsável por apagar os dados do armazenamento, para que não ocorra erros
     * nos testes;
     *
     */
    @AfterEach
    void tearDown() throws Exception {
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getLivroDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
    }

    /**
     * Caso de teste que verifica se o método de finalizar reserva está alterando os parâmetros
     * necessários;
     */
    @Test
    void finalizarReserva() throws Exception {
        Usuario usuario = DAO.getUsuarioDAO().create(new Usuario("Carlos","75988351212","Feira VI,Rua B")) ;
        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro livro = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2002));
        
        Emprestimo emprestimoNovo = DAO.getEmprestimoDAO().create(new Emprestimo("20/09/2023", Pedro, livro));
        Reserva reserva = DAO.getReservaDAO().create(new Reserva(usuario,livro));

        /*
        Conferindo se reserva está ativa;
         */
        assertTrue(reserva.isStatus());

        reserva.finalizarReserva();
        /*
        Conferindo se reserva foi finalizada;
         */
        assertFalse(reserva.isStatus());

    }
}
