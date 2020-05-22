/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author admin    
 */
public class Main extends Application {
    public void start(Stage stage) throws Exception {   
        
    Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
  
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Debbou");
        stage.getMaxHeight();      
    }
    //Image image = new Image("negociation-fournisseurs.jpg"); 
    public static void main(String[] args) throws SQLException {
    // CommandeService f =new CommandeService();
     //List<Fournisseur> list = f.haha();
        launch(args);
 
        
    }
}
    
   
        
        
    
    

