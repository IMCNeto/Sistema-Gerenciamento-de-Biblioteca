package com.uefs.sigbiblioteca.controller;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField nome;

    @FXML
    private TextField senha;

    @FXML
    private ToggleGroup grupo;

    @FXML
    protected void enterac() throws Exception {
        RadioButton radio = (RadioButton) grupo.getSelectedToggle();

        if(nome.getText() != null && senha.getText() != null){

            if (radio.getText().equals("Administrador")){
                if(DAO.getAdministradorDAO().findbyname(nome.getText(),senha.getText()) != null){
                    System.out.println("login realizado");
                }
                else {
                    System.out.println("Administrador não encontrado");
                }

            } else if (radio.getText().equals("Bibliotecário")) {
                if(DAO.getBibliotecarioDAO().findbyname(nome.getText(),senha.getText()) != null){
                    System.out.println("login realizado");
                }
                else {
                    System.out.println("Bibliotecario não encontrado");
                }

            } else if (radio.getText().equals("Usuário")) {
                if(DAO.getUsuarioDAO().findbyname(nome.getText(),senha.getText()) != null){
                    System.out.println("login realizado");
                }
                else {
                    System.out.println("Usuário não encontrado");
                }

            }
        }
    }
}