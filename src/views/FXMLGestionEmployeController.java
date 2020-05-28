/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import entites.Employe;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.EmployeServices;

/**
 *
 * @author HP
 */
public class FXMLGestionEmployeController implements Initializable {
    
   @FXML
    public AnchorPane panea ;
//    @FXML
//    private JFXButton btn_back;
    @FXML
    public Label laffiche ;
    @FXML
    public Button a ; 
    @FXML
    public Button b ;   
    @FXML
    public TableColumn<Employe, String>  nom;
    @FXML
    public TableColumn<Employe, String> columnprenom;
     @FXML
    public TableColumn<Employe, String>  columntel ;
    @FXML
   public  TableColumn<Employe, String>  columemail ;
    @FXML
    public TableColumn<Employe, String>  columcin;
    
     @FXML
    public TableView<Employe>  tableemploye ;
  
    @FXML 
    public Button affichee ; 
    
    @FXML 
    public Button supp ;
    @FXML 
    public Button modif ;
    
    @FXML 
    public Button modif1 ;
    
    @FXML 
    public TextField nomaa;  
    
    @FXML 
    public TextField prenomaa;
    
    @FXML 
    public TextField telaa;
    
    @FXML 
    public TextField cinaa;
    
    @FXML 
    public TextField mailaa;
    
    @FXML
    private TextField R;
    
        @FXML 
    public Button recherche ;
    
     ObservableList<Employe> s = FXCollections.observableArrayList();
    
    public void initialize(URL url, ResourceBundle rb) {
        tableemploye.refresh();

        // TODO
    }
    @FXML
    public void rechercheemploye(ActionEvent event) throws IOException{
    if (!R.getText().equals("")   ) {
      if (!R.getText().equals(columnprenom) ){
          
      
     EmployeServices cl = new EmployeServices();
       String r=R.getText();
//       String n =nom.getCellValueFactory() ;
       List<Employe> list = cl.afficherAll(); 
       list=cl.afficherRechercheClub(r);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columntel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        columcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        columemail.setCellValueFactory(new PropertyValueFactory<>("email"));
   
        tableemploye.setItems(null);
        tableemploye.setItems((FXCollections.observableArrayList(list))); 
        R.clear();
      }else {
         Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("hhhhh  ");
        alert.setHeaderText("hhhhhhhh ");
        alert.setContentText("OK!");
        alert.showAndWait();
    }
      }
    
    else {
         Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("suppression de l'employé  ");
        alert.setHeaderText("L'employé est bien supprimé ");
        alert.setContentText("OK!");
        alert.showAndWait();
    }
    }
  @FXML
    public void ajout(ActionEvent event) throws IOException{
        //affichage dans une interface 
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutEmployes.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }
    
     @FXML
    public void afficheremploye(ActionEvent event) {
             EmployeServices es = new EmployeServices();
             
//             try{
                 laffiche.setText(es.afficherAll().toString());
//                 affiche.setTableView(es.afficherAll().toString());
                 
// } catch (SQLException ex) {
//            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
                 
    }
   @FXML
    private void afficheremployes(ActionEvent event) throws SQLException {
        EmployeServices f =new EmployeServices();
        List<Employe> list = f.afficherAll();  
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columntel.setCellValueFactory(new PropertyValueFactory<>("numtel"));
        columcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        columemail.setCellValueFactory(new PropertyValueFactory<>("email"));
          
        tableemploye.setItems(null);
        tableemploye.setItems((FXCollections.observableArrayList(list))); 
    }

    
    @FXML
    public void deletee(ActionEvent event) throws SQLException{
        EmployeServices a =new EmployeServices();
        String f = (String) tableemploye.getSelectionModel().getSelectedItem().getCin();
        System.out.println("la cin de l'employé " +f);
        a.delete(f);         
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("suppression de l'employé  ");
        alert.setHeaderText("L'employé est bien supprimé ");
        alert.setContentText("OK!");
        alert.showAndWait();
        EmployeServices s =new EmployeServices();
        List<Employe> list = s.afficherAll();  
        tableemploye.setItems((FXCollections.observableArrayList(list))); 
      
        }
    
    public Employe x ;
    @FXML
    public  void getselected(){
      x = tableemploye.getSelectionModel().getSelectedItem();
      nomaa.setText(x.getNom());
      prenomaa.setText(x.getPrenom());
      telaa.setText(x.getNumtel());
      cinaa.setText(x.getCin());
      mailaa.setText(x.getEmail());
      
    }
    
      @FXML
    public void update(ActionEvent event) throws SQLException{
        String w = tableemploye.getSelectionModel().getSelectedItem().getCin();
        String nom=nomaa.getText();
        String prenom = prenomaa.getText();
        String numtel = telaa.getText();
        String cin = cinaa.getText();
        String email = mailaa.getText();
   
      
        System.out.println(nom+prenom+numtel+cin+email);
        Employe  c= new Employe(nom, prenom, numtel,cin, email);
        EmployeServices cs = new EmployeServices();
        cs.updateemploye(c,w);
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification de l'employé ");
        alert.setHeaderText("L'employé est bien modifié ");
        alert.setContentText("OK!");
        alert.showAndWait();
        EmployeServices s =new EmployeServices();
        List<Employe> list = s.afficherAll();  
        tableemploye.setItems((FXCollections.observableArrayList(list))); 
        nomaa.clear();
        prenomaa.clear();
        telaa.clear();
        cinaa.clear();
        mailaa.clear();
       
    }
    
}

