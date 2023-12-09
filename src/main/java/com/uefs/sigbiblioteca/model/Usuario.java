package com.uefs.sigbiblioteca.model;

import com.uefs.sigbiblioteca.dao.DAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/** Classe para objetos do tipo usuário, onde serão contidos os valores e métodos para o mesmo;
 * @author Ilson Marinho e Jhessé Campos;
 * @version 1.0;
 */

public class Usuario {

    /**
     * Guarda nome do objeto;
     */
    private String nome;

    /**
     * Guarda telefone do objeto;
     */
    private String telefone;

    /**
     * Endereço
     */
    private String endereco;

    /**
     * ID - Atributo identificador único;
     */
    private int num_id;

    /**
     * Guarda valor de multa de usuário em dias;
     */
    private int multa;


    /**
     *
     * @param nome nome do usuário;
     * @param telefone telefone do usuário;
     * @param endereco endereço que reside o usuário;
     */
    public Usuario(String nome, String telefone, String endereco) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
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

    /**
     * Método responsável por calcular a multa de determinado objeto usuário, recebe como parâmetro a data de devolução devida e o dia atual;
     * @param dataDevolver data que o livro deveria ser devolvido;
     * @param dataAtual data atual para checar se o usuário está com algum empréstimo inadimplente;
     * @return INT - inteiro equivalente à multa do usuário (dias);
     */
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
}
