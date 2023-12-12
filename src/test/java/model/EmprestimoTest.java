package model;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe responsável por realizar os testes dos métodos da classe Empréstimo
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class EmprestimoTest {
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

    /**
     * Método executado antes de cada teste para preenchimento dos dados para realizar os testes;
     *
     */
    @BeforeEach
    void setUp() throws Exception {

        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2000));
        Livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJR20","Romance",2000));
        Livro3 = DAO.getLivroDAO().create(new Livro("cangaço","Teteu","C","CTC20","Comédia",2000));
        emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,Livro1));
        emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("16/09/2023",Sara,Livro2));
        emprestimo3 = DAO.getEmprestimoDAO().create(new Emprestimo("20/09/2023",Pedro,Livro3));

        /*
        finalizando empréstimo 2 para testes
         */
        DAO.getEmprestimoDAO().findbyID(1).finalizarEmprestimo(LocalDate.of(2023,9,26));

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
     * Caso de teste que verifica se a criação de um empréstimo está ocorrendo corretamente
     */
    @Test
    void criarEmprestimo() throws Exception {
        Usuario jorge = DAO.getUsuarioDAO().create(new Usuario("Jorge","75992340987","R. A,14, Feira VI"));
        Livro livroNovo = DAO.getLivroDAO().create(new Livro("Enrolados","Abreu","D","DAR20","Romance",2000));
        Emprestimo novo = DAO.getEmprestimoDAO().create(new Emprestimo("24/09/2023", jorge, livroNovo));
        Usuario userEsperado = novo.getUsuario();
        Livro livroEsperado = novo.getLivro();

        assertEquals(userEsperado ,jorge);
        assertEquals(livroEsperado,livroNovo);

        /*
        TestFAIL
        Testa se está retornando mensagem de erro ao usuário com multa tentar criar empréstimo (PROIBIDO)
         */
        assertThrows(IllegalArgumentException.class,() -> new Emprestimo("27/09/2023",Sara,Livro2));

        /*
        TestFAIL
        Testa se está retornando mensagem de erro ao tentar criar empréstimo com livro já emprestado (PROIBIDO)
         */
        assertThrows(IllegalArgumentException.class,() -> new Emprestimo("27/09/2023",Tiago,Livro3));


    }


    /**
     * Caso de teste que verifica se a renovação de um empréstimo está ocorrendo corretamente
     */
    @Test
    void renovarEmprestimo() throws Exception {
        /*
        testa se está renovando empréstimo
         */
        emprestimo1.renovarEmprestimo(LocalDate.of(2023,9,19));

        /*
        TestFAIL
        testa se empréstimo pode ser renovado antes da data de entrega(caso tente, deve lançar uma exceção)
         */
        assertThrows(IllegalArgumentException.class,() -> emprestimo1.renovarEmprestimo(LocalDate.of(2023,9,23)));

        /*
        TestFAIL
        testa se a nota data de devolução está correta
         */
        assertEquals(emprestimo1.getDataDevolver(),LocalDate.of(2023,9,26));

        /*
        TestFAIL
        testa se está tentando renovar empréstimo 2 vezes consecutivas == PROIBIDO
         */
        assertThrows(IllegalArgumentException.class,()-> emprestimo1.renovarEmprestimo(LocalDate.of(2023,9,26)));


    }


}
