/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import  utils.MyConnection;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceLivreur;
import entities.Livreur;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class LivreurController implements Initializable {

    private Connection cnx;

    public LivreurController() {
        cnx = MyConnection.getInstance().getCnx();
    }
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton add;
    @FXML
    private TextField num;
    @FXML
    private TextField adresse;
    @FXML
    private TextField nom;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton ajoutcommande1;

    @FXML
    private TableView<Livreur> table;
    @FXML
    private TableColumn<Livreur, String> Livid;
    @FXML
    private TableColumn<Livreur, String> Livname;
    @FXML
    private TableColumn<Livreur, String> Livnum;
    @FXML
    private TableColumn<Livreur, String> Livadd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ServiceLivreur sv = new ServiceLivreur();

        Livid.setCellValueFactory(new PropertyValueFactory<>("id"));
        Livnum.setCellValueFactory(new PropertyValueFactory<>("numtel"));

        Livadd.setCellValueFactory(new PropertyValueFactory<>("adresseliv"));
        Livname.setCellValueFactory(new PropertyValueFactory<>("nomliv"));

        List<Livreur> list = sv.afficherAll();
        table.setItems(FXCollections.observableArrayList(list));

        // TODO
    }

    @FXML
    private void supprimerlivreur(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Item");
        alert.setContentText("Are you sure want to remove this Item!");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null || option.get() == ButtonType.CANCEL) {

        } else if (option.get() == ButtonType.OK) {

            try {
                String req = "DELETE FROM livreure WHERE ID=?";
                PreparedStatement pre = cnx.prepareStatement(req);
                pre.setString(1, Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
                pre.executeUpdate();
                table.getItems().removeAll(table.getSelectionModel().getSelectedItem());

                System.out.println("delete reussie");
//      table.setItems(afficherAll());     
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    @FXML
    private void ajoutlivreur(ActionEvent event) {
        Livreur l = new Livreur();
        ServiceLivreur sv = new ServiceLivreur();
        l.setNomliv(nom.getText());
        l.setNumtel(Integer.parseInt(num.getText()));
        l.setAdresseliv(adresse.getText());
        int a = sv.ajout(l);
        l.setId(a);
        table.getItems().add(l);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Livreur Ajouter");
        alert.showAndWait();
        nom.clear();
        adresse.clear();
        num.clear();

    }

    @FXML
    private void retour(ActionEvent event)throws Exception {
        
        
         AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeLivraison.fxml"));
         rootPane.getChildren().setAll(pane);

    }

    @FXML
    private void modifierlivreur(ActionEvent event) {
        ServiceLivreur sv = new ServiceLivreur();
         Livreur l = new Livreur();
        try{
        String req = "UPDATE livreure SET nomliv = ?, adresseliv = ?, numtel= ? WHERE id = ? ";
                PreparedStatement pre = cnx.prepareStatement(req);
                pre.setString(4, Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
                pre.setString(1, nom.getText());
                pre.setString(2, adresse.getText());
                pre.setString(3, num.getText());
                pre.executeUpdate();
                table.setItems(FXCollections.observableArrayList (sv.afficherAll()));
                nom.clear();
                adresse.clear();
                num.clear();
        
        
        }
        
        
       catch (SQLException ex) {
                System.out.println(ex);
            }
    }

    @FXML
    private void PDF(ActionEvent event) {
    }

    @FXML
    private void GetLine(MouseEvent event) {
        try {
            ObservableList<Livreur> click = (ObservableList<Livreur>) table.getSelectionModel().getSelectedItems();
            nom.setText(click.get(0).getNomliv());
            adresse.setText(click.get(0).getAdresseliv());
            num.setText(Integer.toString(click.get(0).getNumtel()));
            delete.setDisable(false);
            update.setDisable(false);
//                qrButton.setDisable(false);
        } catch (Exception e) {
        }

    }

}
