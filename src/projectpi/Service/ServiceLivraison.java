/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.Service;

import ProjectPi.connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import projectpi.entitys.Livraison;
import projectpi.entitys.Livreur;

/**
 *
 * @author Mahdi
 */
public class ServiceLivraison implements ILivraison {

    private Connection cnx;

    public ServiceLivraison() {
        cnx = MyConnection.getInstance().getCnx();
    }

   
    public List<Livraison> afficherAll() {
        List<Livraison> listL = new ArrayList<>();

//     List <Livreur> listp =new ArrayList<>();
        Statement st;
        try {
            String req = "SELECT * FROM livraison";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Livraison l = new Livraison();
                l.setId(res.getInt("id"));
                l.setVille(res.getString("ville"));
                l.setPays(res.getString("pays"));
                l.setAdresse(res.getString("adresse"));
                l.setEtat(res.getString("etat"));
                l.setHeurliv(res.getString("heurliv"));
                l.setCommande(res.getString("commande"));
                l.setClient(res.getString("client"));
                l.setLivreure(res.getString("livreure"));
                l.setDateliv(res.getDate("dateliv").toLocalDate());

                listL.add(l);
            }

        } catch (SQLException ex) {

            System.out.println(ex);

        }
        return listL;
    }

    @Override
    public int ajout(Livraison l) {
        
         int idd =1;
         try {
              
                Livreur l1 = new Livreur();
                String req1 = "SELECT id FROM livreure WHERE nomliv = ?";
                PreparedStatement pre1 = cnx.prepareStatement(req1);
                pre1.setString(1, l.getLivreure());
                ResultSet res1 = pre1.executeQuery();
                while (res1.next()) {
                    l1.setId(res1.getInt("id"));
                }
                int iden = l1.getId();
                String req = "INSERT INTO livraison (ville,pays,adresse,dateliv,heurliv,etat,livreure,commande,client,livreure_id)VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pre = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

                pre.setString(1, l.getVille());
                pre.setString(2, l.getPays());
                pre.setString(3, l.getAdresse());
                pre.setString(4, l.getDateliv().toString());
                pre.setString(5, l.getHeurliv());
                pre.setString(6, l.getEtat());
                pre.setString(7, l.getLivreure());
                pre.setString(8, l.getCommande());
                pre.setString(9, l.getClient());
                pre.setString(10,Integer.toString(iden));
                pre.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Livraison Ajouter");
                alert.showAndWait();
                ResultSet tableKeys = pre.getGeneratedKeys();
                tableKeys.next();
                 idd = tableKeys.getInt(1);
               }
         
         catch (SQLException ex) {
                System.out.println(ex);
            }
        
        
        
    return idd;   
}

    @Override
    public ObservableList<String> getNonLiv() {
       
        ObservableList<String> listnom = FXCollections.observableArrayList();
        Statement st;
        try {
            String req = "SELECT nomliv FROM livreure";
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                String nom;
                nom = res.getString("nomliv");
                listnom.add(nom);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listnom;
    }

    
    }

