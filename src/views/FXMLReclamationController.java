/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import entities.Reclamation;
import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import org.controlsfx.control.Notifications;
import services.ReclamationService;
import services.ServiceFOSUser;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXMLReclamationController implements Initializable {

    @FXML
    private AnchorPane readfournisseurpane;
    @FXML
    private TableView<Reclamation> tableReclamation;
   
    @FXML
    private JFXButton traiter;
 
    @FXML
    private TextField recherche;
    @FXML
    private TableColumn<Reclamation, String> user;
    @FXML
    private TableColumn<Reclamation,Date> dateee;
    @FXML
    private TableColumn<Reclamation, String> etat;
    @FXML
    private TableColumn<Reclamation, String> type;
    @FXML
    private TableColumn<Reclamation, String> description;
    @FXML
    private CheckBox triers;
Reclamation C;
    @FXML
    private JFXButton delete;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           delete.setVisible(false);
        traiter.setVisible(false);
     String title = "Hello Mr, "+ServiceFOSUser.getCurrentUser().getUsername();
     ReclamationService kkk=new ReclamationService();
    String message = "You Have "+kkk.counte()+" Reclamations";

    TrayNotification tray = new TrayNotification(title, message,NotificationType.INFORMATION);
    tray.showAndDismiss(Duration.seconds(6));
 
     buildTableviewAssociationData();
        tableReclamation.setRowFactory( (TableView<Reclamation> tv) -> {
    TableRow<Reclamation> row = new TableRow<>();
     
    row.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
            
              C = row.getItem();
              delete.setVisible(true);
           
             if(C.getTetat().equals("Non traite")){
         traiter.setVisible(true);
     }
     else{
         traiter.setVisible(false);
     }      
                    
        }
    });
    return row ;
});   
     
    }    

    @FXML
    private void hello(MouseEvent event) {
    }

  
     
   public void buildTableviewRecherche() {

        if (recherche.getText().equals(" ")) {
            buildTableviewAssociationData();
            System.out.println("null");
        } else {
            ReclamationService sc = new ReclamationService();

            ObservableList<Reclamation> data = sc.listerRecherche(recherche.getText());
   //Start filter-----------
       String[] filter = new String[] {"blue", "red","green","yellow"};
String etoiless = "*****";
       data.forEach((Reclamation p)->{
                   for (String s : filter)
{
    String dxs=p.getDescription();
  if (dxs.contains(s))
  {
dxs=dxs.replaceAll("\\b"+s+"\\b", etoiless);
    
p.setDescription(dxs);
    
  }}
       });
   
       
  //End filter-------------
            tableReclamation.setItems(data);

        }

       
    }
    
    

   
 

 
    
    
    @FXML
    void trier(ActionEvent event) {
   if (triers.isSelected()) {
      
            buildTableviewAssociationData1();
        } else {
       
            buildTableviewAssociationData();
        }

    }
        
        private void buildTableviewAssociationData() {

        user.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));
        dateee.setCellValueFactory(new PropertyValueFactory<>("date"));
        etat.setCellValueFactory(new PropertyValueFactory<>("tetat"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
      

      
   
       ReclamationService evs=new ReclamationService();
       
       ObservableList<Reclamation> x=evs.FindAll();
       //Start filter-----------
       String[] filter = new String[] {"blue", "red","green","yellow"};
String etoiless = "*****";
       x.forEach((Reclamation p)->{
                   for (String s : filter)
{
    String dxs=p.getDescription();
  if (dxs.contains(s))
  {
dxs=dxs.replaceAll("\\b"+s+"\\b", etoiless);
    
p.setDescription(dxs);
    
  }}
       });
   
       
  //End filter-------------
        tableReclamation.setItems(x);

    }
        
        private void buildTableviewAssociationData1() {
        user.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));
        dateee.setCellValueFactory(new PropertyValueFactory<>("date"));
        etat.setCellValueFactory(new PropertyValueFactory<>("tetat"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
      

      
       ReclamationService evs=new ReclamationService();
       ObservableList<Reclamation> x=evs.TriAll();
    //Start filter-----------
       String[] filter = new String[] {"blue", "red","green","yellow"};
String etoiless = "*****";
       x.forEach((Reclamation p)->{
                   for (String s : filter)
{
    String dxs=p.getDescription();
  if (dxs.contains(s))
  {
dxs=dxs.replaceAll("\\b"+s+"\\b", etoiless);
    
p.setDescription(dxs);
    
  }}
       });
   
       
  //End filter-------------
        tableReclamation.setItems(x);

    }
    @FXML
        void Rch(KeyEvent event) {
buildTableviewRecherche();
    }
//traiter reclamation
    @FXML
    private void traiter(ActionEvent event) {
        ReclamationService xx=new ReclamationService();
       
xx.traiter(C);
buildTableviewAssociationData();
traiter.setVisible(false);
mailling(C.getEmailuser());
    

        String title = "Reclamation , "+C.getId();
     ReclamationService kkk=new ReclamationService();
    String message = "la Reclamation a ete traiter avec Success";

    TrayNotification tray = new TrayNotification(title, message,NotificationType.SUCCESS);
    tray.showAndDismiss(Duration.seconds(6));
    
 
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
         public void mailling(String adr) {

        //authentication info
        final String username = "velov638@gmail.com";
        final String password = "Velo123456789.";
        String fromEmail = "test.nom2020@gmail.com";


        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }

});
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
                                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(adr)); 
            msg.setSubject("Reclamation");
            msg.setText("Votre Reclamation à été traiter  avec Succées !");
             
            Transport.send(msg);
            
        }catch (MessagingException e) {
          //  e.printStackTrace();
           Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Problem");
alert.setHeaderText("Problem");
alert.setContentText ("invalid email address!!!");
        }
        // TODO Auto-generated catch block

    }

    @FXML
    private void delete(ActionEvent event) {
        ReclamationService rc=new ReclamationService();
        rc.remove(C);
        buildTableviewAssociationData();
     String title = "Reclamation , "+C.getId();
     ReclamationService kkk=new ReclamationService();
    String message = "la Reclamation a ete supprimer avec Success";
delete.setVisible(false);
    TrayNotification tray = new TrayNotification(title, message,NotificationType.ERROR);
    tray.showAndDismiss(Duration.seconds(6));
    }
}
