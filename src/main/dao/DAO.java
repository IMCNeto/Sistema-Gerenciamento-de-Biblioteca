package main.dao;


public class DAO {
    private static AdministradorDAO administradorDAOinstance;
    private static BibliotecarioDAO bibliotecarioDAOinstance;
    private static EmprestimoDAO emprestimoDAOinstance;
    private static LivroDAO livroDAOinstance;
    private static UsuarioDAO usuarioDAOinstance;

    public static AdministradorDAO getAdministradorDAO() {
        if(administradorDAOinstance == null){
            administradorDAOinstance = new AdministradorDAO();
        }
        return administradorDAOinstance;
    }

    public static BibliotecarioDAO getBibliotecarioDAO() {
        if(bibliotecarioDAOinstance == null){
            bibliotecarioDAOinstance = new BibliotecarioDAO();
        }
        return bibliotecarioDAOinstance;
    }

    public static EmprestimoDAO getEmprestimoDAO() {
        if(emprestimoDAOinstance == null){
            emprestimoDAOinstance = new EmprestimoDAO();
        }
        return emprestimoDAOinstance;
    }

    public static LivroDAO getLivroDAO() {
        if(livroDAOinstance == null){
            livroDAOinstance = new LivroDAO();

        }
        return livroDAOinstance;
    }

    public static UsuarioDAO getUsuarioDAO() {
        if (usuarioDAOinstance == null){
            usuarioDAOinstance = new UsuarioDAO();
        }
        return usuarioDAOinstance;
    }
}
