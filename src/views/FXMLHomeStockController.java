/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author admin
 */
public class FXMLHomeStockController {


      public Button gereachat;
    @FXML
    public Button deconnecter ;
    
    public Button commande;
    
    @FXML
    AnchorPane rootPane;
    
    AnchorPane
    readfournisseurpane;
    
    @FXML
    AnchorPane test;
    AnchorPane stock;
    
     @FXML
    public void stock(ActionEvent event) throws IOException{
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeStock.fxml"));
//    rootPane.getChildren().setAll(pane);     
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
    
              
    
    
      @FXML
    public void gereentropot(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfacereadEntopot.fxml"));
    test.getChildren().setAll(pane);
    }
    
    
    
      @FXML
    public void gereproduits(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Readproduit.fxml"));
    test.getChildren().setAll(pane);
    }
    
    @FXML
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


       
    
    
}

    

