package main.model;

import main.dao.DAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Usuario {
    private String nome;
    private int telefone;
    private String endereco;
    private int num_id;
    private int multa;


    public Usuario(String nome, int telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome;
        DAO.getUsuarioDAO().update(this);
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) throws Exception {
        this.telefone = telefone;
        DAO.getUsuarioDAO().update(this);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        this.endereco = endereco;
        DAO.getUsuarioDAO().update(this);
    }

    public int getNum_id() {
        return num_id;
    }

    public void setNum_id(int num_id) throws Exception {
        this.num_id = num_id;
        DAO.getUsuarioDAO().update(this);
    }


    //retorna multa do usuário(Dias)
    public int getMulta(){
        return this.multa;

    }

    //define multa do usuário
    public void setMulta(int multa) throws Exception {
        this.multa = multa;
        DAO.getUsuarioDAO().update(this);
    }

    public int calcularMulta(LocalDate dataDevolver, LocalDate dataAtual) throws Exception {
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
