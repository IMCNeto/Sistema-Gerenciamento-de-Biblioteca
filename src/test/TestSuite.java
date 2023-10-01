package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.dao.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({AdministradorDAOTest.class, BibliotecarioDAOTest.class, EmprestimoDAOTest.class, LivroDAOTest.class, ReservaDAOTest.class,UsuarioDAOTest.class })

public class TestSuite {

}
