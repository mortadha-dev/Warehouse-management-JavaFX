/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Commande;
import entities.Offre;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import services.CommandeService;
import services.OffreService;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXMLReadCommandeController implements Initializable {
    @FXML
    public Button affichercommande;
    
    @FXML
    public Button consulteroffres ; 
    
    @FXML
    public Button update;
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
    public TableColumn<Commande, String> columnnomfournisseur;
    
    @FXML
    public AnchorPane rootPane;
    
    @FXML 
    public TextField libellecommandea;  
    
    @FXML 
    public TextField descriptioncommandea;
    
    @FXML 
    public TextField quantitecommandea;
    
    @FXML 
    public TextField prixUnitairea;
    
    @FXML 
    public TextField prixTotala;
    
    @FXML 
    public TextField datea;
    
    @FXML 
    public TextField etata;
     @FXML 
    public TextField ch;
      @FXML 
    public Button search;

   // Connection c= MyConnection.getInstance().getCnx();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableUser.refresh();

        // TODO
    }
    @FXML
    private void affichercommande(ActionEvent event) throws SQLException {
        CommandeService f =new CommandeService();
        List<Commande> list = f.afficherCommande();  
        
        columnlibelle.setCellValueFactory(new PropertyValueFactory<>("libellecommande"));
        
        columndescription.setCellValueFactory(new PropertyValueFactory<>("descriptioncommande"));
        
        columnquantite.setCellValueFactory(new PropertyValueFactory<>("quantitecommande"));
        
        columnprixunitaire.setCellValueFactory(new PropertyValueFactory<>("prixunitaire"));
        
        columnprixtotal.setCellValueFactory(new PropertyValueFactory<>("prixtotal"));      
        columndate.setCellValueFactory(new PropertyValueFactory<>("date"));
        columnetat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        columnnomfournisseur.setCellValueFactory(new PropertyValueFactory<>("nomfournisseur"));    
        tableUser.setItems(null);
        tableUser.setItems((FXCollections.observableArrayList(list))); 
    }
    
      @FXML
    private void afficheroffres(ActionEvent event) throws SQLException, IOException {
        
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLReadOffre.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
 
       
    
    @FXML
    public void ajoutcommande(ActionEvent event) throws SQLException, IOException{
        System.out.println("hello");
        Stage stage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutCommande.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    
        
    }
    
    @FXML
    public void delete(ActionEvent event) throws SQLException{
        CommandeService a =new CommandeService();
        int f = (int) tableUser.getSelectionModel().getSelectedItem().getId();
        System.out.println("le code de commande " +f);
        a.deleteCommande(f);         
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("suppression du commande ");
        alert.setHeaderText("La commande est bien supprimé ");
        alert.setContentText("OK!");
        alert.showAndWait();
        CommandeService s =new CommandeService();
        List<Commande> list = s.afficherCommande();  
        tableUser.setItems((FXCollections.observableArrayList(list))); 
      
        }
    
    @FXML
     public void retour(ActionEvent event) throws SQLException, IOException{ 
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLHomeAchat.fxml"));
        rootPane.getChildren().setAll(pane);
     
      }
       
    public Commande x ;
    @FXML
    public  void getselected(){
       x = tableUser.getSelectionModel().getSelectedItem();
       libellecommandea.setText(x.getLibellecommande());
       descriptioncommandea.setText(x.getDescriptioncommande());
       quantitecommandea.setText(Integer.toString(x.getQuantitecommande()));
       prixUnitairea.setText(Integer.toString((int) x.getPrixunitaire()));
       prixTotala.setText(Integer.toString((int) x.getPrixtotal()));
       datea.setText(x.getDate());
       etata.setText(x.getEtat());
    }
    
    @FXML
    public void update(ActionEvent event) throws SQLException{
        int w = tableUser.getSelectionModel().getSelectedItem().getId();
        String libellecommande=libellecommandea.getText();
        String descriptioncommande = descriptioncommandea.getText();
        int quantitecommande= Integer.parseInt(quantitecommandea.getText());
        float prixunitaire = Float.parseFloat(prixUnitairea.getText());
        float prixtotal = Float.parseFloat(prixTotala.getText());
        String date = datea.getText();
        String etat = etata.getText();
        System.out.println(libellecommande+descriptioncommande+quantitecommande+prixunitaire+prixtotal+date);
        Commande  a= new Commande(libellecommande, descriptioncommande, quantitecommande,prixunitaire, prixtotal, date,etat);
        CommandeService cs = new CommandeService();
        cs.updateCommande(a,w);
        Alert alert  =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification du commande ");
        alert.setHeaderText("La commande est bien modifié ");
        alert.setContentText("OK!");
        alert.showAndWait();
        CommandeService s =new CommandeService();
        List<Commande> list = s.afficherCommande();  
        tableUser.setItems((FXCollections.observableArrayList(list))); 
        libellecommandea.clear();
        descriptioncommandea.clear();
        quantitecommandea.clear();
        prixUnitairea.clear();
        prixTotala.clear();
        datea.clear();
        etata.clear();
        
    }
    
    @FXML
    
    public void aprop (ActionEvent event) throws IOException {
        
    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLApropos.fxml"));
    rootPane.getChildren().setAll(pane);
            
    }
      public Connection con ;
    public PreparedStatement pst ;
    public Statement ste ;
    public ResultSet res ;
    
     public FXMLReadCommandeController(){
        con = MyConnection.getInstance().getCnx();
    }
        @FXML
    private void PDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        Document doc = new Document();
        String sql = "SELECT * FROM commande ";
        
        try{
             pst =con.prepareStatement(sql);
             res = pst.executeQuery();
             PdfWriter.getInstance(doc, new FileOutputStream("C:\\test\\test.pdf"));         
             doc.open();             
             doc.newPage();
             Paragraph test = new Paragraph("Liste des commandes");
             test.setAlignment(Element.ALIGN_CENTER);
              
              doc.add(test);
              
              doc.add(new Paragraph(" "));
             
             PdfPTable table = new PdfPTable(8);
             table.setWidthPercentage(100);
             PdfPCell cell ;   
             /////////////////////////////////////////////////////////////
             cell= new PdfPCell(new Phrase("libelle commande",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             
             
              cell= new PdfPCell(new Phrase("description ",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             cell= new PdfPCell(new Phrase("quantite",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             
             
             cell= new PdfPCell(new Phrase("Prix.U",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             
             
             cell= new PdfPCell(new Phrase("Prix.T",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
     
             cell= new PdfPCell(new Phrase("Date",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             
             
             cell= new PdfPCell(new Phrase("Etat",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
             
             cell= new PdfPCell(new Phrase("Nom fournisseur",FontFactory.getFont("Comic Sans MS",12)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GREEN);
             table.addCell(cell);
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            while (res.next())
            {
                cell = new PdfPCell(new Phrase(res.getString("libellecommande"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);          
                 cell = new PdfPCell(new Phrase(res.getString("descriptioncommande"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                 cell = new PdfPCell(new Phrase(res.getString("quantitecommande"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                 cell = new PdfPCell(new Phrase(res.getString("prixUnitaire"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                 cell = new PdfPCell(new Phrase(res.getString("prixTotal"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                 cell = new PdfPCell(new Phrase(res.getString("date"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                 cell = new PdfPCell(new Phrase(res.getString("etat"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                 cell = new PdfPCell(new Phrase(res.getString("nomfournisseur"),FontFactory.getFont("Arial",11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
            }
            doc.add(table);
            doc.close();
         
        }
        catch(SQLException e){
            
        }
       
        
          Notifications notificationBuilder = Notifications.create();
         notificationBuilder.text("donwload complete");
         notificationBuilder.title("téléchargement du PDF");
         notificationBuilder.graphic(null);
         notificationBuilder.hideAfter(Duration.seconds(5));
         notificationBuilder.position(Pos.BASELINE_RIGHT);
         notificationBuilder.onAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent event ){
             System.out.println("tettt");
         }
     });
         notificationBuilder.darkStyle();
         notificationBuilder.showConfirm(); 
        
    }
    
    }

     

    
    
    
    

 