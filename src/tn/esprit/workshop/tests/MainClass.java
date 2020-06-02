/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.workshop.tests;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Mahdi
 */
public class MainClass extends Application {

    public static void main(String[] args) throws IOException {
//        MyConnection cnx1 = MyConnection.getInstance();
//        MyConnection cnx2 = MyConnection.getInstance();
//        System.out.println(cnx1.hashCode() + " " + cnx2.hashCode());
        //PersonneService ps = new PersonneService();
//        Personne p = new Personne (0,"james","bond");
//        ps.ajouterPersonne(p);
       // ps.afficherAll();
    launch(args);
    
    
    
       
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/projectpi.views/Home.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        
    }
}
