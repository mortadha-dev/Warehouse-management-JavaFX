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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class FXMLUserController {
    
    @FXML
    public Button apropos ;
    @FXML
    public AnchorPane rootPane ;
    @FXML
    private ImageView assur;
    
    
    
    @FXML
    public void apropos(ActionEvent event) throws IOException{
    System.out.println("hello");
        Stage stage =new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLApropos.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
        
        
    }

    @FXML
 private void AddReclamation(MouseEvent event) throws IOException {
     
             AnchorPane pane = FXMLLoader.load(getClass().getResource("addReclamation.fxml"));
             
    rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void AddrendezVous(MouseEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("addrendezvous.fxml"));
             
    rootPane.getChildren().setAll(pane);
    }
    
    
}
