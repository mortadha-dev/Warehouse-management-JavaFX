/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import entities.Offre;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.OffreService;

/**
 *
 * @author admin
 */
public class FXMLReadOffre {
    
    
    @FXML 
    public AnchorPane readoff ; 
    
        @FXML 
    public TableView<Offre> tableOffre;
    
    @FXML
    public TableColumn<Offre, String> columnNomProduit;
    
    @FXML 
    public TableColumn<Offre, String> columnAncienPrix;
    
    @FXML
    public TableColumn<Offre, String> columnNouveauPrix;
     
    @FXML 
    public TableColumn<Offre, String> columndelaivalidite;
    
    @FXML
    public TableColumn<Offre, String> columnCodeOffre;
    
    @FXML   
    public TableColumn<Offre, String> columnreduction;    
       
    @FXML 
    public TextField codea;  
    
    @FXML 
    public TextField noma;
    
    @FXML 
    public TextField ancienprixa;
    
    @FXML 
    public TextField nouveauprixa;
    
    @FXML 
    public TextField delaia;
      
        @FXML
    private void afficheroffres(ActionEvent event) throws SQLException {
          OffreService f =new OffreService();
        List<Offre> list = f.afficherOffre();  
        
        columnNomProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        
        columnAncienPrix.setCellValueFactory(new PropertyValueFactory<>("AncienPrix"));
        
        columnNouveauPrix.setCellValueFactory(new PropertyValueFactory<>("NouveauPrix"));
        
        columndelaivalidite.setCellValueFactory(new PropertyValueFactory<>("delaivalidite"));
        
        columnCodeOffre.setCellValueFactory(new PropertyValueFactory<>("CodeOffre"));      
        columnreduction.setCellValueFactory(new PropertyValueFactory<>("reduction"));        
        tableOffre.setItems(null);
        tableOffre.setItems((FXCollections.observableArrayList(list))); 
    }
    
       @FXML
    public void delete(ActionEvent event) throws SQLException{
        OffreService a =new OffreService();
        int f = (int) tableOffre.getSelectionModel().getSelectedItem().getId();
        System.out.println("le code de l'offre " +f);
        a.deleteOffre(f);         
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("suppression de l'offre ");
        alert.setHeaderText("L'offre est bien supprimé ");
        alert.setContentText("OK!");
        alert.showAndWait();
        OffreService s =new OffreService();
        List<Offre> list = s.afficherOffre();  
        tableOffre.setItems((FXCollections.observableArrayList(list))); 
      
        }
    public Offre x ;
    @FXML
    public  void getselected(){
       x = tableOffre.getSelectionModel().getSelectedItem();
       //noma.setText(x.getNomProduit());
       ancienprixa.setText(Integer.toString((int)x.getAncienPrix()));
       nouveauprixa.setText(Integer.toString((int) x.getNouveauPrix()));
       codea.setText(Integer.toString((int) x.getCodeOffre()));
       delaia.setText(x.getDelaivalidite());
     ;
    }
     @FXML
    public void update(ActionEvent event) throws SQLException{
        int w = tableOffre.getSelectionModel().getSelectedItem().getId();
        System.out.println(w);
        int CodeOffre = Integer.parseInt(codea.getText());
        int AncienPrix = Integer.parseInt(ancienprixa.getText());
        int NouveauPrix = Integer.parseInt(nouveauprixa.getText());            
        String delaivalidite = delaia.getText();    
        float reduction= (NouveauPrix*100)/AncienPrix ;
        Offre  a= new Offre(CodeOffre, AncienPrix, NouveauPrix, delaivalidite,reduction);
        OffreService cs = new OffreService();
        cs.updateOffre(a,w);
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification de l'offre ");
        alert.setHeaderText("L'offre est bien modifié ");
        alert.setContentText("OK!");
        alert.showAndWait();
        OffreService s =new OffreService();
        List<Offre> list = s.afficherOffre();  
        tableOffre.setItems((FXCollections.observableArrayList(list))); 
        codea.clear();
        ancienprixa.clear();
        nouveauprixa.clear();
        delaia.clear();        
        
    }
     public void retour(ActionEvent event) throws SQLException, IOException{ 
     
         
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeFournisseur.fxml"));
        readoff.getChildren().setAll(pane);
     
      }
       @FXML
    public void ajoutoffre(ActionEvent event) throws SQLException, IOException{
        System.out.println("hello");
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutOffre.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
  
     
      
}
