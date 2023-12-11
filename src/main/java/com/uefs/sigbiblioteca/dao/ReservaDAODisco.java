package com.uefs.sigbiblioteca.dao;

import com.uefs.sigbiblioteca.Interfaces.ReservaCRUD;
import com.uefs.sigbiblioteca.model.Administrador;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Reserva;
import com.uefs.sigbiblioteca.model.Usuario;
import com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.carregar_arquivo;
import static com.uefs.sigbiblioteca.utilities.GerenciadorDeArquivos.criar_arquivo;

public class ReservaDAODisco implements ReservaCRUD {

    File arquivo;
    private ArrayList<Reserva> lista;

    public ReservaDAODisco() {
        arquivo = criar_arquivo("reserva");
        this.lista = carregar_arquivo(arquivo);

    }

    private int getProximoID() {
        int i = lista.size();
        return i++;
    }

    @Override
    public Reserva create(Reserva obj) throws Exception {
        try {
            int index = this.getProximoID();
            this.lista.add(obj);
            obj.setId(index);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar Reserva");
        }


    }

    /**
     * Método que retorna a lista completa de Reservas;
     *
     * @return Lista de Reservas;
     */
    @Override
    public List<Reserva> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Reservas");
        }

    }

    /**
     * Método que atualiza os dados da Reserva no arraylist
     *
     * @param obj Objeto do tipo Reserva;
     * @return Objeto do tipo Reserva;
     *
     */
    @Override
    public Reserva update(Reserva obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao atualizar Reserva");
        }


    }

    /**
     * Método que deleta uma Reserva da ArrayList;
     *
     * @param obj Reserva;
     */
    @Override
    public void delete(Reserva obj) throws Exception {
        try {
            this.lista.remove(obj);
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar uma Reserva");
        }

    }

    /**
     * Método que deleta todos os dados da ArrayList;
     *
     */
    @Override
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
            GerenciadorDeArquivos.salvar_arquivo(arquivo,this.lista);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar lista de Reservas");
        }


    }

    /**
     * Método que busca lista de Reservas ativas;
     * @return Lista de reservas ativas;
     *
     * */
    @Override
    public List<Reserva> findReservaActive() throws Exception {
        try {
            List<Reserva> reservasAtivas = new ArrayList<>();
            for (Reserva x : this.lista) {
                if (x.isStatus()){
                    reservasAtivas.add(x);
                }
            }
            return reservasAtivas;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Reservas Ativas");
        }

    }

    /**
     * Método que busca reserva por um usuário e livro;
     * @param usuario Objeto do tipo Usuário;
     * @param livro Objeto do tipo Livro;
     * @return Objeto do tipo Reserva;
     *
     */
    @Override
    public Reserva findReserva(Usuario usuario, Livro livro) throws Exception {
        try {
            for(Reserva x : this.lista)
                if(x.getLivro().equals(livro) && x.getUsuario().equals(usuario))
                    return x;

        }
        catch (Exception e){
            throw new Exception("Erro ao procurar Reserva");
        }

        return null;
    }

    /**
     * Método que busca a primeira reserva de um determinado livro;
     * @param livro Objeto do tipo Livro;
     * @return Objeto do tipo Reserva;
     */
    @Override
    public Reserva firstReservaLivro(Livro livro) throws Exception {
        try{
            for (Reserva x : findReservaActive()){
                if (x.getLivro().equals(livro)){
                    return x;
                }
            }
        }
        catch (Exception e){
            throw new Exception("Erro ao procurar reserva pelo Livro");
        }

        throw new IllegalArgumentException("Reserva do livro não encontrada");

    }
}
