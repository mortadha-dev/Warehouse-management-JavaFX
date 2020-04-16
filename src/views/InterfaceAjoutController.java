/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Entrepot;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.EntrepotService;

/**
 * FXML Controller class
 *
 * @author baz info
 */
public class InterfaceAjoutController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField desc;
    @FXML
    private TextField codepostalet;
    @FXML
    private TextField adresst;
    @FXML
    private TextField villet;
    @FXML
    private TextField payst;
    @FXML
    private TextField stock;
    @FXML
    private Button ajouter;
    @FXML
    public AnchorPane rootpane;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajout(ActionEvent event) throws SQLException, IOException  {
         if (!nom.getText().equals("")){
        if (!desc.getText().equals("")){
        if (!adresst.getText().equals("")){
        if (!codepostalet.getText().equals("")){
            if (!villet.getText().equals("")){
               if (!payst.getText().equals("")){
                   if (!stock.getText().equals("")){
                       
                  
                
            
         String nomcourtlieu = nom.getText();
        String description = desc.getText();
        String adress = adresst.getText();
        String codepostale = codepostalet.getText();
        String ville = villet.getText();
        String pays = payst.getText();
        int stockphysique = Integer.parseInt(stock.getText());
        
        Entrepot e = new Entrepot(nomcourtlieu, description, adress, codepostale, ville, pays, stockphysique);
        EntrepotService h = new EntrepotService();
        h.ajouter(e);
        Alert alert =new Alert(AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("Insertion réussite");
        alert.showAndWait();
            // FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Interfaceread.fxml"));
             AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Interfaceread.fxml"));
             rootpane.getChildren().setAll(pane);
//                    Stage stage = new Stage();
//                    Parent root = FXMLLoader.load(getClass().getResource("/view/Interfaceread.fxml"));
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
//                    
           // rootpane.getChildren().setAll(pane);
         
        } else{
             Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la description du produit");
        alert.showAndWait();
        }
        }
        else{
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la libelle du produit");
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
        alert.setHeaderText("veuillez saisir la quantite minimum du produit");
        alert.showAndWait();
}
        } else{
              Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("veuillez saisir la quantite minimum du produit");
        alert.showAndWait();
        }}}
               }}