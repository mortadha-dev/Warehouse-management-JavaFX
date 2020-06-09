/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import entities.Reclamation;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ReclamationService;
import services.ServiceFOSUser;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLaddRecController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXComboBox<String> cbxtype;
    @FXML
    private TextArea description;

    ValidationChamps vd=new ValidationChamps();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxtype.getItems().addAll(
        "Reclamation Service",
        "Reclamation Produit",
        "FeedBack"
        );
        // TODO
        
    }    
  
    @FXML
    private void envoyermarec(ActionEvent event) {
        
        if(vd.isTextFieldNotEmpty(description)&&vd.isTextFieldNotEmpty(cbxtype, "vous devez selectionnner un type !")){
        Reclamation t=new Reclamation();
        ReclamationService kk=new ReclamationService();
        t.setType(cbxtype.getSelectionModel().getSelectedItem());
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       java.util.Date today = new java.util.Date();
       java.sql.Date  sqlDate= new java.sql.Date(today.getTime());
       t.setDate(sqlDate);
       t.setDescription(description.getText());
      // t.setEtat(Boolean.FALSE);
       t.setIdclient(ServiceFOSUser.getCurrentUser());
       kk.add(t);
       Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("success");
alert.setHeaderText(null);
alert.setContentText("Reclamation Envoyé");

alert.showAndWait();    
    }else{
        Alert alert = new Alert(AlertType.ERROR);
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
