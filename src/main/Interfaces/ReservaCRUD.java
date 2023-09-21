package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;

import java.util.List;

public interface ReservaCRUD extends CRUD<Reserva> {
    public Reserva create(Reserva obj);
    public List<Reserva> read();
    public Reserva findReserva(Usuario usuario, Livro livro);
    public void update(int index,boolean novoStatus);
    public void delete(Reserva obj);
    public void deleteMany();
}
