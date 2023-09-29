package main.model;

import main.dao.DAO;

public class Bibliotecario {

    private String nome;
    private int id;
    private String cargo;
    private String senha;

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
