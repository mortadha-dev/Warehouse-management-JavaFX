/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLHomeSavController implements Initializable {

    @FXML
    private AnchorPane test;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton deconnecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void gereachat(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeAchat.fxml"));
    test.getChildren().setAll(pane);
    }
    @FXML
    public void livraison(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeLivraison.fxml"));
    test.getChildren().setAll(pane);      
    }
      
    @FXML
    public void employes(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeEmploye.fxml"));
    test.getChildren().setAll(pane);        
    }
 
    @FXML
          public void sav(ActionEvent event) throws IOException{
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadCommande.fxml"));
//    rootPane.getChildren().setAll(pane);  
//        
    }
    
              
    
    
    public void gereentropot(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfacereadEntopot.fxml"));
    test.getChildren().setAll(pane);
    }
    
    
    
    public void gereproduits(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Readproduit.fxml"));
    test.getChildren().setAll(pane);
    }
    
    private void gererstockage(ActionEvent event) throws IOException {
         
    AnchorPane pane = FXMLLoader.load(getClass().getResource("ReadStockage.fxml"));
    test.getChildren().setAll(pane);   
        
    }
    
    
    
  
    public void gerecommande(ActionEvent event) throws IOException{
        
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadCommande.fxml"));
//    test.getChildren().setAll(pane);
    }
      public void apropos(ActionEvent event) throws IOException{
            
    }
    @FXML
     public void deconnecter (ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
    test.getChildren().setAll(pane);  
        
    
}

    @FXML
    private void stock(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeStock.fxml"));
    test.getChildren().setAll(pane);    
    }

    @FXML
    private void reclamations(ActionEvent event) throws IOException {
             
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReclamation.fxml"));
    test.getChildren().setAll(pane);
    }

    @FXML
    private void Rendezvous(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLRendezVous.fxml"));
    test.getChildren().setAll(pane);
        
    }

    @FXML
    private void Stat(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("StatFXML.fxml"));
    test.getChildren().setAll(pane);
        
    }

  

}
