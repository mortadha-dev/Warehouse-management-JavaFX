/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Conge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class EmployeServices{
     private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    
//          public PreparedStatement pst ;
//          private Connection con;
//          private Statement ste;
   
    public EmployeServices(){
       cnx= MyConnection.getInstance().getCnx();
    }
    public ObservableList< Employe> afficherRechercheClub(String motClef) {

        ObservableList< Employe> s = FXCollections.observableArrayList();

        {
            try {

                Statement st = cnx.createStatement();
                String req = "Select nom,prenom,numtel,cin,email from  employe WHERE "
                        + " `nom` LIKE '%" + motClef + "%' OR `email` LIKE '%" + motClef + "%' OR `prenom` LIKE '%" + motClef + "%' ";
                ResultSet rs = st.executeQuery(req);
                int i = 0;

                while (rs.next()) {
                    i++;
                     Employe c = new  Employe();
                    c.setNom(rs.getString(1));
                    c.setPrenom(rs.getString(2));
                    c.setNumtel(rs.getString(3));
                    c.setCin(rs.getString(4));
                    c.setEmail(rs.getString(5));
                    
                  

                    s.add(c);
                    System.out.println(i);

                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return s;
           

        }

    }
    
    
    public void ajouteremploye(Employe e){
    
       try { 
           String req= "INSERT INTO employe(nom,prenom,numtel,cin,email) VALUES"
                   + "('"+e.getNom() +"' , '"+e.getPrenom()+"','"+e.getNumtel()+"','"+e.getCin()+"' , '"+e.getEmail()+ "')";
         
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("insertion employe reussie");
       } catch (SQLException ex) {
          System.out.println(ex) ;
       }
   }
     
       public void delete(String cin) throws SQLException {
           try {
            String requete = " DELETE FROM employe WHERE cin='"+cin+"'" ;
            pre = cnx.prepareStatement(requete);
             st=cnx.createStatement();
            st.executeUpdate(requete);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.println("L'employe  est supprimée");
    }
     
    
    public List<Employe> afficherAll() {

        List<Employe> listE = new ArrayList<>();

        try {
            String req = "SELECT * FROM employe";
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Employe e = new Employe() ;
//                e.setIdE(res.getInt("idE"));
                e.setNom(res.getString("nom"));
                e.setPrenom(res.getString("prenom"));
                e.setNumtel(res.getString("numtel"));
//                e.setAdresse(res.getString("adresse"));
                e.setCin(res.getString("cin"));
                e.setEmail(res.getString("email"));

                 listE.add(e);  
            }
            System.out.println(listE);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listE;
    }
   
 public void updateemploye(Employe c, String cin) {
            try {
            String req = " update employe set nom=? , prenom=? , numtel=? , cin=?, email=?   where cin='"+cin+"'"  ;
            pre = cnx.prepareStatement(req);
            pre.setString(1,c.getNom());
            pre.setString(2,c.getPrenom());
            pre.setString(3,c.getNumtel());
            pre.setString(4,c.getCin());
            pre.setString(5,c.getEmail());
          
            pre.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            
               System.out.println("L'employé est modifié");
   
    }
     
}
