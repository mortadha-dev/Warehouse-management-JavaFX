/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entites.Conge;
import entites.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author HP
 */
public class CongeServices {
    
    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
    
   
    public CongeServices(){
       cnx= MyConnection.getInstance().getCnx();
    }
    public void ajouterconge(Conge c){
    
       try {
          
          
             String req= "INSERT INTO conge(raison,datedebut,datefin) VALUES"
                   + "('"+c.getRaison() +"' , '"+c.getDatedebut()+"','"+c.getDatefin()+"')";
         
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("insertion conge reussie");
       } catch (SQLException ex) {
          System.out.println(ex) ;
       }
    }
    
    
    public List<Conge> afficherAllconge() {

        List<Conge> listC = new ArrayList<>();

        try {
            String req = "SELECT * FROM conge";
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Conge c = new Conge() ;

                c.setRaison(res.getString("raison"));
                c.setDatedebut(res.getString("datedebut"));
                c.setDatefin(res.getString("datefin"));
               c.setEtat(res.getInt("etat"));
               
               listC.add(c);  
            }
            System.out.println(listC);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listC;
    }
    
    
    public void modifierEtatClub(Conge c) {
        try {
//            System.out.println("this is c " + c.getDatedebut()+ " - this etat : " + c.getEtat() + "NAME CLUB ==>" + c.getDatefin());
//            com.mysql.jdbc.PreparedStatement pt = (com.mysql.jdbc.PreparedStatement) cnx.prepareStatement("update conge set etat = ? where datedebut=? AND datefin=? ");
            
            
//             String req ="update conge set etat = ? where datedebut=? AND datefin=? " ;
            String req ="update conge set etat = ?  " ;
//         String req ="update conge set etat = accepter ";
            pre = cnx.prepareStatement(req);
            pre.setInt(1, c.getEtat());
            pre.setString(2, c.getDatedebut());
            pre.setString(3, c.getDatefin());
            //System.out.println("hello");

            pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CongeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    public void updateConge(Conge cc ,int id){
//        try {
//            String requete = " update conge set duree=? , raison=? , etat=?     where idconge='"+id+"'  "  ;
//            pre = cnx.prepareStatement(requete);
//            
//            pre.setInt(1,cc.getDuree());
//            pre.setString(2,cc.getRaison());
//            pre.setInt(3,cc.getEtat());
//            
//            pre.executeUpdate();
//            System.out.println(" le conge modifié est  :"+" "+ cc.getDuree()+" " + cc.getRaison()+
//                    " " + cc.getEtat()  );
//                  
//         
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Le conge est modifié");
//    }
//    public void deleteConge(Conge cc ,int id){
//        try {
//            String requete = " delete from conge      where idconge='"+id+"'  "  ;
//            pre = cnx.prepareStatement(requete);
//            
//
//            pre.executeUpdate();
//            
//                  
//        
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Le conge est supprimé");
//    }
}
