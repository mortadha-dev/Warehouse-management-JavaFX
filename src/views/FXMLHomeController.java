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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author admin
 */
public class FXMLHomeController {
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
  
    public ImageView img ;  
    
    public ImageView cmd; 
     
    public ImageView com ; 
     @FXML
    public ImageView four ; 
    public ImageView assur ; 
     
   ImageView k = new ImageView("/images/commande-en-ligne_1_1_1_1_1_1_1_1_2_1_1_1_1_mini.png");
   ImageView v = new ImageView("/images/unnamed.jpg");  
   ImageView h = new ImageView("/images/checklist2.png");
   ImageView n = new ImageView("/images/fournisseur-delais-livraison-820x340.jpg");
   ImageView p = new ImageView("/images/assurance-entrepot-hangar.jpg");
    
    
    @FXML
    public void gereachat(ActionEvent event) throws IOException{
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeAchat.fxml"));
    rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    public void stock(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeStock.fxml"));
    rootPane.getChildren().setAll(pane);     
    }
   @FXML
    public void employes(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeEmploye.fxml"));
    rootPane.getChildren().setAll(pane);        
    }
    @FXML
       public void livraison(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeLivraison.fxml"));
    rootPane.getChildren().setAll(pane);  
        
    }
    @FXML
          public void sav(ActionEvent event) throws IOException{
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadCommande.fxml"));
//    rootPane.getChildren().setAll(pane);  
//        
    }
        
//          
//    @FXML
//    public void gerefournisseur(ActionEvent event) throws IOException{
//        
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadFournisseur.fxml"));
//    test.getChildren().setAll(pane);
////    }
//     
//    @FXML
//    public void gerecommande(ActionEvent event) throws IOException{
//        
//    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadCommande.fxml"));
//    test.getChildren().setAll(pane);
//    }
       
    public void apropos(ActionEvent event) throws IOException{
            
    }
    @FXML
     public void deconnecter (ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
    rootPane.getChildren().setAll(pane);
    
              
}
       

    
}
