/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import entities.Rendezvous;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import services.RendezvousService;
import services.ServiceFOSUser;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLRendouController implements Initializable {

    @FXML
    private AnchorPane readfournisseurpane;
    @FXML
    private TableView<Rendezvous> tableReclamation;
    @FXML
    private TableColumn<Rendezvous, String> user;
    @FXML
    private TableColumn<Rendezvous, String> descri;
    @FXML
    private TableColumn<Rendezvous, Date> date;
    @FXML
    private TableColumn<Rendezvous, Date> dateenvo;
    @FXML
    private TextField recherche;
    @FXML
    private CheckBox triers;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXDatePicker datefix;
    @FXML
    private Button dfxa;
    
Rendezvous C;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          delete.setVisible(false);
        dfxa.setVisible(false);
        datefix.setVisible(false);
     String title = "Hello Mr, "+ServiceFOSUser.getCurrentUser().getUsername();
        RendezvousService kkk=new RendezvousService();
    String message = "You Have "+kkk.counte()+" Rendez Vous";

    TrayNotification tray = new TrayNotification(title, message,NotificationType.INFORMATION);
    tray.showAndDismiss(Duration.seconds(6));
 
     buildTableviewAssociationData();
        tableReclamation.setRowFactory( (TableView<Rendezvous> tv) -> {
    TableRow<Rendezvous> row = new TableRow<>();
     
    row.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
            
              C = row.getItem();
           
             delete.setVisible(true);
        dfxa.setVisible(true);
        datefix.setVisible(true);
         
                    
        }
        
        
    });
    return row ;
});   
     
    }    

    @FXML
    private void hello(MouseEvent event) {
    }


    @FXML
    private void trier(ActionEvent event) {
        if (triers.isSelected()) {
      
            buildTableviewAssociationData1();
        } else {
       
            buildTableviewAssociationData();
        }
    }

    @FXML
    private void annule(ActionEvent event) {
           RendezvousService rc=new RendezvousService();
        rc.annuler(C);
        buildTableviewAssociationData();
     String title = "Rendez Vous :  "+C.getId();
     RendezvousService kkk=new RendezvousService();
    String message = "le Rendez vous a ete annuler avec Success";
delete.setVisible(false);
    TrayNotification tray = new TrayNotification(title, message,NotificationType.ERROR);
    tray.showAndDismiss(Duration.seconds(6));
    }

    @FXML
    private void Fixer(ActionEvent event) {
        RendezvousService Xs=new RendezvousService();
        if(datefix.getValue() ==null){
            Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Date Problem!!");
alert.setHeaderText(null);
alert.setContentText("Vous devez saisie une date valid (tu peux utiliser l agenda pour mettre une date !)");

alert.showAndWait();
        }else{
    LocalDate localDate = datefix.getValue();
    Date daterrr = Date.valueOf(localDate); 
            Xs.fixez(C, daterrr);
            buildTableviewAssociationData();
    }
    }
  
     
   public void buildTableviewRecherche() {

        if (recherche.getText().equals("")) {
            buildTableviewAssociationData();
           
        } else {
            RendezvousService sc = new RendezvousService();

            ObservableList<Rendezvous> data = sc.listerRecherche(recherche.getText());
 
            tableReclamation.setItems(data);

        }

       
    }
    
    

   
 

 
    
    
   
            private void buildTableviewAssociationData1() {

        user.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));
        descri.setCellValueFactory(new PropertyValueFactory<>("desrition"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateenvo.setCellValueFactory(new PropertyValueFactory<>("dateenvoi"));
       

      
   
       RendezvousService evs=new RendezvousService();
       
       ObservableList<Rendezvous> x=evs.FindAll();
       //today
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       java.util.Date today = new java.util.Date();
       //sql
        java.sql.Date  sqlDate= new java.sql.Date(today.getTime());
       //2days later
        Calendar c=Calendar.getInstance();
  c.setTime(sqlDate);
  c.add(Calendar.DATE,2);
 //filtrage
x = x.stream().filter((xzzz)->(xzzz.getDate()).compareTo(c.getTime())>0).collect(Collectors.toCollection(FXCollections::observableArrayList));
    
                
        tableReclamation.setItems(x);

    }
        
        
        private void buildTableviewAssociationData() {

        user.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));
        descri.setCellValueFactory(new PropertyValueFactory<>("desrition"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateenvo.setCellValueFactory(new PropertyValueFactory<>("dateenvoi"));
       

      
        
       RendezvousService evs=new RendezvousService();
       
       ObservableList<Rendezvous> x=evs.FindAll();
      
        tableReclamation.setItems(x);

    }
        
    @FXML
    void Rch(KeyEvent event) {
buildTableviewRecherche();
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

