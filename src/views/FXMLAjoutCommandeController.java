/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import entities.Commande;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
/**
 *
 * @author admin
 */
public class FXMLAjoutCommandeController {  
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
    public TextField libellecommandea;  
    
    @FXML 
    public TextField descriptioncommandea;
    
    @FXML 
    public TextField quantitecommandea;
    
    @FXML 
    public TextField datea;
  
    @FXML
    public ImageView cmdimg;
    @FXML
    public Button ajoutcommande;
    
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
     
      ImageView h = new ImageView("/images/commander-en-ligne-spiq.jpg");

    public void initialize() {
        ALLO.setVisible(false);
        mah.setVisible(false);
         FournisseurService srvArtiste = new FournisseurService();
         groupe.getItems().addAll(srvArtiste.getAllfournisseursNames());
         groupe.setValue("choisir le fournisseur");
         pro.getItems().addAll(srvArtiste.getAllproduitssNames());
         pro.setValue("choisir le produit");
             
    }
    
    @FXML   
    public void ajoutcommande (ActionEvent event) throws SQLException, IOException{
        if(!libellecommandea.getText().equals("")){
        if(!descriptioncommandea.getText().equals("")){
        if(!quantitecommandea.getText().equals("")){ 
        String libellecommande=libellecommandea.getText();
        String descriptioncommande=descriptioncommandea.getText();
        int quantitecommande=Integer.parseInt(quantitecommandea.getText());
        float prixunitaire= 0 ;
        int prixtotal= 0;  
        String date=datepicker.getValue().toString(); 
        String etat="";
        FournisseurService tes = new FournisseurService();
        String nomfournisseur ="haha";
                //groupe.getValue().toString() ;
        int fournisseur_id =tes.getfournisseurIdByName(groupe.getValue().toString());
        System.out.println(fournisseur_id);
        int produit_id =tes.getProduitIdByName(pro.getValue().toString());  
        System.out.println(produit_id);
        Commande c =new Commande( libellecommande, descriptioncommande,quantitecommande, prixunitaire,prixtotal,date,etat,nomfournisseur,fournisseur_id,produit_id);
        CommandeService cs = new CommandeService();   
        ALLO.setVisible(true);
        mah.setVisible(true);
        cs.ajouterCommande(c);
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout des commandes ");
        alert.setHeaderText("La commande est bien ajouté ");
        alert.setContentText("OK!");
        alert.showAndWait();    
        Stage stage = (Stage) libellecommandea.getScene().getWindow();
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
             
        
    public void retour (ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLReadCommande.fxml"));
        rootPane.getChildren().setAll(pane);
        
        
    }
  
    @FXML
    public void clear (ActionEvent event) throws SQLException{  
      libellecommandea.clear();
      descriptioncommandea.clear();
      quantitecommandea.clear();
     
   
  
    }

}
