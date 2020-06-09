/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXComboBox;
import entities.FOSUser;
import entities.Fournisseur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.FournisseurService;
import services.ServiceFOSUser;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXMLReadFournisseurController implements Initializable {
    
    @FXML
            
    public TextField filterField;
 

      Connection c= MyConnection.getInstance().getCnx();
    /**
     * Initializes the controller class.
     
     */
       @FXML
    public AnchorPane readfournisseurpane ;
    
    @FXML
    public TableView<Fournisseur> tableUser;
    
    @FXML
    public TableColumn<Fournisseur, String> columncode;
    
    @FXML
    public TableColumn<Fournisseur, String> columnnom;
    
    @FXML
    public TableColumn<Fournisseur, String> columnprenom;
    
    @FXML
    public TableColumn<Fournisseur, String> columntelephone;
    
    @FXML
    public TableColumn<Fournisseur, String> columnmail;
    
    @FXML
    public TableColumn<Fournisseur, String> columnville; 
    
    @FXML 
    public TableColumn<Fournisseur, String> columnpays;
    
    @FXML
    public TableColumn<Fournisseur, String> columnrapidite ;
    
    
    @FXML
    public TableColumn<Fournisseur, String> columncompte ;
    
    @FXML 
    public TextField codea;  
    
    @FXML 
    public TextField noma;
    
    @FXML 
    public TextField prenoma;
    
    @FXML 
    public TextField maila;
    
    @FXML 
    public TextField telephonea;
    
    @FXML 
    public TextField villea;
     
    @FXML 
    public TextField paysa;  
    
    @FXML 
    public TextField rapidetea; 
    
    @FXML
    public Button afficherfournisseur;
    
    @FXML
    public Button update;
    
    @FXML
    public JFXComboBox<String> ComboBox;
    @FXML public Button activer ; 
    @FXML public Button desactiver ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        FournisseurService srvFournisseur = new FournisseurService();
        columncode.setCellValueFactory(new PropertyValueFactory<>("code"));
        columnnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnmail.setCellValueFactory(new PropertyValueFactory<>("adresse_email"));
        columntelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        columnville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        columnpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        columnrapidite.setCellValueFactory(new PropertyValueFactory<>("rapidite"));   
        columncompte.setCellValueFactory(new PropertyValueFactory<>("etat_compte")); 
        FilteredList<Fournisseur> filteredData = new FilteredList<>(srvFournisseur.getAllFournisseurs(), p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(f -> {
                // If filter text is empty, display all challenges.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                     String lowerCaseFilter = newValue.toLowerCase();
                
                if (f.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches  name.
                } else if (f.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description.
                }  else if (f.getAdresse_email().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description.
                }
                 else if (f.getVille().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description.
                }
                 else if (f.getPays().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description.
                }
                 else if (f.getRapidite().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches description.
                }
                return false;
                });
        });
        SortedList<Fournisseur> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableUser.comparatorProperty());
        tableUser.setItems(sortedData);
        
        // TODO
    }
    
   

    @FXML
    private void afficherfournisseur(ActionEvent event) throws SQLException {
        FournisseurService f =new FournisseurService();
        List<Fournisseur> list = f.afficherFournisseur();
        columncode.setCellValueFactory(new PropertyValueFactory<>("code"));
        columnnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnmail.setCellValueFactory(new PropertyValueFactory<>("adresse_email"));
        columntelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        columnville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        columnpays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        columnrapidite.setCellValueFactory(new PropertyValueFactory<>("rapidite"));
        columncompte.setCellValueFactory(new PropertyValueFactory<>("etat_compte"));
        tableUser.setItems(null);
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        
    }
    
    
    @FXML
    public void ajouter(ActionEvent event) throws SQLException, IOException{
        System.out.println("hello");
        Stage stage =new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutFournisseur.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
 
    @FXML
    public void delete(ActionEvent event) throws SQLException{
        FournisseurService a =new FournisseurService();
        int f = tableUser.getSelectionModel().getSelectedItem().getCode();
        System.out.println("le code de fournisseur " +f);
        a.deleteFournisseur(f);        
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("suppression du fournisseur ");
        alert.setHeaderText("Le fournisseur est bien supprimé ");
        alert.setContentText("OK!");
        alert.showAndWait();
        FournisseurService h =new FournisseurService();
        List<Fournisseur> list = h.afficherFournisseur();
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        tableUser.refresh();
        }
    
    
    
    @FXML 
    public void update(ActionEvent event) throws IOException, SQLException{
        int k = tableUser.getSelectionModel().getSelectedItem().getId();
        int code=Integer.parseInt(codea.getText());
        String nom=noma.getText();
        String prenom=prenoma.getText();
        String adresse_email=maila.getText();
        int telephone=Integer.parseInt(telephonea.getText());
        String ville=villea.getText();
        String pays=paysa.getText();
        String rapidite=rapidetea.getText();
        Fournisseur h =new Fournisseur(code,nom,prenom,adresse_email,telephone,ville,pays,rapidite);
        FournisseurService p = new FournisseurService();
        p.updateFournisseur(h,k); 
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification du fournisseur ");
        alert.setHeaderText("Le fournisseur est bien modifié ");
        alert.setContentText("OK!");
        alert.showAndWait();
        tableUser.refresh();   
        FournisseurService w =new FournisseurService();
        List<Fournisseur> list = w.afficherFournisseur();
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        codea.clear();
        noma.clear();
        prenoma.clear();
        maila.clear();
        telephonea.clear();
        villea.clear();
        paysa.clear();
        rapidetea.clear();     
        
    }
    
    public Fournisseur f ;
    @FXML
    
    public  void hello() throws IOException{   
        
        f=tableUser.getSelectionModel().getSelectedItem();
        codea.setText(Integer.toString(f.getCode()));
        telephonea.setText(Integer.toString(f.getTelephone()));
        noma.setText(f.getNom());
        prenoma.setText(f.getPrenom());
        maila.setText(f.getNom());
        villea.setText(f.getVille());
        paysa.setText(f.getPays());
        rapidetea.setText(f.getRapidite());
    }
    
    
     public void retour(ActionEvent event) throws SQLException, IOException{ 
         
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeAchat.fxml"));
        readfournisseurpane.getChildren().setAll(pane);
     
      }
     
     
         public void aprop (ActionEvent event) throws IOException {
        
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLApropos.fxml"));
        readfournisseurpane.getChildren().setAll(pane);
        
        
    }
             @FXML
       public void desactiver(ActionEvent event) throws SQLException{
           int u_id = tableUser.getSelectionModel().getSelectedItem().getUser_id();
           FOSUser h =new FOSUser(u_id);  
           ServiceFOSUser sf = new ServiceFOSUser();
           sf.desactivercompte(u_id); 
           FournisseurService tt = new FournisseurService();
           Fournisseur pp = new Fournisseur();
           int id = tableUser.getSelectionModel().getSelectedItem().getId();
           tt.disablecomptefournisseur(id);
           FournisseurService f =new FournisseurService();
           List<Fournisseur> list = f.afficherFournisseur();
           tableUser.setItems((FXCollections.observableArrayList(list))); 
            System.out.println("okay  ");
                  Alert alertError = new Alert(Alert.AlertType.ERROR);
                  alertError.setTitle("Desactivation");
                  alertError.setHeaderText("le compte de ce fournisseur va etre désactivé");
                  alertError.showAndWait();

          
    }
          @FXML
       public void activer(ActionEvent event) throws SQLException{
           int u_id = tableUser.getSelectionModel().getSelectedItem().getUser_id();           
           FOSUser h =new FOSUser(u_id);
            ServiceFOSUser sf = new ServiceFOSUser();
           sf.activercompte(u_id);  
           FournisseurService tt = new FournisseurService();
           Fournisseur pp = new Fournisseur();
           int id = tableUser.getSelectionModel().getSelectedItem().getId();
           tt.enablecomptefournisseur(id);
           FournisseurService f =new FournisseurService();
           List<Fournisseur> list = f.afficherFournisseur();
           tableUser.setItems((FXCollections.observableArrayList(list))); 
           Alert alert  =new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("activation du fournisseur ");
           alert.setHeaderText("Le compte du fournisseur va etre activé ");
           alert.setContentText("OK!");
           alert.showAndWait();
           
       }
}
    
    
   

    
    
    
    
