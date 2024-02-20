package com.uefs.sigbiblioteca.controller;


import com.uefs.sigbiblioteca.dao.DAO;
import com.uefs.sigbiblioteca.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.List;

public class LivroController {

    @FXML
    private TextField ano;

    @FXML
    private TextField autor;

    @FXML
    private Button btadd;

    @FXML
    private Button btalterar;

    @FXML
    private Button btdel;

    @FXML
    private TextField categoria;

    @FXML
    private TextField editora;

    @FXML
    private TextField isbn;

    @FXML
    private VBox registroLivro;

    @FXML
    private TextField titulo;

    @FXML
    private Label labelerro;

    @FXML
    private TableView<Livro> tabelaLivros;

    private ObservableList<Livro> livrosData;

    private List<Livro> livros;
    @FXML
    void initialize() throws Exception {
        this.livros = DAO.getLivroDAO().read();
        this.livrosData = FXCollections.observableArrayList(livros);

        TableColumn nomeCol = new TableColumn<>("titulo");
        TableColumn autorCol = new TableColumn("autor");
        TableColumn anoCol = new TableColumn("ano");
        TableColumn situCol = new TableColumn<>("situacao");
        TableColumn idCol = new TableColumn<>("id");

        nomeCol.setCellValueFactory(new PropertyValueFactory<Livro,String>("titulo"));
        autorCol.setCellValueFactory(new PropertyValueFactory<Livro,String>("autor"));
        anoCol.setCellValueFactory(new PropertyValueFactory<Livro,String>("ano"));
        situCol.setCellValueFactory(new PropertyValueFactory<Livro,String>("emprestimo"));
        idCol.setCellValueFactory(new PropertyValueFactory<Livro,String>("id"));

        this.tabelaLivros.getColumns().addAll(nomeCol,autorCol,anoCol,situCol,idCol);
        this.tabelaLivros.setItems(livrosData);
    }

    @FXML
    protected void adicionar(ActionEvent event){
        try {
            Livro livro = new Livro(this.titulo.getText(),this.autor.getText(),
                    this.editora.getText(),this.isbn.getText(),
                    this.categoria.getText(),Integer.parseInt(this.ano.getText()));
            DAO.getLivroDAO().create(livro);
            livrosData.add(livro);
            clearAll();
        }
        catch (Exception e){
            this.labelerro.setText("Dados inválidos");
        }


    }

    @FXML
    protected void alterar(ActionEvent event){
        int i = this.tabelaLivros.getSelectionModel().getSelectedIndex();

        if (i >= 0){
            try {
                Livro livro = new Livro(this.titulo.getText(),this.autor.getText(),
                        this.editora.getText(),this.isbn.getText(),
                        this.categoria.getText(),Integer.parseInt(this.ano.getText()));
                DAO.getLivroDAO().updateIndex(i,livro);
                livrosData.set(i,livro);
                clearAll();

            }
            catch (Exception e){
                this.labelerro.setText("Dados inválidos");
            }

        }

    }

    @FXML
    protected void excluir(ActionEvent event){
        int i = this.tabelaLivros.getSelectionModel().getSelectedIndex();
        if (i >= 0){
        try {
            DAO.getLivroDAO().delete(DAO.getLivroDAO().findbyIndex(i));
            livrosData.remove(i);
            clearAll();
        } catch (Exception e) {
            this.labelerro.setText("Não foi possível realizar a exclusão");
            }
        }
    }

    void clearAll(){
        this.ano.clear();
        this.titulo.clear();
        this.autor.clear();
        this.isbn.clear();
        this.categoria.clear();
        this.editora.clear();
        this.labelerro.setText("");
    }

}
