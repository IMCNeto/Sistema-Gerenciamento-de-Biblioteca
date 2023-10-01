package test.dao;

import main.dao.DAO;
import main.model.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LivroDAOTest {
    Livro livro1;
    Livro livro2;
    Livro livro3;
    Livro livro4;

    Livro livro5;

    @BeforeEach
    void setUp() throws Exception {
        livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2002));
        livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJA20","Ação",2000));
        livro3 = DAO.getLivroDAO().create(new Livro("cangaço","Teteu","C","CTC20","Comédia",2000));
        livro4 = DAO.getLivroDAO().create(new Livro("Enrolados","Abreu","D","DAR20","Romance",2000));
        livro5 = DAO.getLivroDAO().create(new Livro("Enrolados","Abreu","D","DAR20","Romance",2000));
    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getLivroDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
        Livro atual = DAO.getLivroDAO().create(new Livro("Capitães de areia","Jorge Amado","D","DJC20","Conto",2001));
        Livro esperado = DAO.getLivroDAO().readISBN("DJC20");

        assertEquals(esperado,atual,"Esse teste deveria passar!");
        assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getLivroDAO().delete(livro4);
        int atual = DAO.getLivroDAO().read().size();
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getLivroDAO().deleteMany();
        int atual = DAO.getLivroDAO().read().size();
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        livro2.setEditora("Z");
        livro2.setAno(2023);
        livro2.setAutor("Camarguimho");
        livro2.setISBN("ZCC23");
        Livro atual = DAO.getLivroDAO().update(livro2);
        assertEquals(livro2,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getLivroDAO().read().size();
        assertEquals(5,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerISBN() throws Exception{
        Livro atual = DAO.getLivroDAO().readISBN("CTC20");
        assertEquals(livro3,atual,"Esse teste deveria passar!");
    }
    @Test
    void lerTitulo() throws Exception{
        Livro atual = DAO.getLivroDAO().readTitulo("cangaço");
        assertEquals(livro3,atual,"Esse teste deveria passar!");
    }
    @Test
    void lerAutor() throws Exception{
        Livro atual = DAO.getLivroDAO().readAutor("Abreu");
        assertEquals(livro4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerCategoria() throws Exception{
        Livro atual = DAO.getLivroDAO().readCategoria("Romance");
        assertEquals(livro1,atual,"Esse teste deveria passar!");
    }

}
