package test.dao;

import main.dao.DAO;
import main.model.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        List<Livro> esperado = DAO.getLivroDAO().readByAutor("Jorge Amado");
        assert !esperado.isEmpty();

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
        List<Livro> atual = DAO.getLivroDAO().readByISBN("CTC20");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro3);
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }

    @Test
    void lerTitulo() throws Exception{
        List<Livro> atual = DAO.getLivroDAO().readByTitulo("cangaço");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro3);
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }

    @Test
    void lerAutor() throws Exception{
        List<Livro> atual = DAO.getLivroDAO().readByAutor("Abreu");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro4);esperado.add(livro5);
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }



    @Test
    void lerCategoria() throws Exception{
        List<Livro> atual =  DAO.getLivroDAO().readByCategoria("Romance");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro1);esperado.add(livro4);esperado.add(livro5);
        assertArrayEquals(new List[]{atual}, new List[]{esperado});
    }

}
