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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EntrepotService;
import service.ProduitService;
import service.StockageService;

/**
 * FXML Controller class
 *
 * @author tayssir
 */
public class AjoutStockageController implements Initializable {

    @FXML
    private ComboBox<String> comboentre;
    @FXML
    private Button ajouter;
    @FXML
    private ComboBox<String> comboprod;
    @FXML
    private TextField quantitep;
    @FXML
    private TextField datep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      EntrepotService f =new EntrepotService();
        List<Entrepot> list;  
        ProduitService e = new ProduitService();
        List<Produit> liste;
        try {
            list = f.readAll();
           liste = e.readAll();
             for(int i=0; i<list.size(); i++){
                 comboentre.getItems().add(list.get(i).getNomcourtlieu());
               
            }
         for(int i=0; i<liste.size(); i++){
                 comboprod.getItems().add(liste.get(i).getDescription());
               
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadStockageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void importentre(ActionEvent event) {
      
    }

    @FXML
    private void importprod(ActionEvent event) {
    }

    @FXML
    private void Ajouterstock(ActionEvent event) throws SQLException, IOException {
        String entre = comboentre.getSelectionModel().getSelectedItem().toString();
        String prod = comboprod.getSelectionModel().getSelectedItem().toString();
        EntrepotService f =new EntrepotService();
        Entrepot entrepot = f.getEntrepotByNom(entre);
        ProduitService e = new ProduitService();
         
        Produit produit = e.getProduitBydesc(prod); 
        int quantite = Integer.parseInt(quantitep.getText());
        String datedestockage = datep.getText();
        Stockage s = new Stockage(entrepot,produit,quantite,datedestockage);
        StockageService ss = new StockageService();
        ss.ajouter(s);
         Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("félicitations");
        alert.setHeaderText("Insertion de stockage réussite");
        alert.showAndWait();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Readproduit.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
