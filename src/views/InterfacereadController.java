/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Entrepot;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.EntrepotService;

/**
 * FXML Controller class
 *
 * @author baz info
 */
public class InterfacereadController implements Initializable {

    @FXML
    private TableView<Entrepot> tabentrepot;
    @FXML
    private TableColumn< Entrepot,String> columnid;
    @FXML
    private TableColumn< Entrepot , String> columnnom;
    @FXML
    private TableColumn< Entrepot,String> columndesc;
    @FXML
    private TableColumn<Entrepot,String> columnadd;
    @FXML
    private TableColumn< Entrepot,String> columncode;
    @FXML
    private TableColumn<Entrepot,String> columnvill;
    @FXML
    private TableColumn<Entrepot,String> columnpay;
    @FXML
    private TableColumn< Entrepot,String> columnstock;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button modifier;
    @FXML
    private Button supp;
    @FXML
    private TextField nomt;
    @FXML
    private TextField villet;
    @FXML
    private TextField descriptiont;
    @FXML
    private TextField payst;
    @FXML
    private TextField adresst;
    @FXML
    private TextField stockt;
    @FXML
    private TextField codepost;
    @FXML
    private Button refresh;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    //public void afficher(ActionEvent event){
         EntrepotService f =new EntrepotService();
        List<Entrepot> list;  
        try {
            list = f.readAll();
       
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnnom.setCellValueFactory(new PropertyValueFactory<>("nomcourtlieu"));
        columndesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnadd.setCellValueFactory(new PropertyValueFactory<>("adress"));
        columncode.setCellValueFactory(new PropertyValueFactory<>("codepostale"));
        columnvill.setCellValueFactory(new PropertyValueFactory<>("ville"));
        columnpay.setCellValueFactory(new PropertyValueFactory<>("pays")); 
        columnstock.setCellValueFactory(new PropertyValueFactory<>("stockphysique"));
        tabentrepot.setItems(null);
        tabentrepot.setItems((FXCollections.observableArrayList(list))); 
         } catch (SQLException ex) {
            Logger.getLogger(InterfacereadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
//System.out.println(tabentrepot.getSelectionModel().getSelectedItem());
// InterfacereadController ir = new InterfacereadController();
      //   System.out.println(ir.boxed());
 
 
    }

      
   

    @FXML
    private void vbox(MouseEvent event) throws IOException {
        System.out.println(tabentrepot.getSelectionModel().getSelectedItem());
        Entrepot entrepot = tabentrepot.getSelectionModel().getSelectedItem();
        nomt.setText(tabentrepot.getSelectionModel().getSelectedItem().getNomcourtlieu());        
          descriptiont.setText(tabentrepot.getSelectionModel().getSelectedItem().getDescription());   
          adresst.setText(tabentrepot.getSelectionModel().getSelectedItem().getAdress());   
          codepost.setText(tabentrepot.getSelectionModel().getSelectedItem().getCodepostale());   
          villet.setText(tabentrepot.getSelectionModel().getSelectedItem().getVille());   
          payst.setText(tabentrepot.getSelectionModel().getSelectedItem().getPays());   
          stockt.setText(Integer.toString(tabentrepot.getSelectionModel().getSelectedItem().getStockphysique()));
        
      // InterfacereadController ir = new InterfacereadController();
        // System.out.println(ir.boxed());
       // nom=Vbox.getSelectionModel().getSelectedItem();
        
    } 
   // public Entrepot box(){
   //     InterfacereadController ir = new InterfacereadController();
   //      Entrepot en = tabentrepot.getSelectionModel().getSelectedItem();
   //    Entrepot entrepot=ir.boxed(en);
   //     return entrepot;
   // }
    
    
   // public Entrepot boxed(Entrepot e){
     // Entrepot entrepot = e;
     // return entrepot;
   // }
    @FXML
    private void modifier(ActionEvent event) throws IOException, SQLException {
        InterfacereadController ir = new InterfacereadController();
//         Entrepot entrepot = tabentrepot.getSelectionModel().getSelectedItem();
//        ir.boxed(entrepot);
          int id = tabentrepot.getSelectionModel().getSelectedItem().getId();
          String nomcourtlieu = nomt.getText();        
          String description = descriptiont.getText();   
          String adress = adresst.getText();   
          String codepostale = codepost.getText();   
          String ville = villet.getText();   
          String pays = payst.getText();   
          int stockphysique = Integer.parseInt(stockt.getText());
          Entrepot e = new Entrepot(nomcourtlieu,description,adress,codepostale,ville,pays,stockphysique);
          EntrepotService se = new EntrepotService();
          se.update(e,id );
           EntrepotService f =new EntrepotService();
           List<Entrepot> list; 
           list = f.readAll();
          tabentrepot.setItems((FXCollections.observableArrayList(list)));
        Alert alert =new Alert(AlertType.INFORMATION);
        alert.setTitle("blablabla");
        alert.setHeaderText("Modification réussite");
        alert.showAndWait();
        
       
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int id = tabentrepot.getSelectionModel().getSelectedItem().getId();
          EntrepotService se = new EntrepotService();
          se.delete(id);
        Alert alert =new Alert(AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("suppression réussi");
        alert.showAndWait();
         InterfacereadController ir = new InterfacereadController();
         ir.refresh();
        
       
    }

    public void refresh(){
         //public void afficher(ActionEvent event){
         EntrepotService f =new EntrepotService();
        List<Entrepot> list;  
        try {
            list = f.readAll();
       
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnnom.setCellValueFactory(new PropertyValueFactory<>("nomcourtlieu"));
        columndesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnadd.setCellValueFactory(new PropertyValueFactory<>("adress"));
        columncode.setCellValueFactory(new PropertyValueFactory<>("codepostale"));
        columnvill.setCellValueFactory(new PropertyValueFactory<>("ville"));
        columnpay.setCellValueFactory(new PropertyValueFactory<>("pays")); 
        columnstock.setCellValueFactory(new PropertyValueFactory<>("stockphysique"));
        tabentrepot.setItems(null);
        tabentrepot.setItems((FXCollections.observableArrayList(list))); 
         } catch (SQLException ex) {
            Logger.getLogger(InterfacereadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void refresher(ActionEvent event) {
       InterfacereadController ir = new InterfacereadController();
         ir.refresh();
}

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/InterfaceAjout.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
