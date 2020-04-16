/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import entities.Entrepot;
import entities.Produit;
import entities.Stockage;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.EntrepotService;

import service.ProduitService;
import service.StockageService;

/**
 * FXML Controller class
 *
 * @author tayssir
 */
public class ReadStockageController implements Initializable {

    public Stockage s;
    @FXML
    private TableColumn<Stockage, String> columnid;
    @FXML
    private TableColumn<Stockage, String> columnentrepot;
    @FXML
    private TableColumn<Stockage, String> columnproduit;
    @FXML
    private TableColumn<Stockage, String> columnquantite;
    @FXML
    private TableColumn<Stockage, String> columndate;
    @FXML
    private ComboBox<String> comboentrepot;
    @FXML
    private ComboBox<String> comboproduit;
    @FXML
    private TextField quantites;
    @FXML
    private TextField dates;
    @FXML
    private Button ajouter;
    @FXML
    private Button refresh;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Stockage> tabstock;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         StockageService ps =new StockageService();
        List<Stockage> list;  
        try {
            list = ps.readAll();
       
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnentrepot.setCellValueFactory(new PropertyValueFactory<>("nomEntrepot"));
        columnproduit.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
        columnquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        columndate.setCellValueFactory(new PropertyValueFactory<>("datedestockage"));
        
        tabstock.setItems(null);
        tabstock.setItems((FXCollections.observableArrayList(list))); 
         } catch (SQLException ex) {
            Logger.getLogger(InterfacereadController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
   
    }    

    @FXML
    private void importentrepot(ActionEvent event) {
        
    }

    @FXML
    private void importproduit(ActionEvent event) {
    }

    @FXML
    private void ajouterstock(ActionEvent event) throws IOException {
           Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/AjoutStockage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Refresherstock(ActionEvent event) throws SQLException {
        StockageService ps =new StockageService();
        List<Stockage> list; 
        list = ps.readAll();
        tabstock.setItems((FXCollections.observableArrayList(list))); 
    }

    @FXML
    private void modifierstock(ActionEvent event) throws SQLException {
        String nom = comboentrepot.getValue();
        String desc = comboproduit.getValue();
        
        EntrepotService a = new EntrepotService();
        Entrepot entrepot = a.getEntrepotByNom(nom);
        int iden =a.getEntrepotIdByNom(nom);
        
        ProduitService b = new ProduitService();
        Produit produit = b.getProduitBydesc(desc);
        int idpr = b.getProduitIdBydesc(desc);
        
        int quantite = Integer.parseInt(quantites.getText());
        String datedestockage = dates.getText();
        
        Stockage s = new Stockage(entrepot,produit,quantite,datedestockage);
        StockageService ss = new StockageService();
        ss.update(s, iden, idpr);
        
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("Modification réussite");
        alert.showAndWait();
       
    }

    @FXML
    private void fill(){
        s = tabstock.getSelectionModel().getSelectedItem();
        comboentrepot.setValue(s.getNomEntrepot());
        comboproduit.setValue(s.getNomProduit());
        quantites.setText(Integer.toString((int) s.getQuantite()));
        dates.setText(s.getDatedestockage());
    }
    @FXML
    private void supprimerstock(ActionEvent event) throws SQLException {
         int id = tabstock.getSelectionModel().getSelectedItem().getId();
         
          StockageService se = new StockageService();
          se.delete(id);
         System.out.println("hahaha "+id);
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("suppression réussite");
        alert.showAndWait();
    }
    
}
