/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ProduitService;


/**
 * FXML Controller class
 *
 * @author baz info
 */
public class AjoutproduitController implements Initializable {

    @FXML
    private TextField descriptionp;
    @FXML
    private TextField libellep;
    @FXML
    private TextField quantitep;
    @FXML
    private TextField quantiteminp;
    @FXML
    private Button Ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void Ajout(ActionEvent event) throws IOException, SQLException {
     
        if (!descriptionp.getText().equals("")){
        if (!libellep.getText().equals("")){
        if (!quantitep.getText().equals("")){
        if (!quantiteminp.getText().equals("")){
            
        
        String description = descriptionp.getText();
        String libelle = libellep.getText();
        int quantite = Integer.parseInt(quantitep.getText());
        int quantitemin = Integer.parseInt(quantiteminp.getText());
        
        
        Produit p = new Produit(description, libelle, quantite, quantitemin);
        ProduitService h = new ProduitService();
        h.ajouter(p);
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("Insertion de produit réussite");
        alert.showAndWait();
           // FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Interfaceread.fxml"));
          //   AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Interfaceread.fxml"));
            // rootpane.getChildren().setAll(pane);
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/views/Readproduit.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                       stage.show();
                   
//                    
           // rootpane.getChildren().setAll(pane);
          
        
        
    }
        else{
             Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la quantite minimum du produit");
        alert.showAndWait();
        }
        
        }else{
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la quantite du produit");
        alert.showAndWait();
        }
        }else{
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la libelle du produit");
        alert.showAndWait();
        
        }
        }else{
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la description du produit");
        alert.showAndWait();
        }}
}
   
