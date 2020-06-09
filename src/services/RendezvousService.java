/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.FOSUser;
import entities.Reclamation;
import entities.Rendezvous;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author derba
 */
public class RendezvousService {
    
private Connection connection= MyConnection.getInstance().getCnx();
    private Statement ste;
    private Statement stml;
    private PreparedStatement ps;
    private ResultSet rs;
      
    public void add(Rendezvous T) {
     String req ="insert into rendez_vous(idcl_id,desrition,dateenvoi) values('"+T.getIdcl().getId()+"','"+T.getDesrition()+"','"+T.getDateenvoi()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
             Logger.getLogger(RendezvousService.class.getName()).log(Level.SEVERE, null, ex);
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
        }return ls;
    
 }
 public int counte() {
        String req="select count(*) as qte from rendez_vous";
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

  
    public ObservableList <Rendezvous> FindAll() {
        ObservableList <Rendezvous> list =  FXCollections.observableArrayList();
        String req="select * from rendez_vous";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
             int id=rs.getInt("id");
               int idclient_id=rs.getInt("idcl_id");
                
               Date datere= rs.getDate("date");
            Date daterenv= rs.getDate("dateenvoi");
           
               String description =rs.getString("desrition");
               Rendezvous s = new Rendezvous(description, datere,daterenv);
                FOSUser KI=this.Find(idclient_id);
                 s.setNomfournisseur(KI.getUsername());
               
      
               
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }  
   
        return  list; 
    }
    public void annuler(Rendezvous t) {
        String req="delete from rendez_vous where id = '"+t.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
              System.out.println("erreur");
        }  
    }
    
  public ObservableList<Rendezvous> listerRecherche(String recherche) {
        ObservableList<Rendezvous> lsist = FXCollections.observableArrayList();
          String req = "SELECT * FROM rendez_vous WHERE date like '%" + recherche + "%' or dateenvoi  like '%" + recherche + "%' or desrition  like '%" + recherche + "%'";
         
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
              int id=rs.getInt("id");
               int idclient_id=rs.getInt("idcl_id");
                
               Date datere= rs.getDate("date");
            Date daterenv= rs.getDate("dateenvoi");
           
               String description =rs.getString("desrition");
               Rendezvous s = new Rendezvous(description, daterenv);
                FOSUser KI=this.Find(idclient_id);
                 s.setNomfournisseur(KI.getUsername());
               
      
               
               s.setId(id);
               lsist.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return lsist; 
    }

  
  
/*
       public void update(Reclamation e) {
        String req = "UPDATE rendezvous SET description=?,type =? ,date =? WHERE id=?";
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
*/
    public void fixez(Rendezvous e,Date dk) {
    String req = "UPDATE rendez_vous SET date =? WHERE id=?";
       // System.out.println(e.getEtat());
      try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
      
            preparedStatement.setDate(1,dk);
            preparedStatement.setInt(2,e.getId());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
          System.out.println("erreur");
        }
    }

}
