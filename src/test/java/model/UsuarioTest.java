package model;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * Classe responsável por realizar os testes dos métodos da classe Usuário
 * @author Ilson Marinho e Jhessé Campos
 * @version 1.0
 */
public class UsuarioTest {
    LocalDate dataDevolver = LocalDate.of(2023,10,1); // 01/10/2023
    LocalDate dataAtual = LocalDate.of(2023,10,3);   // 03/10/2023
    int multa;

    Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        usuario = DAO.getUsuarioDAO().create(new Usuario("Tiago","75982830090","R. A,11,Feira VI"));
    }

    @AfterEach
    void tearDown() throws Exception {
        DAO.getUsuarioDAO().deleteMany();
    }
    @Test
    /*
     1 - 3 = -2 ; -2 não é maior ou igual á 0; logo, a multa que é o dobro de dias em atraso deve ser aplicada!
     */
    void Multa() throws Exception{
        multa = usuario.calcularMulta(dataDevolver,dataAtual);
        assertEquals(4,multa,"Esse teste deveria passar!");

    }
}
