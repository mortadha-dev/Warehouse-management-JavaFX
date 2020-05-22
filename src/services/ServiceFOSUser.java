/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.*;
import java.sql.Connection;
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
 * @author I.O.I
 */
public class ServiceFOSUser {
    
    private Connection c;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;
    public ServiceFOSUser() {
    c = MyConnection.getInstance().getCnx();
     }
    
    private static FOSUser currentUser;

    public void ajouterUser(FOSUser u){
        try {
            PreparedStatement pt = c.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pt.setInt(1, u.getId());
            pt.setString(2, u.getUsername());
            pt.setString(3, u.getUsername_canonical());
            pt.setString(4, u.getEmail());
            pt.setString(5, u.getEmail_canonical());
            pt.setByte(6, u.getEnabled());
            pt.setString(7, u.getSalt());
            pt.setString(8, u.getPassword());
            pt.setDate(9, u.getLast_login());
            pt.setString(10, u.getConfirmation_token());
            pt.setDate(11, u.getPassword_requested_at());
            pt.setString(12, u.getRoles());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierUser(FOSUser u){
        try {
            PreparedStatement pt = c.prepareStatement("update user set username = ?, username_canonical = ?, email = ?, email_canonical = ?, enabled = ?, salt = ?, password = ?, last_login = ?, confirmation_token = ?, confirmation_token = ?, roles = ? where id = ?");
            pt.setString(1, u.getUsername());
            pt.setString(2, u.getUsername_canonical());
            pt.setString(3, u.getEmail());
            pt.setString(4, u.getEmail_canonical());
            pt.setByte(5, u.getEnabled());
            pt.setString(6, u.getSalt());
            pt.setString(7, u.getPassword());
            pt.setDate(8, u.getLast_login());
            pt.setString(9, u.getConfirmation_token());
            pt.setDate(10, u.getPassword_requested_at());
            pt.setString(11, u.getRoles());
            pt.setInt(12, u.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerUser(int id){
        try {
            PreparedStatement pt = c.prepareStatement("delete from user where id = ?");
            pt.setInt(1, id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afficherUser(){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user");
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                System.out.println("User: id = "+rs.getInt(1)+" | username = "+rs.getString(2)+" | email = "+rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ObservableList getAllUsernames(){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user");
            ResultSet rs = pt.executeQuery();
            ObservableList usernames = FXCollections.observableArrayList();
            usernames.add("Choisir un utilisateur");
            while(rs.next()){
                usernames.add(rs.getString(2));
                System.out.println("username = "+rs.getString(2));
            }
            return usernames;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public FOSUser getUserByUsername(String username){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user where username = ?");
            pt.setString(1, username);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                FOSUser u = new FOSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getByte(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public FOSUser getUserByUsernamePassword(String username, String password){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user where username = ? & password = ?");
            pt.setString(1, username);
            pt.setString(2, password);
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                FOSUser u = new FOSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getByte(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getUsernameById(int id){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user where id = ?");
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            rs.next();
            return rs.getString(2);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean checkUsername(String username){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user where username = ?");
            pt.setString(1, username);
            ResultSet rs = pt.executeQuery();
            if(rs.next())
                return false;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean checkEmail(String email){
        try {
            PreparedStatement pt= c.prepareStatement("select * from user where email = ?");
            pt.setString(1, email);
            ResultSet rs = pt.executeQuery();
            if(rs.next())
                return false;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }     
    public static FOSUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(FOSUser currentUser) {
        ServiceFOSUser.currentUser = currentUser;
    }
    
    
      public void desactivercompte(int id) 
    {  
                try {
                PreparedStatement pt = c.prepareStatement("update user set enabled=0 where id=? ");
                pt.setInt(1,id);
               // pt.setString(2,email);
                pt.executeUpdate();
            }
                catch (SQLException ex) {
                Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }
      
      
       public void activercompte(int id) 
    {  
                try {
                PreparedStatement pt = c.prepareStatement("update user set enabled=1 where id=? ");
                pt.setInt(1,id);
                
                pt.executeUpdate();
            }
                catch (SQLException ex) {
                Logger.getLogger(ServiceFOSUser.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }
      
}
