/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import entities.Rendezvous;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.RendezvousService;
import services.ServiceFOSUser;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class addrendezzController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView assur;
    @FXML
    private TextArea description;
  ValidationChamps vd=new ValidationChamps();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
   
    @FXML
    private void envoyermarec(ActionEvent event) {
        Rendezvous rdv=new Rendezvous();
        RendezvousService rdvsv=new RendezvousService();
        if(vd.isTextFieldNotEmpty(description)){
        rdv.setDesrition(description.getText());
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       java.util.Date today = new java.util.Date();
       java.sql.Date  sqlDate= new java.sql.Date(today.getTime());
       rdv.setDateenvoi(sqlDate);
             rdv.setIdcl(ServiceFOSUser.getCurrentUser());
             rdvsv.add(rdv);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("success");
alert.setHeaderText(null);
alert.setContentText("Rendez vous Envoyé");

alert.showAndWait(); 
    }
    else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error");
alert.setHeaderText(null);
alert.setContentText("vous devez saisir une description ! et vous devez selectionner un type");

alert.showAndWait();    
        }
}

    @FXML
    private void AddReclamation(ActionEvent event) throws IOException {
        
             AnchorPane pane = FXMLLoader.load(getClass().getResource("addReclamation.fxml"));
             
    rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void AddrendezVous(ActionEvent event) throws IOException {
        
           AnchorPane pane = FXMLLoader.load(getClass().getResource("addrendezvous.fxml"));
             
    rootPane.getChildren().setAll(pane);
    }
}