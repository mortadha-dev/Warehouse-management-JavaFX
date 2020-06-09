/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXMLReadController implements Initializable {

    @FXML
    private TableView<?> tableUser;
    @FXML
    private TableColumn<?, ?> columncode;
    @FXML
    private TableColumn<?, ?> columnnom;
    @FXML
    private TableColumn<?, ?> columnprenom;
    @FXML
    private TableColumn<?, ?> columntelephone;
    @FXML
    private TableColumn<?, ?> columnmail;
    @FXML
    private Button afficherfournisseur;
    @FXML
    private Button modifierfournisseur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherfournisseur(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }
    
}
