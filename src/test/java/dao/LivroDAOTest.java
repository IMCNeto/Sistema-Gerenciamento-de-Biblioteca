package dao;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Emprestimo;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Reserva;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Classe responsável por realizar os testes dos métodos da classe LivroDAO
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class LivroDAOTest {
    Livro livro1;
    Livro livro2;
    Livro livro3;
    Livro livro4;
    Livro livro5;

    /**
     * Método executado antes de cada teste para preenchimento dos dados para realizar os testes;
     *
     */
    @BeforeEach
    void setUp() throws Exception {


        livro1 = DAO.getLivroDAO().create(new Livro("O cortiço","Aluísio","A","AAR20","Romance",2002));
        livro2 = DAO.getLivroDAO().create(new Livro("O beijo","Joaozinho","B","BJA20","Ação",2000));
        livro3 = DAO.getLivroDAO().create(new Livro("cangaço","Teteu","C","CTC20","Comédia",2000));
        livro4 = DAO.getLivroDAO().create(new Livro("Enrolados","Abreu","D","DAR20","Romance",2000));
        livro5 = DAO.getLivroDAO().create(new Livro("Enrolados","Abreu","D","DAR20","Romance",2000));
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
     * Caso de teste que verifica se está funcionando a implementação de um novo livro no armazenamento de dados
     * através do DAO;
     *
     */
    @Test
    void criar() throws Exception {
        Livro atual = DAO.getLivroDAO().create(new Livro("Capitães de areia","Jorge Amado","D","DJC20","Conto",2001));
        List<Livro> esperado = DAO.getLivroDAO().readByAutor("Jorge Amado");

        /*
        Verificando se a lista esperada não está vazia, após criar um objeto no DAO
         */
        assert !esperado.isEmpty();

    }

    /**
     * Caso de teste que verifica se ao tentar deletar um livro do DAO, ele deleta;
     * Inicialmente a lista contém 5 livros, utilizamos o método de DELETE e verificamos se a lista diminuiu;
     */
    @Test
    void deletarObj() throws Exception {
        DAO.getLivroDAO().delete(livro4);
        int atual = DAO.getLivroDAO().read().size();

        /*
        Excluindo um objeto da lista que tinha tamanho 5, a lista deve ser 4;
         */
        assertEquals(4,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se todos os dados sobre empréstimos são apagados se utilizar o método de deletar tudo;
     *
     */
    @Test
    void deletarTudo() throws Exception{
        DAO.getLivroDAO().deleteMany();
        int atual = DAO.getLivroDAO().read().size();

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
        livro2.setEditora("Z");
        livro2.setAno(2023);
        livro2.setAutor("Camarguimho");
        livro2.setISBN("ZCC23");
        Livro atual = DAO.getLivroDAO().update(livro2);

        /*
        Conferindo se o objeto está sendo atualizado no DAO
         */
        assertEquals(livro2,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se a lista completa de empréstimos está sendo retornada corretamente;
     *
     */
    @Test
    void lerTodaLista() throws Exception {
        int atual = DAO.getLivroDAO().read().size();

        /*
        Como adicionamos apenas 5 livros para realizar os testes, o tamanho da lista total deve ser 5;
         */
        assertEquals(5,atual,"Esse teste deveria passar!");
    }

    /**
     * Caso de teste que verifica se quando buscamos um livro por um ISBN, a lista de livros que contém esse ISBN está sendo retornada;
     *
     */
    @Test
    void lerISBN() throws Exception{
        List<Livro> atual = DAO.getLivroDAO().readByISBN("CTC20");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro3);

        /*
        conferindo se a lista atual que recebe os dados do DAO equivale a lista esperada;
         */
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }

    /**
     * Caso de teste que verifica se quando buscamos um livro por um título, a lista de livros contendo este título está sendo retornada;
     *
     */
    @Test
    void lerTitulo() throws Exception{
        List<Livro> atual = DAO.getLivroDAO().readByTitulo("cangaço");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro3);

        /*
        conferindo se a lista atual que recebe os dados do DAO equivale a lista esperada;
         */
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }

    /**
     * Caso de teste que verifica se quando buscamos um livro por um autor a lista de livros deste autor está sendo retornada;
     *
     */
    @Test
    void lerAutor() throws Exception{
        List<Livro> atual = DAO.getLivroDAO().readByAutor("Abreu");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro4);esperado.add(livro5);

        /*
        conferindo se a lista atual que recebe os dados do DAO equivale a lista esperada;
         */
        assertArrayEquals(new List[]{atual}, new List[]{esperado},"Esse Teste deveria passar");
    }

    /**
     * Caso de teste que verifica se quando buscamos um livro por uma categoria, a lista de livros nesta categoria está sendo retornada;
     *
     */
    @Test
    void lerCategoria() throws Exception{
        List<Livro> atual =  DAO.getLivroDAO().readByCategoria("Romance");
        List<Livro> esperado = new ArrayList<Livro>();
        esperado.add(livro1);esperado.add(livro4);esperado.add(livro5);


        /*
        conferindo se a lista atual que recebe os dados do DAO equivale a lista esperada;
         */
        assertEquals(atual, esperado,"Esse teste deveria passar");
    }

    /**
     * Caso de teste que verifica se o método do DAO retorna corretamente o livro que foi mais vezes emprestado;
     *
     */
    @Test
    void readMoreUsed() throws Exception {

        /*
        Dados necessários para realização dos testes;
         */

        Usuario Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Usuario Maria = DAO.getUsuarioDAO().create(new Usuario("Maria","75982830092","R. C,12,Feira VI"));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,livro1));

        List<String> lista_ISBNPopulares = new ArrayList<>();
        lista_ISBNPopulares.add(livro1.getISBN());


        /*
        Único livro emprestado áté aqui foi o 1 logo o ISBN deve ser a lista dos mais populares deve conter o ISBN do livro 1;
         */

        assertEquals(lista_ISBNPopulares,DAO.getLivroDAO().readMoreUsed(1),"Esse teste deveria passar");

        Emprestimo emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("13/09/2023",Pedro,livro2));
        DAO.getEmprestimoDAO().findbyID(1).finalizarEmprestimo(LocalDate.of(2023,9,14));
        Emprestimo emprestimo3 = DAO.getEmprestimoDAO().create(new Emprestimo("14/09/2023",Maria,livro2));


        /*
        Agora o livro 2 passou a ser o livro que mais foi emprestado, logo o ISBN retornado deve ser o do livro 2;
         */

        lista_ISBNPopulares.clear();
        lista_ISBNPopulares.add(livro2.getISBN());
        assertEquals(lista_ISBNPopulares,DAO.getLivroDAO().readMoreUsed(1));

    }

    /**
     * Caso de teste que verifica se o DAO está retornando corretamente a quantidade de livros com empréstimos atrasados do momento;
     *
     */
    @Test
    void numBorrowed() throws Exception {
        Usuario Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,livro1));
        /*
        Nesse momento foi identificado 1 livro atrasado, referente ao empréstimo 1, logo o número retornado deve ser 1;
         */
        int numEsperado = 1;
        int numAtual = DAO.getLivroDAO().numBorrowed(LocalDate.of(2023,10,2));
        assertEquals(numAtual,numEsperado,"Esse teste deveria passar");

        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Emprestimo emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("13/09/2023",Pedro,livro2));

        /*
        Nesse momento foi identificado 2 livros atrasados, logo o número de empréstimos atrasados deve ser 2;
         */
        int newEsperado = 2;
        int newAtual = DAO.getLivroDAO().numBorrowed(LocalDate.of(2023,10,1));
        assertEquals(newAtual,newEsperado);


    }

    /**
     * Caso de teste que verifica se o DAO está retornando corretamente a quantidade de livros emprestados do momento;
     *
     */
    @Test
    void numEmp() throws Exception {
        Usuario Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,livro1));

        /*
        Nesse momento existe 1 empréstimo ativo, referente ao livro 1, logo o número esperado deve ser 1;
         */
        int numEsperado = 1;
        int numAtual = DAO.getLivroDAO().numEmp();

        assertEquals(numEsperado,numAtual);

        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Emprestimo emprestimo2 = DAO.getEmprestimoDAO().create(new Emprestimo("13/09/2023",Pedro,livro2));

        /*
        Agora existem 2 empréstimos ativos, referentes aos livros 1 e 2, logo o número esperado deve ser 2;
         */
        int newEsperado = 2;
        int newAtual = DAO.getLivroDAO().numEmp();

        assertEquals(newEsperado,newAtual);

    }

    /**
     * Caso de teste que verifica se o DAO está retornando corretamente a quantidade de livros reservados do momento;
     *
     */
    @Test
    void numReserved() throws Exception {
        /*
        Nesse momento não existem livros reservados, logo o número esperado é 0;
         */
        int numEsperado = 0;
        int numAtual = DAO.getLivroDAO().numReserved();

        assertEquals(numEsperado,numAtual);

        Usuario Tiago = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
        Emprestimo emprestimo1 = DAO.getEmprestimoDAO().create(new Emprestimo("12/09/2023",Tiago,livro1));
        Usuario Pedro = DAO.getUsuarioDAO().create(new Usuario("Pedro","75982830091","R. B,14,Feira VI"));
        Reserva reserva = DAO.getReservaDAO().create(new Reserva(Pedro,livro1));

        /*
        Agora existe 1 livro reservado, logo o número esperado é 1;
         */

        int newEsperado = 1;
        int newAtual = DAO.getLivroDAO().numReserved();

        assertEquals(newAtual,newEsperado);
    }

}
