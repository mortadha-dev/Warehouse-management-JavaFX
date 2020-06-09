/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Commande;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class statController implements Initializable {

    @FXML
    private AnchorPane readfournisseurpane;
    @FXML
    private PieChart statou;
    @FXML
    private AnchorPane stat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               ReclamationService xD=new ReclamationService();

        
ObservableList<Data> answer = FXCollections.observableArrayList();
   
answer.add(new PieChart.Data("Reclamation Traité:",xD.traite()));
answer.add(new PieChart.Data("Reclamation Non Traité:",xD.NonTraite()));

      
       
         statou = new PieChart(answer);
        statou.setTitle("Reclamation Traité / Non Traité");

       stat.getChildren().add(statou);
    } 
    
    @FXML
  public void retour(ActionEvent event) throws SQLException, IOException{ 
         
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeSav.fxml"));
        readfournisseurpane.getChildren().setAll(pane);
     
      }
     
     
    @FXML
         public void aprop (ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLApropos.fxml"));
        readfournisseurpane.getChildren().setAll(pane);
        
        
    }
}
