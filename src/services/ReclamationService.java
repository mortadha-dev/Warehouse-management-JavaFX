/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.FOSUser;
import entities.Reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import utils.MyConnection;

/**
 *
 * @author derba
 */
public class ReclamationService {
    
private Connection connection= MyConnection.getInstance().getCnx();
    private Statement ste;
    private Statement stml;
    private PreparedStatement ps;
    private ResultSet rs;
      
    public void add(Reclamation T) {
        int etat=0;
     String req ="insert into Reclamation(idclient_id,date,description,etat,type) values('"+T.getIdclient().getId()+"','"+T.getDate()+"','"+T.getDescription()+"','"+etat+"','"+T.getType()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public FOSUser Find(int id) throws SQLException {
          String remq="select * from user where id = '"+id+"'";
                        FOSUser ls = new FOSUser();
    
   stml=connection.createStatement();
           ResultSet rsz=stml.executeQuery(remq);
          
        if(rsz.next()){
                  
               int idusr= rsz.getInt("id");
               String username =rsz.getString("username");
            String email=rsz.getString("email");
              
             ls.setId(id);
            
             ls.setUsername(username);
             ls.setEmail(email);
        }
        return ls;
    
 }
 public int counte() {
        String req="select count(*) as qte from Reclamation";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int num=rs.getInt("qte");
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return 0;
    }
 //nombre des rec traité
 public int traite() {
        String req="select count(*) as qte from Reclamation where etat=1";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int num=rs.getInt("qte");
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return 0;
    }
 //nombre des rec non traité
 public int NonTraite() {
        String req="select count(*) as qte from Reclamation where etat=0";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int num=rs.getInt("qte");
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return 0;
    }
    public ObservableList<Reclamation> TriAll() {
    ObservableList <Reclamation> list =  FXCollections.observableArrayList();
        String req="select * from Reclamation Order by date Asc";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              int id=rs.getInt("id");
               int idclient_id=rs.getInt("idclient_id");
               Date datere= rs.getDate("date");
           
               Boolean etat =rs.getBoolean("etat");
                String type =rs.getString("type");
               String description =rs.getString("description");
        
   
              
             Reclamation s = new Reclamation( datere, description,etat,type);
             FOSUser KI=this.Find(idclient_id);
                 s.setNomfournisseur(KI.getUsername());
                 s.setEmailuser(KI.getEmail());
                
                   if(etat==false){
                         s.setTetat("Non traite");
   }else
                     {
                         s.setTetat("Traite");
                     }
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }
    public ObservableList <Reclamation> FindAll() {
        ObservableList <Reclamation> list =  FXCollections.observableArrayList();
        String req="select * from Reclamation";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
             int id=rs.getInt("id");
               int idclient_id=rs.getInt("idclient_id");
                
               Date datere= rs.getDate("date");
           
               Boolean etat =rs.getBoolean("etat");
                String type =rs.getString("type");
               String description =rs.getString("description");
               Reclamation s = new Reclamation( datere, description,etat,type);      
                FOSUser KI=this.Find(idclient_id);
                 s.setNomfournisseur(KI.getUsername());
                 s.setEmailuser(KI.getEmail());
                // System.out.println(KI.getEmail());
                   if(etat==false){
                         s.setTetat("Non traite");
   }else
                     {
                         s.setTetat("Traite");
                     }
       
               
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }  
    
        return  list; 
    }
    public void delete(Reclamation t) {
        String req="delete from Reclamation where id = '"+t.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
              System.out.println("erreur");
        }  
    }
    
  public ObservableList<Reclamation> listerRecherche(String recherche) {
        ObservableList<Reclamation> lsist = FXCollections.observableArrayList();
          String req = "SELECT * FROM Reclamation WHERE date like '%" + recherche + "%' or description  like '%" + recherche + "%' or etat  like '%" + recherche + "%'or type  like '%" + recherche + "%' ";
         
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              int id=rs.getInt("id");
               int idclient_id=rs.getInt("idclient_id");
               Date datere= rs.getDate("date");
           
               Boolean etat =rs.getBoolean("etat");
                String type =rs.getString("type");
               String description =rs.getString("description");
        
   
          Reclamation s = new Reclamation( datere, description,etat,type);
                     FOSUser KI=this.Find(idclient_id);
                 s.setNomfournisseur(KI.getUsername());
                 s.setEmailuser(KI.getEmail());
          
                     if(etat==false){
                         s.setTetat("Non traite");
   }else
                     {
                         s.setTetat("Traite");
                     }
               s.setId(id);
       
               lsist.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return lsist; 
    }

  
    public void remove(Reclamation T) {
    String req="delete from Reclamation where id = '"+T.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            System.out.println("erreur");
        }  
    }


       public void update(Reclamation e) {
        String req = "UPDATE Reclamation SET description=?,type =? ,date =? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
      
            preparedStatement.setString(2, e.getDescription());
         
            preparedStatement.setString(3, e.getType());
            preparedStatement.setDate(4,e.getDate());
   
        
            preparedStatement.setInt(5,e.getId());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
          System.out.println("erreur");
        }
  }
        //
    public void traiter(Reclamation e) {
    String req = "UPDATE Reclamation SET etat =1 WHERE id=?";
       // System.out.println(e.getEtat());
      try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
      
         
            preparedStatement.setInt(1,e.getId());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
          System.out.println("erreur");
        }
    }

}
