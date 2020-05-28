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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class FXMLDashboardController {
   
    @FXML
    public AnchorPane pane ;
    
    @FXML
    public Button gestionconges ;
    @FXML
    public Button gestionemployes;
    
    @FXML
    public Button espaceemployé;
    
    @FXML
    public void gestionconges(ActionEvent event) throws IOException{
        //affichage dans une interface 
        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLConge.fxml"));
//        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionConge.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }

     @FXML
    public void gestionemployes(ActionEvent event) throws IOException{
        //affichage dans une interface 
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionEmploye.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }
    
    @FXML
    public void espaceemployé(ActionEvent event) throws IOException{
        //affichage dans une interface 
        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLConge.fxml"));
//        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDemandeCongeFront.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }
    
    
    
    
    
    
    
    
}
