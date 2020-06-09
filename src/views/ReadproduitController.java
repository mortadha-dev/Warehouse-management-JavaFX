/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Produit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.ProduitService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * FXML Controller class
 *
 * @author baz info
 */
public class ReadproduitController implements Initializable {

    @FXML
    private TableColumn<Produit, String> columnid;
    @FXML
    private TableColumn<Produit, String> columndesc;
    @FXML
    private TableColumn<Produit, String> columnlibell;
    @FXML
    private TableColumn<Produit, String> columnq;
    @FXML
    private TableColumn<Produit, String> columnqm;

    @FXML
    private TextField descriptionp;
    @FXML
    private TextField libellep;
    @FXML
    private TextField quantitep;
    @FXML
    private TextField qmp;

    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Produit> tabproduit;
    @FXML
    private Button refresh;
    @FXML
    private Button ajouter;
    @FXML
    private Pane hayha;
    @FXML
    private Button exporter;
    
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProduitService ps = new ProduitService();
        List<Produit> list;
        try {
            list = ps.readAll();

            columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
            columndesc.setCellValueFactory(new PropertyValueFactory<>("description"));
            columnlibell.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            columnq.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            columnqm.setCellValueFactory(new PropertyValueFactory<>("quantitemin"));

            tabproduit.setItems(null);
            tabproduit.setItems((FXCollections.observableArrayList(list)));
        } catch (SQLException ex) {
            Logger.getLogger(InterfacereadController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void click(MouseEvent event) {
        System.out.println(tabproduit.getSelectionModel().getSelectedItem());
        Produit produit = tabproduit.getSelectionModel().getSelectedItem();
        descriptionp.setText(tabproduit.getSelectionModel().getSelectedItem().getDescription());
        libellep.setText(tabproduit.getSelectionModel().getSelectedItem().getLibelle());
        quantitep.setText(Integer.toString(tabproduit.getSelectionModel().getSelectedItem().getQuantite()));
        qmp.setText(Integer.toString(tabproduit.getSelectionModel().getSelectedItem().getQuantitemin()));

    }

    @FXML
    private void modif(ActionEvent event) throws IOException, SQLException {
        int id = tabproduit.getSelectionModel().getSelectedItem().getId();
        String description = descriptionp.getText();
        String libelle = libellep.getText();
        int quantite = Integer.parseInt(quantitep.getText());
        int quantitemin = Integer.parseInt(qmp.getText());

        Produit e = new Produit(description, libelle, quantite, quantitemin);
        ProduitService se = new ProduitService();
        se.update(e, id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("Modification réussite");
        alert.showAndWait();
        ProduitService ps = new ProduitService();
        List<Produit> list;
        list = ps.readAll();
        tabproduit.setItems((FXCollections.observableArrayList(list)));
    }

    @FXML
    private void supp(ActionEvent event) throws SQLException {
        int id = tabproduit.getSelectionModel().getSelectedItem().getId();
        ProduitService se = new ProduitService();
        se.delete(id);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("suppression réussite");
        alert.showAndWait();
        ProduitService ps = new ProduitService();
        List<Produit> list;
        list = ps.readAll();
        tabproduit.setItems((FXCollections.observableArrayList(list)));

    }

    @FXML
    private void refresher(ActionEvent event) throws SQLException {
        ProduitService ps = new ProduitService();
        List<Produit> list;
        list = ps.readAll();
        tabproduit.setItems((FXCollections.observableArrayList(list)));

    }

    @FXML
    private void ajout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Ajoutproduit.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
      
    @FXML
     public void retour(ActionEvent event) throws SQLException, IOException{ 
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeStock.fxml"));
        rootPane.getChildren().setAll(pane);
     
      }

    @FXML
    private void export(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("Fiche 1");

        org.apache.poi.ss.usermodel.Row row = spreadsheet.createRow(0);
       

        for (int j = 0; j < tabproduit.getColumns().size(); j++) {
            row.createCell(j).setCellValue(tabproduit.getColumns().get(j).getText());
        }

        for (int i = 0; i < tabproduit.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < tabproduit.getColumns().size(); j++) {
                if(tabproduit.getColumns().get(j).getCellData(i) != null) { 
                    row.createCell(j).setCellValue(tabproduit.getColumns().get(j).getCellData(i).toString()); 
                }
                else {
                    row.createCell(j).setCellValue("");
                }   
            }
        }

        FileOutputStream fileOut;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            java.util.Date date;
            date = new java.util.Date();
            fileOut = new FileOutputStream("Produits "+dateFormat.format(date)+".xls");
            workbook.write(fileOut);
            fileOut.close();
            
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitations");
        alert.setHeaderText("Fichier géneré backend : spring node js /// front : react,angular vue js ///spring+angular//nodejs (mongodb+ern stack              ");
        alert.showAndWait();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadproduitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


        
        
        
        
        
        
        
        
        
        
        
     
    }

