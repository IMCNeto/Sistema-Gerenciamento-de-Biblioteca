package com.uefs.sigbiblioteca.model;


import java.io.Serializable;

/** Classe para objetos do tipo administrador, onde serão contidos os valores e métodos para o mesmo
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class Administrador implements Serializable {

    /**
     * Guarda o nome do Objeto
     */
    private String nome;

    /**
     * ID - Atributo identificador único
     */
    private int id;

    /**
     * Guarda o nome do cargo do objeto
     */
    private String cargo;

    /**
     * Guarda a senha para acesso do objeto
     */
    private String senha;


    /**
     *
     * @param nome nome do administrador
     * @param senha senha do administrador
     */
    public Administrador(String nome,  String senha) {
        this.nome = nome;
        this.cargo = "Administrador";
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
