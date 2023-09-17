package main.model;

public class Bibliotecario {

    private String nome;
    private int id;
    private String cargo;
    private String senha;

    public Bibliotecario(String nome, int id,  String senha) {
        this.nome = nome;
        this.id = id;
        this.cargo = "Bibliotecário";
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
