package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;

import java.util.List;

public interface ReservaCRUD extends CRUD<Reserva, Exception> {
    public Reserva findReserva(Usuario usuario, Livro livro) throws Exception;

    public List<Reserva> findReservaActive() throws Exception;

    public Reserva firstReservaLivro(Livro livro) throws Exception;


}

