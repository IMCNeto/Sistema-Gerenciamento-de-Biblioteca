package main.dao;

import main.Interfaces.ReservaCRUD;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements ReservaCRUD {
    private List<Reserva> lista;

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
            obj.setId(this.getProximoID());
            this.lista.add(obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao criar nova Reserva");
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
    public Reserva update(Reserva obj) throws Exception{
        try {
            int index = this.lista.indexOf(obj);
            this.lista.set(index, obj);
            return obj;
        }
        catch (Exception e){
            throw new Exception("Erro ao Atualizar uma Reserva");
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
}
