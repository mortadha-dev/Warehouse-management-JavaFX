/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.views;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ProjectPi.connection.MyConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import projectpi.Service.ServiceLivraison;
import projectpi.entitys.Livraison;
import projectpi.entitys.Livreur;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class LivraisonController implements Initializable {

    private Connection cnx;

    public LivraisonController() {
        cnx = MyConnection.getInstance().getCnx();
    }

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Livraison> table;
    @FXML
    private TableColumn<Livraison, Integer> id;
    @FXML
    private TableColumn<Livraison, String> etat;
    @FXML
    private TableColumn<Livraison, Date> date;
    @FXML
    private TableColumn<Livraison, String> heur;
    @FXML
    private TableColumn<Livraison, String> comm;
    @FXML
    private TableColumn<Livraison, String> client;
    @FXML
    private TableColumn<Livraison, String> pays;
    @FXML
    private TableColumn<Livraison, String> ville;
    @FXML
    private TableColumn<Livraison, String> adresse;
    @FXML
    private TableColumn<Livraison, String> livreure;
    @FXML
    private JFXButton deleteButton;
    @FXML   
    private JFXButton addButton;  
    @FXML
    private TextField com;
    @FXML
    private JFXButton updateButton;
    @FXML
    private Label commande;
    @FXML
    private Label dateliv;
    @FXML
    private Label etatliv;
    @FXML
    private JFXButton ajoutcommande1;
    @FXML
    private TextField hour;
    @FXML
    private TextField clt;
    @FXML
    private TextField country;    
    @FXML
    private TextField city;
    @FXML
    private TextField adress;
    @FXML
    private Label heurliv;
    @FXML
    private Label clientliv;
    @FXML
    private Label paysliv;
    @FXML
    private Label villeliv;
    @FXML
    private Label adresseliv;
    @FXML
    private Label livreureliv;
    @FXML
    private ComboBox<String> status;
    @FXML
    private ComboBox<String> shipping;
    @FXML
    private DatePicker datt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
//        RequiredFieldValidator validate = new  RequiredFieldValidator();
//        
//         adress.setValidators(validate);
////        adress.getValidators().add(validate);
         
        ServiceLivraison sv = new ServiceLivraison();

        shipping.setItems(sv.getNonLiv());
        shipping.setVisibleRowCount(3);
        status.getItems().addAll("En Cour", "Livrée");

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        heur.setCellValueFactory(new PropertyValueFactory<>("heurliv"));
        comm.setCellValueFactory(new PropertyValueFactory<>("commande"));
        client.setCellValueFactory(new PropertyValueFactory<>("client"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        livreure.setCellValueFactory(new PropertyValueFactory<>("livreure"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateliv"));
        List<Livraison> list = sv.afficherAll();
//        table.setItems((ObservableList<Livraison>) list);
        table.setItems(FXCollections.observableArrayList(list));
        // TODO
    }

    @FXML
    private void GetLine(MouseEvent event) {

        try {
            ObservableList<Livraison> click = (ObservableList<Livraison>) table.getSelectionModel().getSelectedItems();
            com.setText(click.get(0).getCommande());
            hour.setText(click.get(0).getHeurliv());
            clt.setText(click.get(0).getClient());
            country.setText(click.get(0).getPays());
            city.setText(click.get(0).getVille());
            adress.setText(click.get(0).getAdresse());
            adress.setText(click.get(0).getAdresse());
            datt.setValue(click.get(0).getDateliv());
            status.setValue(click.get(0).getEtat());
            shipping.setValue(click.get(0).getLivreure());
            deleteButton.setDisable(false);
            updateButton.setDisable(false);
        } catch (Exception e) {
        }
    }

    private void supprimerlivreur(ActionEvent event) {

    }

    @FXML
    private void retour(ActionEvent event) {
    }


    @FXML
    private void supprimerlivraison(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Item");
        alert.setContentText("Are you sure want to remove this Item!");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null || option.get() == ButtonType.CANCEL) {
        } else if (option.get() == ButtonType.OK) {
            try {
                String req = "DELETE FROM livraison WHERE ID=?";
                PreparedStatement pre = cnx.prepareStatement(req);
                pre.setString(1, Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
                pre.executeUpdate();
                table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void ajoutlivraison(ActionEvent event) {
       
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Date datev = new Date();
                        String d = dateFormat.format(datev);
                         String d1 =datt.getValue().toString();
                          if (d1.compareTo(d)> 0 ){
                         
                        if (!adress.getText().equals("")){
                            
                          
                          
                                     
        ServiceLivraison sv = new ServiceLivraison();
        Livraison l = new Livraison();
        l.setVille(city.getText());
        l.setPays(country.getText());
        l.setAdresse(adress.getText());
        l.setDateliv(datt.getValue());
        l.setHeurliv(hour.getText());
        l.setEtat(status.getSelectionModel().getSelectedItem().toString());
        l.setLivreure(shipping.getSelectionModel().getSelectedItem().toString());
        l.setCommande(com.getText());
        l.setClient(clt.getText());

        int id = sv.ajout(l);
        l.setId(id);
        table.getItems().add(l);
        city.clear();
        adress.clear();
        country.clear();
        hour.clear();
        com.clear();
        clt.clear();
        datt.getEditor().clear();
        shipping.getEditor().clear();
        status.getEditor().clear();
                        }
                        else{
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText(" adresse vide");
                        alert.showAndWait();  
                        } }
                          else {
                          
                           Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("doit etre superieur a la date d'aujourd'hui");
                        alert.showAndWait();  
                        }
                          
                          }
                        
                        
                                    
//                           else   {
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Information Dialog");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Date doit etre superieur a la date d'aujourd'hui");
//                        alert.showAndWait();
//                    }



    @FXML
    private void modifierlivraison(ActionEvent event) {
          ServiceLivraison sv = new ServiceLivraison();
        
       try {
                Livreur l1 = new Livreur();
                String req1 = "SELECT id FROM livreure WHERE nomliv = ?";
                PreparedStatement pre1 = cnx.prepareStatement(req1);
                pre1.setString(1, shipping.getSelectionModel().getSelectedItem().toString());
                ResultSet res1 = pre1.executeQuery();
                while (res1.next()) {
                    l1.setId(res1.getInt("id"));
                }
                int iden = l1.getId();

                String req = "UPDATE livraison SET ville = ?, pays = ?, adresse= ?, dateliv= ?, heurliv= ?, etat= ?, livreure= ?, commande= ?, client= ?,livreure_id=? WHERE id = ? ";
                PreparedStatement pre = cnx.prepareStatement(req);
                pre.setString(11, Integer.toString(table.getSelectionModel().getSelectedItem().getId()));
                pre.setString(1, city.getText());
                pre.setString(2, country.getText());
                pre.setString(3, adress.getText());
                pre.setString(4, datt.getValue().toString());
                pre.setString(5, hour.getText());
                pre.setString(6, status.getSelectionModel().getSelectedItem().toString());
                pre.setString(7, shipping.getSelectionModel().getSelectedItem().toString());
                pre.setString(8, com.getText());
                pre.setString(9, clt.getText());
                pre.setString(10, Integer.toString(iden));
//                
                pre.executeUpdate();
               table.setItems(FXCollections.observableArrayList (sv.afficherAll()));
                city.clear();
                adress.clear();
                country.clear();
                hour.clear();
                com.clear();
                clt.clear();
                datt.getEditor().clear();
                shipping.getEditor().clear();
                status.getEditor().clear();

//                table.setItems(afficherAll());
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        
        
        

    }

    @FXML
    private void QRCODE(ActionEvent event) {
        
        int size = 400;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        ObservableList<Livraison> line = (ObservableList<Livraison>) table.getSelectionModel().getSelectedItems();
        int width = 300;
        int height = 300;
        String fileType = "png";
        String Data ="Nom: "+line.get(0).getClient()+"\n"+ "Pays: "+line.get(0).getPays()+"\n"+" Ville: "+line.get(0).getVille()+"\n"+" Adress: "+line.get(0).getAdresse()+"\n"+"Date de Livraison: "+line.get(0).getDateliv()+"\n"+"Heur de livraison: "+line.get(0).getHeurliv();
         BufferedImage bufferedImage = null;
         try {
             
             BitMatrix byteMatrix = qrCodeWriter.encode(Data, BarcodeFormat.QR_CODE, width, height);
               bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
             Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.white);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
             
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
             
            System.out.println("Success...");
            
              }
              catch  (WriterException ex){
            
              };
               ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));  
        StackPane rootcode = new StackPane();
        rootcode.getChildren().add(qrView);   
        Scene scenecode = new Scene(rootcode, 350, 350);
         Stage primaryStage =new Stage();
        primaryStage.setTitle("QRcode");
        primaryStage.setScene(scenecode);
        primaryStage.show();
     
        
    }

}
