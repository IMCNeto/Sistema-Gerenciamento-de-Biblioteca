package model;

public class Usuario {
    private String nome;
    private int telefone;
    private String endereco;
    private int num_id;
    private String situacao;


    public Usuario(String nome, int telefone, String endereco, int num_id) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.num_id = num_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNum_id() {
        return num_id;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
