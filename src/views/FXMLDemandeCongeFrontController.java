/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entites.Conge;
import entites.Employe;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import services.CongeServices;
import services.EmployeServices;

/**
 *
 * @author HP
 */
public class FXMLDemandeCongeFrontController {
    
    
    
     @FXML
    public TextField traison;
     
     @FXML
    public ProgressIndicator  ALLO ;
     
     
     @FXML
    public TextField tdd ;
     
     @FXML
    public TextField tdf ;        
     @FXML
    public Button demande ;
             
    @FXML
    public void demanderconge(ActionEvent event) throws SQLException{
        
         if(!traison.getText().equals("")){
         if(!tdd.getText().equals(tdf)  ){  
//        if(!prenoma.getText().equals("")){
//        if(!numtela.getText().equals("")){ 
//        if(numtela.getText().length() <= 8 && numtela.getText().length() >= 8 ){ 
//        if(cina.getText().length() <= 8 && cina.getText().length() >= 8 ){ 
    
        String raison = traison.getText();
        String datedebut = tdd.getText();
        String datefin = tdf.getText();
        
             CongeServices es = new CongeServices();
             Conge c = new Conge(raison,datedebut,datefin);
        ALLO.setVisible(true);
        es.ajouterconge(c);
        //alert de succés
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Demande de congé");
        alert.setHeaderText("la demande est envoyée");
        alert.setContentText("ok!!");
        alert.showAndWait();
//       }
//        else{
//                   Alert alertError = new Alert(Alert.AlertType.ERROR);
//                   alertError.setTitle("valeurs incorrectes");
//                   alertError.setHeaderText(" Le numéro carte identité doit contenir 8 chiffres ");
//                   alertError.showAndWait();
//                }
//    }
//           else{
//          
//                  Alert alertError = new Alert(Alert.AlertType.ERROR);
//                  alertError.setTitle("valeurs incorrectes");
//                  alertError.setHeaderText(" Le numéro de téléphone doit contenir 8 chiffres ");
//                  alertError.showAndWait();
//
//               }
//        
//        } else{
//           
//                  Alert alertError = new Alert(Alert.AlertType.ERROR);
//                  alertError.setTitle("valeurs incorrectes");
//                  alertError.setHeaderText("Le numéro de télephone ne doit pas etre null ");
//                  alertError.showAndWait();
               
//         }else{
//                   Alert alertError = new Alert(Alert.AlertType.ERROR);
//                   alertError.setTitle("valeurs incorrectes");
//                   alertError.setHeaderText(" La date doit respecter ce format JJ-MM-AAAA ");
//                   alertError.showAndWait();
//        }
        
        }else{
                   Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText(" La date fin doit être supérieure à la date début ");
                   alertError.showAndWait();
        }
        }else{
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText("La raison ne doit pas etre null ");
                   alertError.showAndWait();
        }
         
    }
}
