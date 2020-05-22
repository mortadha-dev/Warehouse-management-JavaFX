/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import Manager.enc;
import entities.FOSUser;
import entities.Fournisseur;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import services.FournisseurService;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceFOSUser;
/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXMLAjoutFournisseurController{
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
    public Button ajoutfournisseur;
    
    @FXML
    public Button vider; 
    
    @FXML
    public ImageView pour ;
    
    @FXML
    public ComboBox comboBox;
     @FXML
    public ComboBox test;
    
    @FXML
    public ProgressIndicator  ALLO ;
     
    @FXML
    public Label  mah ;
      
    @FXML
    public Label  erreur ;
  
    ImageView h = new ImageView("/images/negociation-fournisseurs.jpg");
      
    public void initialize() throws SQLException {
  
        ObservableList<String> test = FXCollections.observableArrayList(
                "rapide",
                "normal"       );
        comboBox.setValue("rapide");
        comboBox.setItems(test);   
        // TODO        
        ALLO.setVisible(false);
        mah.setVisible(false); 
    }           
    @FXML
    public void ajoutfournisseur (ActionEvent event) throws SQLException, IOException, InterruptedException{
        
        if(telephonea.getText().length() == 8){
        if(codea.getText().length()==4){
        if(!noma.getText().equals("")){
        if(!prenoma.getText().equals("")){      
        String nom=noma.getText();
        String prenom=prenoma.getText();
        int code=Integer.parseInt(codea.getText());
        String adresse_email=maila.getText();
        int telephone=Integer.parseInt(telephonea.getText());
        String ville=villea.getText();
        String pays = paysa.getText();
        String rapidite = comboBox.getValue().toString();
        //FOSUser gg = new FOSUser();
        ServiceFOSUser sf = new ServiceFOSUser();
        //FOSUser test = new FOSUser();
        Fournisseur a =new Fournisseur(code,nom,prenom,adresse_email,telephone,ville,pays,rapidite);   
        FournisseurService p = new FournisseurService();
        ALLO.setVisible(true);
        mah.setVisible(true);
        FOSUser u = new FOSUser(a.getId(), noma.getText(), noma.getText(), maila.getText(),
        maila.getText(), (byte)1, null, enc.encryptPassword(villea.getText()), null, null, null, "a:1:{i:0;s:16:\"ROLE_FOURNISSEUR\";}");   
        sf.ajouterUser(u);
        a.setUser_id(sf.getUserByUsername(u.getUsername()).getId());
        p.ajouterFournisseur(a);
        Alert alert  =new Alert(AlertType.INFORMATION);
        alert.setTitle("Ajout des fournisseurs ");
        alert.setHeaderText("Le fournisseur est bien ajouté ");
        alert.setContentText("OK!");       
        alert.showAndWait();
        Stage stage = (Stage) noma.getScene().getWindow();
        stage.close();
            }
        else{
           
                   Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText("Le prenom du fournisseur ne doit pas etre null");
                   alertError.showAndWait();
                }
    }
           else{
          
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("Le nom du fournisseur ne doit pas etre null");
                  alertError.showAndWait();

               }
        
        } else{
           
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("Le code du fournisseur doit contenir 4 caractére");
                  alertError.showAndWait();
               }
        } else{
           
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("Le numéro du téléphone doit contenir 8 caractére");
                  alertError.showAndWait();   
               }
   
    }       
    public void vider (ActionEvent event){
        codea.clear();
        noma.clear();
        prenoma.clear();
        telephonea.clear();
        maila.clear();
        villea.clear();
        paysa.clear();
    }  
        
    }

    
    
    
    

