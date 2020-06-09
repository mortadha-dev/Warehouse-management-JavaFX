/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.FOSUser;
import Manager.enc;
import services.ServiceFOSUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author I.O.I
 */
public class RegistrationController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField phone;
    @FXML
    private Label erreurMessage;

    @FXML
    public void inscription(ActionEvent event) throws IOException{
        erreurMessage.setText("");
        ServiceFOSUser srvUser = new ServiceFOSUser();
        if(username.getText().length()>1 && srvUser.checkUsername(username.getText())){
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email.getText());
            if(m.matches()){
                if(email.getText().length()>1 && srvUser.checkEmail(email.getText())){
                    if(password.getText().length()>7){
                        if(phone.getText().length()==8){
                            try{
                                Integer number = Integer.parseInt(phone.getText());
                                FOSUser u = new FOSUser(0, username.getText(), username.getText(), email.getText(), phone.getText(), (byte)1, null, enc.encryptPassword(password.getText()), null, null, null, "a:0:{}");
                                srvUser.ajouterUser(u);
                                   Alert alert  =new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Inscription ");
                                     alert.setHeaderText("L'inscription est effectuée avec succés ");
                                           alert.setContentText("OK!");
                                                alert.showAndWait();    
      
                                System.out.println("Bravo !");
                            }catch(NumberFormatException e){
                                erreurMessage.setText("Téléphone doit contenir que de chiffres !");
                            }
                        }else{
                            erreurMessage.setText("Téléphone doit avoir 8 chiffres !");
                        }
                    }else{
                        erreurMessage.setText("Mot de passe doit contenir 8 carateres !");
                    }
                }else{
                    erreurMessage.setText("Adresse email déjà utiliser !");
                }
            }else{
                erreurMessage.setText("Adresse email invalid !");
            }
        }else{
            erreurMessage.setText("Invalid nom d'utilisateur !");
        }
      
        
        
        
        
        
        
    }
    @FXML
    public void back(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                Parent root = null;
                
                root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}