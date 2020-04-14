/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import entities.Fournisseur;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.FournisseurService;
/**
 *
 * @author admin
 */



public class FXMLUpdateFournisseurController {
    @FXML 
    public TextField codea;  
    
    @FXML 
    public TextField noma;
    
    @FXML 
    public TextField prenoma;
    
    @FXML 
    public TextField maila;
    
    @FXML 
    public TextField telephonea;
    
    @FXML 
    public TextField villea;
    
    @FXML 
    public TextField paysa;
    
    @FXML
     public TextField rapidetea;
    
    @FXML
     public TableView<Fournisseur> tableUser;
    
    @FXML
    public Button update;
    
    @FXML
    public void update (ActionEvent event) throws SQLException, IOException{
        String nom=noma.getText();
        String prenom=prenoma.getText();
        int code=Integer.parseInt(codea.getText());
        String adresse_email=maila.getText();
        int telephone=Integer.parseInt(telephonea.getText());
        String ville=villea.getText();
        String pays=paysa.getText();
        String rapidite=rapidetea.getText();
        Fournisseur a =new Fournisseur(code,nom,prenom,adresse_email,telephone,ville,pays, rapidite);
        FournisseurService p = new FournisseurService();
        int f = tableUser.getSelectionModel().getSelectedItem().getCode();
        p.updateFournisseur(a,f);      
        
    }   
    
    
}

