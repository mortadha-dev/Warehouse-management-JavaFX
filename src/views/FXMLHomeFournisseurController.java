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
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author admin
 */
public class FXMLHomeFournisseurController {   
      @FXML
    AnchorPane test;
          @FXML
    AnchorPane rootPane;
    
    @FXML
    public void offres(ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLfournisseurOffre.fxml"));
    test.getChildren().setAll(pane);
        
        
        
        
    }
    @FXML
    public void commandes(ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHaha.fxml"));
    test.getChildren().setAll(pane);
              
        
    }
       @FXML
     public void deconnecter (ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
    test.getChildren().setAll(pane);
    
              
}
    
 
    
}
