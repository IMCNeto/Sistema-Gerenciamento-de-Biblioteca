module Biblioteca {
    opens com.uefs.sigbiblioteca.dao;
    opens com.uefs.sigbiblioteca.model;
    opens com.uefs.sigbiblioteca.Interfaces;

    exports com.uefs.sigbiblioteca.dao;
    exports com.uefs.sigbiblioteca.model;
    exports com.uefs.sigbiblioteca.Interfaces;
}