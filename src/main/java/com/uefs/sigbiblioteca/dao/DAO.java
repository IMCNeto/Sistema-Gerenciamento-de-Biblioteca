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

    /**
     *
     * @return Instância única de AdministradorDAODisco
     */
    public static AdministradorDAODisco getAdministradorDAO() {
        if(administradorDAOinstance == null){
            //administradorDAOinstance = new AdministradorDAO();
            administradorDAOinstance = new AdministradorDAODisco();
        }
        return administradorDAOinstance;
    }

    /**
     *
     * @return Instância única de BibliotecarioDAODisco
     */
    public static BibliotecarioDAODisco getBibliotecarioDAO() {
        if(bibliotecarioDAOinstance == null){
            //bibliotecarioDAOinstance = new BibliotecarioDAO();
            bibliotecarioDAOinstance = new BibliotecarioDAODisco();
        }
        return bibliotecarioDAOinstance;
    }

    /**
     *
     * @return Instância única de EmprestimoDAODisco
     */
    public static EmprestimoDAODisco getEmprestimoDAO() {
        if(emprestimoDAOinstance == null){
            //emprestimoDAOinstance = new EmprestimoDAO();
            emprestimoDAOinstance = new EmprestimoDAODisco();
        }
        return emprestimoDAOinstance;
    }

    /**
     *
     * @return Instância única de LivroDAODisco
     */
    public static LivroDAODisco getLivroDAO() {
        if(livroDAOinstance == null){
            //livroDAOinstance = new LivroDAO();
            livroDAOinstance = new LivroDAODisco();
        }
        return livroDAOinstance;
    }

    /**
     *
     * @return Instância única de UsuarioDAODisco
     */
    public static UsuarioDAODisco getUsuarioDAO() {
        if (usuarioDAOinstance == null){
            //usuarioDAOinstance = new UsuarioDAO();
            usuarioDAOinstance = new UsuarioDAODisco();
        }
        return usuarioDAOinstance;
    }

    /**
     *
     * @return Instância única de ReservaDAODisco
     */
    public static ReservaDAODisco getReservaDAO() {
        if (reservaDAOinstance == null){
            //reservaDAOinstance = new ReservaDAO();
            reservaDAOinstance = new ReservaDAODisco();
        }
        return reservaDAOinstance;
    }
}
