/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entites.Conge;
import entites.Employe;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.CongeServices;
import services.EmployeServices;

/**
 *
 * @author HP
 */
public class FXMLGestionCongeController {
    @FXML
    public AnchorPane panec;
    
    
    @FXML
    public TableColumn<Conge, String>  raison;
    @FXML
    public TableColumn<Conge, String> dated;
    @FXML
    public TableColumn<Conge, String>  datef ;
    @FXML
    public  TableColumn<Conge, String>  etata ;
   
    
    @FXML
    public TableView<Conge>  tableconge ;
    
    @FXML 
    public Button affichec;
    
     @FXML 
    public Button btnVal ;
     
    @FXML 
    public Button select ;
    
    @FXML 
    public Label r ;
    
    @FXML 
    public Label dd ;
    
    @FXML 
    public Label df ;
    
    @FXML 
    public TextField testetat ;
    
    ObservableList<Conge> s = FXCollections.observableArrayList();
    
    
    
    public Conge x ;
    @FXML
    public  void getselected(){
       x = tableconge.getSelectionModel().getSelectedItem();
       r.setText(x.getRaison());
       dd.setText(x.getDatedebut());
       df.setText(x.getDatefin());
       testetat.setText(Integer.toString(x.getEtat()));
       
      
    }
    
//    @FXML
//    public void updateAccepter(ActionEvent event) throws SQLException{
//        Conge w = tableconge.getSelectionModel().getSelectedItem();
//        String raison= r.getText();
//        String datedebut=dd.getText();
//        String datefin = df.getText();
//        String etata ="Accepter" ; 
////        System.out.println(raison+datedebut+datefin);
////        Conge  a= new Conge(raison, datedebut, datefin);
////        CongeServices cs = new CongeServices();
////        cs.modifierEtatClub(a);
//        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Modification d'etat");
//        alert.setHeaderText("L'etat est bien modifié ");
//        alert.setContentText("OK!");
//        alert.showAndWait();
//        CongeServices s =new CongeServices();
//        List<Conge> list = s.afficherAllconge();  
//        tableconge.setItems((FXCollections.observableArrayList(list))); 
//       
//        
//    }
    @FXML
    private void afficherconges(ActionEvent event) throws SQLException {
       CongeServices f =new CongeServices();
       Conge c = new Conge() ;
//      while (c in Conge ) {
        List<Conge> list = f.afficherAllconge(); 
       
        raison.setCellValueFactory(new PropertyValueFactory<>("raison"));
        dated.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
        datef.setCellValueFactory(new PropertyValueFactory<>("datefin"));
        etata.setCellValueFactory(new PropertyValueFactory<>("etat"));
        System.out.println(etata);
        
//
//                                
//       if( etata.getCellData(c).equals(0) ){
//        //if(c.getEtat() ==0){
////              etata.setText("en attente");
//              etata.setCellValueFactory(new PropertyValueFactory<>("en attente"));
//               }
//      else   if( etata.getCellData(c).equals(1) ){
//       // else if(c.getEtat() ==1){
//               //etata.setText("Acceptée");
//             etata.setCellValueFactory(new PropertyValueFactory<>("Acceptée"));
//        }
//       else  if( etata.getCellData(c).equals(2) ){
////         else if(c.getEtat()==2){
////                  etata.setText("Réfusée");
//             etata.setCellValueFactory(new PropertyValueFactory<>("Réfusée"));
//        }
        
        tableconge.setItems(null);
        tableconge.setItems((FXCollections.observableArrayList(list))); 
      }
    
//    }
    
//   
   
//     @FXML
//    private void Bouton_Valider(ActionEvent event) {
//        CongeServices cs = new CongeServices();
//        Conge c = new Conge();
//        c.setRaison(r.getText());
//        c.setDatedebut(dd.getText());
////        c.setEtat(Integer.parseInt(testetat.getText()));
//        c.setDatefin(df.getText());
//        cs.modifierEtatClub(c);
//        
//        
//        
//       List<Conge> list = cs.afficherAllconge();  
//        tableconge.setItems(s);
//    }
    @FXML
    private void Bouton_Valider_Etat(ActionEvent event) {
        CongeServices cs = new CongeServices();

        Conge c = new Conge();
        c.setRaison(r.getText());
        c.setDatedebut(dd.getText());
        c.setEtat(Integer.parseInt(testetat.getText()));
        c.setDatefin(df.getText());
        cs.modifierEtatClub(c);
//        if (testetat.getText().equals(1)){
////            etata.setText("Acceptée");
//           etata.setCellValueFactory(new PropertyValueFactory<>("Acceptée"));
//        }


//////mail
//        String to = "mariemmahfoudh35@gmail.com";
//        String subject = "Demande congé ";
//        String message = "on vous informe que votre demande de congé a été acceptée ";
//        String usermail = "mariem.mahfoudh@esprit.tn";
//        String passmail = "193JFT3982";
//
//        Mailing.send(to, subject, message, usermail, passmail);

       List<Conge> list = cs.afficherAllconge();  
        tableconge.setItems(s);
        
    }
    
     
    
}
