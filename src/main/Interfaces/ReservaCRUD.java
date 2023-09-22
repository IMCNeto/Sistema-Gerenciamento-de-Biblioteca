package main.Interfaces;

import main.model.Emprestimo;
import main.model.Livro;
import main.model.Reserva;
import main.model.Usuario;

import java.util.List;

public interface ReservaCRUD extends CRUD<Reserva, Exception> {
    public Reserva create(Reserva obj);
    public List<Reserva> read();
    public Reserva findReserva(Usuario usuario, Livro livro);
    public void update(int index,boolean novoStatus) throws Exception;
    public void delete(Reserva obj) throws Exception;
    public void deleteMany();
}
