package com.uefs.sigbiblioteca.controller;

import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Livro;
import com.uefs.sigbiblioteca.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;

import java.util.List;

public class UsuarioController {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAlt;

    @FXML
    private Button btnBloq;

    @FXML
    private Button btnDel;

    @FXML
    private TextField endereco;

    @FXML
    private TextField nome;

    @FXML
    private TextField num;

    @FXML
    private ColumnConstraints painelprincipal;

    @FXML
    private TextField senha;

    @FXML
    private TableView<Usuario> tabelaUsers;

    @FXML
    private Label labelerro;

    private ObservableList<Usuario> usuarioData;
    private List<Usuario> usuarios;

    @FXML
    void initialize() throws Exception {
        this.usuarios = DAO.getUsuarioDAO().read();
        this.usuarioData = FXCollections.observableArrayList(usuarios);

        TableColumn nomeCol = new TableColumn<>("nome");
        TableColumn enderecoCol = new TableColumn("Endereçoo");
        TableColumn numCol = new TableColumn("Telefone");
        TableColumn multaCol = new TableColumn<>("Multa");
        TableColumn idCol = new TableColumn<>("Id");

        nomeCol.setCellValueFactory(new PropertyValueFactory<Usuario,String>("nome"));
        enderecoCol.setCellValueFactory(new PropertyValueFactory<Usuario,String>("endereco"));
        numCol.setCellValueFactory(new PropertyValueFactory<Usuario,String>("telefone"));
        multaCol.setCellValueFactory(new PropertyValueFactory<Usuario,String>("multa"));
        idCol.setCellValueFactory(new PropertyValueFactory<Usuario,String>("id"));

        this.tabelaUsers.getColumns().addAll(nomeCol,enderecoCol,numCol,multaCol,idCol);
        this.tabelaUsers.setItems(usuarioData);
    }

    @FXML
    protected void adicionar(ActionEvent event){
        try {
            Usuario usuario = new Usuario(this.nome.getText(),this.num.getText(),this.endereco.getText(),this.senha.getText());
            DAO.getUsuarioDAO().create(usuario);
            usuarioData.add(usuario);
            clearAll();
        }
        catch (Exception e){
            this.labelerro.setText("Dados inválidos");
        }

    }

    @FXML
    protected void alterar(ActionEvent event){
        int i = this.tabelaUsers.getSelectionModel().getSelectedIndex();

        if (i >= 0){
            try {
                Usuario usuario = new Usuario(this.nome.getText(),this.num.getText(),this.endereco.getText(),this.senha.getText());
                DAO.getUsuarioDAO().updateIndex(i,usuario);
                usuarioData.set(i,usuario);
                clearAll();

            }
            catch (Exception e){
                this.labelerro.setText("Dados inválidos");
            }

        }
    }

   @FXML
   protected void excluir(ActionEvent event){
       int i = this.tabelaUsers.getSelectionModel().getSelectedIndex();

       if (i >= 0){
           try {
               DAO.getUsuarioDAO().delete(DAO.getUsuarioDAO().readID(i));
               usuarioData.remove(i);
               clearAll();
           } catch (Exception e) {
               this.labelerro.setText("Não foi possível realizar a exclusão");
           }
       }
   }

    void clearAll(){
        this.nome.clear();
        this.senha.clear();
        this.num.clear();
        this.endereco.clear();
        this.labelerro.setText("");
    }

}
