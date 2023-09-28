package main.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Usuario {
    private String nome;
    private int telefone;
    private String endereco;
    private int num_id;
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


    //retorna multa do usuário(Dias)
    public int getMulta() {
        return this.multa;
    }

    //define multa do usuário
    public void setMulta(int multa) {
        this.multa = multa;
    }

    public int calcularMulta(LocalDate dataDevolver, LocalDate dataAtual){
        long d1 = ChronoUnit.DAYS.between(dataDevolver, dataAtual); // subtrai a diferença entre as datas
        if (d1 <= 0){
            setMulta(this.multa);
        }
        else {
            this.multa += (int)d1 * 2;

        }
        return this.multa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", num_id=" + num_id +
                ", multa=" + multa +
                '}';
    }
}
