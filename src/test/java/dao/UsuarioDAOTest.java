package dao;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe responsável por realizar os testes dos métodos da classe UsuarioDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class UsuarioDAOTest {
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
        DAO.getLivroDAO().deleteMany();
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
        DAO.getReservaDAO().deleteMany();
        DAO.getBibliotecarioDAO().deleteMany();
        DAO.getAdministradorDAO().deleteMany();
    }

    @Test
    void criar() throws Exception {
       Usuario atual = DAO.getUsuarioDAO().create(new Usuario("Rute","75982830094","R. E,8,Feira VI"));
       Usuario esperado = DAO.getUsuarioDAO().readID(4);

       /*
        Verificando se a lista esperada não está vazia e se é igual ao esperado, após criar um objeto no DAO
         */
       assertEquals(esperado,atual,"Esse teste deveria passar!");
       assertNotNull(esperado,"Esse teste deveria passar!");

    }

    @Test
    void deletarObj() throws Exception {
        DAO.getUsuarioDAO().delete(Sara);
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    @Test
    void deletarTudo() throws Exception{
        DAO.getUsuarioDAO().deleteMany();
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    @Test
    void atualizar() throws Exception {
        Tiago.setNome("Thiago");
        Tiago.setTelefone("75982830099");
        Usuario atual = DAO.getUsuarioDAO().update(Tiago);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(Tiago,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Como adicionamos apenas 4 usuários para realizar os testes, o tamanho da lista total deve ser 4;
         */
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    @Test
    void lerID() throws Exception{
        Usuario atual = DAO.getUsuarioDAO().readID(1);
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }

    @Test
    void usuariosBloqueados() throws Exception {
        Usuario Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Livro Livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2000));
        Livro Livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJR20","Romance",2000));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Sara,Livro1));
        Emprestimo emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("16/09/2023",Pedro,Livro2));

        List<Usuario> atual = DAO.getUsuarioDAO().usuariosBloqueados(LocalDate.of(2023,9,25));

        /*
        Na data passada como parâmetro, dois usuários estão bloqueados por empréstimos atrasados, Sara e Pedro, logo a lista esperada contém os dois;
         */

        List<Usuario> esperada = new ArrayList<>();
        esperada.add(Sara);esperada.add(Pedro);

        assertEquals(atual,esperada);

    }


}






