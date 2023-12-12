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

    /**
     * Método executado antes de cada teste para preenchimento dos dados para realizar os testes;
     *
     */
    @BeforeEach
    void setUp() throws Exception {
        Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Maria = DAO.getUsuarioDAO().create(new Usuario("Maria","75982830092","R. C,12,Feira VI"));
        Sara = DAO.getUsuarioDAO().create(new Usuario("Sara","75982830093","R. D,13,Feira VI"));
    }

    /**
     * Método executado após cada teste, responsável por apagar os dados do armazenamento, para que não ocorra erros
     * nos testes;
     *
     */
    @AfterEach
    void tearDown() throws Exception {
        DAO.getLivroDAO().deleteMany();
        DAO.getEmprestimoDAO().deleteMany();
        DAO.getUsuarioDAO().deleteMany();
        DAO.getReservaDAO().deleteMany();
        DAO.getBibliotecarioDAO().deleteMany();
        DAO.getAdministradorDAO().deleteMany();
    }

    /**
     * Caso de teste que verifica se está funcionando a implementação de um novo usuário no armazenamento de dados
     * através do DAO;
     *
     */
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

    /**
     * Caso de teste que verifica se ao tentar deletar um usuário do DAO, ele deleta;
     * Inicialmente a lista contém 4 usuários, utilizamos o método de DELETE e verificamos se a lista diminuiu;
     */
    @Test
    void deletarObj() throws Exception {
        DAO.getUsuarioDAO().delete(Sara);
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Excluindo um objeto da lista e verificando se o tamanho atual é igual ao esperado;
         */
        assertEquals(3,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se todos os dados sobre os usuários são apagados se utilizar o método de deletar tudo;
     *
     */
    @Test
    void deletarTudo() throws Exception{
        DAO.getUsuarioDAO().deleteMany();
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Como chamamos a função deleteMany, o tamanho da lista deve ser 0;
         */
        assertEquals(0,atual,"Esse teste deveria passar!");

    }

    /**
     * Caso de teste que verifica se a atualização de dados está sendo feita de forma correta pelo DAO;
     *
     */
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

    /**
     * Caso de teste que verifica se a lista completa de usuários está sendo retornada corretamente;
     *
     */
    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getUsuarioDAO().read().size();

        /*
        Como adicionamos apenas 4 usuários para realizar os testes, o tamanho da lista total deve ser 4;
         */
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se quando buscamos um usuário por um ID, ele está sendo retornado;
     *
     */
    @Test
    void lerID() throws Exception{
        Usuario atual = DAO.getUsuarioDAO().readID(1);
        assertEquals(Pedro,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se o DAO retorna corretamente a lista de usuários bloqueados de um
     * determinado momento;
     */
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






