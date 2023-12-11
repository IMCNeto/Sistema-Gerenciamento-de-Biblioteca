package com.uefs.sigbiblioteca.dao;

/**
 * Classe responsável por implementar o Padrão Singleton tem como definição garantir que uma classe,
 * tenha apenas uma instância de si mesma e que forneça um ponto global de acesso a ela;
 *
 * @version 1.0;
 */

public class DAO {
    private static AdministradorDAODisco administradorDAOinstance;
    private static BibliotecarioDAODisco bibliotecarioDAOinstance;
    private static EmprestimoDAODisco emprestimoDAOinstance;
    private static LivroDAODisco livroDAOinstance;
    private static UsuarioDAODisco usuarioDAOinstance;
    private static ReservaDAODisco reservaDAOinstance;

    public static AdministradorDAODisco getAdministradorDAO() {
        if(administradorDAOinstance == null){
            //administradorDAOinstance = new AdministradorDAO();
            administradorDAOinstance = new AdministradorDAODisco();
        }
        return administradorDAOinstance;
    }

    public static BibliotecarioDAODisco getBibliotecarioDAO() {
        if(bibliotecarioDAOinstance == null){
            //bibliotecarioDAOinstance = new BibliotecarioDAO();
            bibliotecarioDAOinstance = new BibliotecarioDAODisco();
        }
        return bibliotecarioDAOinstance;
    }

    public static EmprestimoDAODisco getEmprestimoDAO() {
        if(emprestimoDAOinstance == null){
            //emprestimoDAOinstance = new EmprestimoDAO();
            emprestimoDAOinstance = new EmprestimoDAODisco();
        }
        return emprestimoDAOinstance;
    }

    public static LivroDAODisco getLivroDAO() {
        if(livroDAOinstance == null){
            //livroDAOinstance = new LivroDAO();
            livroDAOinstance = new LivroDAODisco();
        }
        return livroDAOinstance;
    }

    public static UsuarioDAODisco getUsuarioDAO() {
        if (usuarioDAOinstance == null){
            //usuarioDAOinstance = new UsuarioDAO();
            usuarioDAOinstance = new UsuarioDAODisco();
        }
        return usuarioDAOinstance;
    }

    public static ReservaDAODisco getReservaDAO() {
        if (reservaDAOinstance == null){
            //reservaDAOinstance = new ReservaDAO();
            reservaDAOinstance = new ReservaDAODisco();
        }
        return reservaDAOinstance;
    }
}
