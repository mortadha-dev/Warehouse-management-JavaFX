/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.StockageService;

/**
 * FXML Controller class
 *
 * @author tayssir
 */
public class ReadPartialStockController implements Initializable {

    @FXML
    private Pane hayhay;
    @FXML
    private TableView<Produit> tabpartialstock;
    @FXML
    private TableColumn<Produit, String> stkid;
    @FXML
    private TableColumn<Produit, String> stkdesc;
    @FXML
    private TableColumn<Produit, String> stklib;
    @FXML
    private TableColumn<Produit, String> stkq;
    @FXML
    private TableColumn<Produit, String> stkqua;
    @FXML
    private Button stocke;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StockageService ps =new StockageService();
        List<Produit> list;  
        try {
            list = ps.readpartialstocker();
       
        stkid.setCellValueFactory(new PropertyValueFactory<>("id"));
        stkdesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        stklib.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        stkq.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        stkqua.setCellValueFactory(new PropertyValueFactory<>("quantitemin"));
        tabpartialstock.setItems(null);
        tabpartialstock.setItems((FXCollections.observableArrayList(list))); 
         } catch (SQLException ex) {
            Logger.getLogger(ReadNonStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void stocker(ActionEvent event) throws IOException {
           Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Ajoutpartialstock.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    }
    
