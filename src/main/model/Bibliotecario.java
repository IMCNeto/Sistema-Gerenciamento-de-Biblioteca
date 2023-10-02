package main.model;

import main.dao.DAO;


/** Classe para objetos do tipo administrador, onde serão contidos os valores e métodos para o mesmo;
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */

public class Bibliotecario {

    /**
     * Guarda nome do objeto;
     */
    private String nome;

    /**
     * ID - Atributo identificador único;
     */
    private int id;

    /**
     * Guarda o nome do cargo do objeto;
     */
    private String cargo;

    /**
     * Guarda a senha para acesso do objeto;
     */
    private String senha;


    /**
     *
     * @param nome nome do bibliotecário;
     * @param senha senha do bibliotecário;
     */
    public Bibliotecario(String nome, String senha) {
        this.nome = nome;
        this.cargo = "Bibliotecário";
        this.senha = senha;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome;
        DAO.getBibliotecarioDAO().update(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        this.id = id;
        DAO.getBibliotecarioDAO().update(this);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception {
        this.cargo = cargo;
        DAO.getBibliotecarioDAO().update(this);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        this.senha = senha;
        DAO.getBibliotecarioDAO().update(this);
    }
}
