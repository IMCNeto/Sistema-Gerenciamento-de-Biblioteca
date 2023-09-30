package test.dao;

import main.dao.DAO;
import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoDAOTest {

    Emprestimo emprestimo1;
    Emprestimo emprestimo2;
    Usuario Tiago;
    Usuario Pedro;
    Usuario Sara;
    Livro Livro1;
    Livro Livro2;
    ArrayList<Emprestimo> lista;

    @BeforeEach
    void setUp() throws Exception {
        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2000));
        Livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJR20","Romance",2000));
        emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,Livro1));
        emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("16/09/2023",Pedro,Livro2));

    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getEmprestimoDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
        Emprestimo atual = DAO.getEmprestimoDAO().create(new Emprestimo("19/09/2023",Sara,Livro1));
        Emprestimo esperado = DAO.getEmprestimoDAO().findbyID(2);

        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getEmprestimoDAO().delete(emprestimo1);
        int atual = DAO.getEmprestimoDAO().read().size();
        assertEquals(1,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getEmprestimoDAO().deleteMany();
        int atual = DAO.getEmprestimoDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        emprestimo1.setDataEmprestimo("20/09/2023");
        emprestimo1.setUsuario(Sara);
        Emprestimo atual = DAO.getEmprestimoDAO().update(emprestimo1);
        assertEquals(emprestimo1,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getEmprestimoDAO().read().size();
        assertEquals(2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Emprestimo atual = DAO.getEmprestimoDAO().findbyID(0);
        assertEquals(emprestimo1,atual,"Esse teste deveria passar!");
    }
    @Test
    void lerUsuario() throws Exception{

    }
    @Test
    void lerUsuarioAtivo(){

    }

}
