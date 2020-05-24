/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Commande;
import entities.Offre;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.CommandeService;
import services.FournisseurService;
import services.OffreService;

/**
 *
 * @author admin
 */
public class FXMLAjoutOffreController {
    
     @FXML
    public DatePicker datepicker ;
    @FXML
    public Label lbldate;
    @FXML
    void selectDate(ActionEvent event){
        //lbldate.setText(datepicker.getValue().toString());
    }
    
    @FXML
    AnchorPane rootPane ;
    @FXML 
    public TextField codea;  
    
    @FXML 
    public TextField noma;
    
    @FXML 
    public TextField ancienprixa;
    
    @FXML 
    public TextField nouveauprixa;
    
    @FXML 
    public TextField delaia;
      
    
    @FXML
    public Button vider; 
    @FXML
    public ComboBox groupe;
     @FXML
    public ComboBox pro;
    @FXML
    public ProgressIndicator  ALLO ;
     
    @FXML
    public Label  mah ;
    
    public void initialize() {
    
     ALLO.setVisible(false);
     mah.setVisible(false);
     OffreService srvArtiste = new OffreService();
     pro.getItems().addAll(srvArtiste.getAllproduitssNames());
     pro.setValue("choisir le produit");       
    }
 
        @FXML   
    public void ajoutoffre (ActionEvent event) throws SQLException, IOException{
      
        if(!codea.getText().equals("")){
        if(!ancienprixa.getText().equals("")){
        if(!nouveauprixa.getText().equals("")){        
        int CodeOffre=Integer.parseInt(codea.getText());
        int AncienPrix=Integer.parseInt(ancienprixa.getText());
        int NouveauPrix=Integer.parseInt(nouveauprixa.getText());
       String delaivalidite= delaia.getText();
        OffreService os = new OffreService(); 
        int produit_id =os.getProduitIdByName(pro.getValue().toString());        
        System.out.println(produit_id);
        String NomProduit =pro.getValue().toString() ;       
        float reduction= (NouveauPrix*100)/AncienPrix ;
        System.out.println(reduction);
         //String NomProduit="";
        Offre o =new Offre(NomProduit,AncienPrix,NouveauPrix, delaivalidite,CodeOffre,reduction,produit_id);            
        ALLO.setVisible(true);
        mah.setVisible(true);
        os.ajouterOffre(o);
        
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout des offres ");
        alert.setHeaderText("L'offre est bien ajouté ");
        alert.setContentText("OK!");
        alert.showAndWait();    
        Stage stage = (Stage) codea.getScene().getWindow();
        stage.close();
            }
        else{
                   Alert alertError = new Alert(Alert.AlertType.ERROR);
                   alertError.setTitle("valeurs incorrectes");
                   alertError.setHeaderText("La quantité du commande ne doit pas etre null");
                   alertError.showAndWait();
                }
    }
           else{
          
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("La description de la commande ne doit pas etre null");
                  alertError.showAndWait();

               }
        
        } else{
           
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("valeurs incorrectes");
                  alertError.setHeaderText("La libellé de la commande ne doit pas etre null");
                  alertError.showAndWait();
               }
        
        
    }
      
    public void clear (ActionEvent event){
        codea.clear();
        
    }
    
}
