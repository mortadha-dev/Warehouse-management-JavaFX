/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author baz info
 */
public class SampleController implements Initializable {

    @FXML
    private Pane ha;
    @FXML
    private Button stockage;
    @FXML
    private Button Entrepot;
    @FXML
    private Button produit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void stockage(ActionEvent event) throws IOException {
         Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Interfaceread.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
    }

    @FXML
    private void Entrepot(ActionEvent event) throws IOException {
         Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Interfaceread.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
    }

    @FXML
    private void produit(ActionEvent event) throws IOException {
         Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Readproduit.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
    }
    
}
