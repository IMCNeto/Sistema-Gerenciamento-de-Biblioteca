package main.dao;

import main.Interfaces.ReservaCRUD;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements ReservaCRUD {
    private ArrayList<Reserva> lista;

    private int proximoID;

    public ReservaDAO() {
        this.lista = new ArrayList<>();
        this.proximoID = 0;
    }


    private int getProximoID() {
        return this.proximoID++;
    }
    @Override
    public Reserva create(Reserva obj) throws Exception {
        try {
            this.lista.add(obj);
            obj.setId(getProximoID());
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar Reserva");
        }


    }

    @Override
    public List<Reserva> read() throws Exception {
        try {
            return this.lista;
        }
        catch (Exception e){
            throw new Exception("Erro ao buscar lista de Reservas");
        }

    }


    @Override
    public Reserva update(Reserva obj) throws Exception {
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao atualizar Reserva");
        }


    }

    @Override
    public void delete(Reserva obj) throws Exception {
        try {
            this.lista.remove(obj);
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar uma Reserva");
        }

    }

    @Override
    public void deleteMany() throws Exception {
        try {
            this.lista.clear();
        }
        catch (Exception e){
            throw new Exception("Erro ao Deletar lista de Reservas");
        }


    }


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
