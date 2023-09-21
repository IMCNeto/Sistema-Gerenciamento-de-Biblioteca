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
    public Reserva create(Reserva obj) {
        obj.setId(this.getProximoID());
        this.lista.add(obj);
        return obj;
    }

    @Override
    public List<Reserva> read() {
        return this.lista;
    }

    @Override
    public Reserva findReserva(Usuario usuario, Livro livro) {
        for(Reserva x : this.lista)
            if(x.getLivro().equals(livro) && x.getUsuario().equals(usuario))
                return x;
        return null;
    }

    @Override
    public void update(int index,boolean novoStatus) {
        if(this.lista.get(index) != null){
            this.lista.get(index).setStatus(novoStatus);
        }
    }

    @Override
    public void delete(Reserva obj) {
        this.lista.remove(obj);

    }

    @Override
    public void deleteMany() {
        this.lista.clear();

    }
}
