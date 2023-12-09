package com.uefs.sigbiblioteca.Interfaces;

import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Reserva;
import com.uefs.sigbiblioteca.model.Usuario;

import java.util.List;


/**
 * Interface para implementar o ReservaDAO, herda a interface CRUD, e adiciona funcionalidades que não pertencem ao CRUD
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public interface ReservaCRUD extends CRUD<Reserva, Exception> {
    public Reserva findReserva(Usuario usuario, Livro livro) throws Exception;

    public List<Reserva> findReservaActive() throws Exception;

    public Reserva firstReservaLivro(Livro livro) throws Exception;


}

