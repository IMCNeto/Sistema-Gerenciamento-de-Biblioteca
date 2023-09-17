package model;

public class Usuario {
    private String nome;
    private int telefone;
    private String endereco;
    private int num_id;
    private int situacao; // 0 = Livre; 1 = Bloqueado;
    private int multa;


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


    //verifica se o usuário está bloqueado
    public String getSituacao() {
        if (situacao == 0){
            return "Liberado";
        }
        else {
            return "Bloqueado";
        }

    }


    //retorna multa do usuário(Dias)
    public int getMulta() {
        return multa;
    }


    //define multa do usuário
    public void setMulta(int multa) {
        this.multa = multa;
    }


    //bloqueia usuário
    public void bloquearUsuario(){
        this.situacao = 1;

    }


    //desbloqueia usuário
    public void liberarUsuario(){
        this.situacao = 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", num_id=" + num_id +
                ", situacao=" + situacao +
                ", multa=" + multa +
                '}';
    }
}
