/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Commande;
import entities.FOSUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.CommandeService;
import services.ServiceFOSUser;

/**
 *
 * @author admin
 */
public class FXMLHahaController {
    
    @FXML
    public AnchorPane rootPane ;
 
    @FXML
    public Button accepterlacommande ;
    @FXML
    public Button Ajouterlesprix ;
    @FXML
    public Button refuserlacommande ;
    
    @FXML
    public TextField etata;
    @FXML 
    public TableView<Commande> tableUser;
    
    @FXML
    public TableColumn<Commande, String> columnlibelle;
    
    @FXML 
    public TableColumn<Commande, String> columndescription;
    
    @FXML
    public TableColumn<Commande, String> columnquantite;
     
    @FXML 
    public TableColumn<Commande, String> columnprixunitaire;
    
    @FXML
    public TableColumn<Commande, String> columnprixtotal;
    
    @FXML   
    public TableColumn<Commande, String> columndate; 
    
    @FXML
    public TableColumn<Commande, String> columnetat;
    @FXML
    public TextField prixUnitairea;
    @FXML
    public TextField prixTotala;
    @FXML
    public TextField quantita ; 
    
    @FXML
    public Label merci ;
    
    @FXML
    public ImageView bienvnue ; 

    ImageView h = new ImageView("/images/imagef.jpg");
              
    public void initialize() throws SQLException {
        merci.setText("");
        Ajouterlesprix.setDisable(true);
        accepterlacommande.setDisable(true); 
        refuserlacommande.setDisable(true);   
       
      //  abay.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIconName.DOLLAR,"45px"));
        
    }
    
     @FXML
    private void show(ActionEvent event) throws SQLException {
        CommandeService f =new CommandeService();
        List<Commande> list = f.afficherlacommandeenattente();
        columnlibelle.setCellValueFactory(new PropertyValueFactory<>("libellecommande"));
        columndescription.setCellValueFactory(new PropertyValueFactory<>("descriptioncommande"));
        columnquantite.setCellValueFactory(new PropertyValueFactory<>("quantitecommande"));
        columnprixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));
        columnprixunitaire.setCellValueFactory(new PropertyValueFactory<>("prixunitaire"));
        columndate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnetat.setCellValueFactory(new PropertyValueFactory<>("etat"));        
        tableUser.setItems(null);
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        Ajouterlesprix.setDisable(false);
      
        
    }
    
     public Commande x ;
    @FXML
    public  void getselected(){
       x = tableUser.getSelectionModel().getSelectedItem();
       quantita.setText(Integer.toString(x.getQuantitecommande()));
    }
    @FXML
    public void accepterlacommande(ActionEvent event) throws SQLException{
     
        Commande c = new Commande();
        CommandeService cs = new CommandeService();
        cs.accepterlacommande(c,tableUser.getSelectionModel().getSelectedItem().getId());
        CommandeService f =new CommandeService();
        List<Commande> list = f.afficherlacommandeenattente();
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        accepterlacommande.setDisable(true);
        refuserlacommande.setDisable(true);
        merci.setText("Merci ! ");
     
    }   
    @FXML
    public void Ajouterlesprix(ActionEvent event) throws SQLException{
        
        Commande c = new Commande();
        CommandeService cs = new CommandeService();
        int w = tableUser.getSelectionModel().getSelectedItem().getId();   
//        float prixunitaire = Float.parseFloat(prixUnitairea.getText());
//        float prixtotal = Float.parseFloat(prixTotala.getText());
        float prixunitaire = Float.parseFloat(prixUnitairea.getText());
        float quanitecommande = Float.parseFloat(quantita.getText());
        float prixtotal = prixunitaire * quanitecommande ;
        Commande  a= new Commande(prixunitaire, prixtotal);
        cs.updateprix(a,w);
        CommandeService f =new CommandeService();
        List<Commande> list = f.afficherlacommandeenattente();
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        prixUnitairea.clear();
//        prixTotala.clear();
        accepterlacommande.setDisable(false);
        refuserlacommande.setDisable(false);
        quantita.clear();
     //  Ajouterlesprix.setDisable(true);
    }
    
    @FXML
    
     public void multiplier(ActionEvent event ){

    }
      public void test(ActionEvent event ){          
          
      }
  
    
    @FXML
    public void refuserlacommande(ActionEvent event) throws SQLException{
        Commande c = new Commande();
        CommandeService cs = new CommandeService();
        cs.refuserlacommande(c,tableUser.getSelectionModel().getSelectedItem().getId());
        CommandeService f =new CommandeService();
        List<Commande> list = f.afficherlacommandeenattente();
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        accepterlacommande.setDisable(true);
        refuserlacommande.setDisable(true);
       // Ajouterlesprix.setDisable(true);
    }
    @FXML
    public TextField usernamea ;
    public TextField emaila;
    @FXML
       public void desactiver(ActionEvent event) throws SQLException{
           int user_id = tableUser.getSelectionModel().getSelectedItem().getId();                    
           FOSUser f =new FOSUser(user_id);
            ServiceFOSUser sf = new ServiceFOSUser();
           sf.desactivercompte(user_id);  
           
       }
        @FXML
     public void deconnecter (ActionEvent event) throws IOException{
              
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
    rootPane.getChildren().setAll(pane);

    
                }
     
     
 }

