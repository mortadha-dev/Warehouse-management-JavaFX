/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entites.Employe;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.EmployeServices;

/**
 *
 * @author HP
 */
public class FXMLAjoutEmployesController {
    
    @FXML
    public TextField noma;
    @FXML
    public TextField prenoma;
    @FXML
    public TextField numtela;
    @FXML
    public TextField cina;
    @FXML
    public TextField emaila;
    
    
    @FXML
    TableColumn columnnom;
    @FXML
    TableColumn columnprenom;
     @FXML
    TableColumn columntel ;
    @FXML
    TableColumn columemail ;
    @FXML
    TableColumn columcin;
    
     @FXML
    TableView<Employe>  tableemploye ;
    
    @FXML 
    public Button ajouteremploye ; 
    
    @FXML 
    public Button b ; 
    @FXML 
    public Button back ;
    
     @FXML
    public ProgressIndicator  ALLO ;
     
     
     @FXML
    private void btnBackToMenu(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionEmploye.fxml"));
            Parent root = loader.load();
            back.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLGestionEmployeController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    @FXML
    public void ajouteremploye(ActionEvent event) throws SQLException{
        
         if(!noma.getText().equals("")){
        if(!prenoma.getText().equals("")){
        if(!numtela.getText().equals("")){ 
        if(numtela.getText().length() <= 8 && numtela.getText().length() >= 8 ){ 
        if(cina.getText().length() <= 8 && cina.getText().length() >= 8 ){ 
    
        String nom = noma.getText();
        String prenom = prenoma.getText();
        String numtel = numtela.getText();
        String cin = cina.getText();
        String email = emaila.getText();
        EmployeServices es = new EmployeServices();
        Employe e = new Employe(nom,prenom,numtel,cin,email);
        ALLO.setVisible(true);
        es.ajouteremploye(e);
        //alert de succés
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ajout des employés");
        alert.setHeaderText("l'employe est bien ajouté");
        alert.setContentText("ok!!");
        alert.showAndWait();
       }
        else{
                   Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText(" Le numéro carte identité doit contenir 8 chiffres ");
                   alertError.showAndWait();
                }
    }
           else{
          
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText(" Le numéro de téléphone doit contenir 8 chiffres ");
                  alertError.showAndWait();

               }
        
        } else{
           
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("Le numéro de télephone ne doit pas etre null ");
                  alertError.showAndWait();
               }
         }else{
                   Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText(" Le prenom ne doit pas etre null ");
                   alertError.showAndWait();
        }
        
        
        }else{
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText("Le nom ne doit pas etre null ");
                   alertError.showAndWait();
        }
         
    }
//     @FXML
//    private void afficheremploye(ActionEvent event) throws SQLException {
//        EmployeServices f =new EmployeServices();
//        List<Employe> list = f.afficherAll();  
//        columnnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        columnprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
//        columntel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
//        columcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
//        columemail.setCellValueFactory(new PropertyValueFactory<>("email"));
//        
////        columndate.setCellValueFactory(new PropertyValueFactory<>("date"));
////        columnetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
////        columnnomfournisseur.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));    
//        tableemploye.setItems(null);
//        tableemploye.setItems((FXCollections.observableArrayList(list))); 
//    }
            
    
}
