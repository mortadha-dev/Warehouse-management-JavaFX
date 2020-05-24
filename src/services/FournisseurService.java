/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Fournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;
import IService.IServiceFournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author admin
 */
public class FournisseurService implements IServiceFournisseur{
    
    private Connection con;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;

    public FournisseurService() {
        con = MyConnection.getInstance().getCnx();

    }
    
    @Override
    public void ajouterFournisseur(Fournisseur f) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO Fournisseur (`code`, `nom`, `prenom`, `adresse_email`, `telephone`, `ville`, `pays`, `rapidite`,`etat_compte`, `user_id` ) VALUES ('"+ f.getCode()+"', '" +f.getNom()+"', '" +f.getPrenom()  +"', '" + f.getAdresse_email()+ "', '" + f.getTelephone()+ "', '" + f.getVille() + "', '" + f.getPays()+ "', '" +f.getRapidite() +"', '"+ "Pending" + "', '" +f.getUser_id()+ "')" ;
        try {
            ste=con.createStatement();
            ste.executeUpdate(requeteInsert);
            
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Le fournisseur est ajouté");
    }
        
  @Override

    public List<Fournisseur> afficherFournisseur() throws SQLException {
        List<Fournisseur> liste = new ArrayList<>();
        ste = con.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM Fournisseur");
        while(res.next()){
            int id = res.getInt("id");
            int code =res.getInt("code");
            String nom =res.getString("nom");
            String prenom = res.getString("prenom");
            String adresse_mail = res.getString("adresse_email");
            int telephone =res.getInt("telephone");
            String vile = res.getString("ville");
            String pays = res.getString("pays");
            String rapidite = res.getString("rapidite");   
            String etat_compte = res.getString("etat_compte");  
            Fournisseur f = new Fournisseur(id, code, nom, prenom, adresse_mail, telephone, vile, pays, rapidite,etat_compte);;
            liste.add(f);
        }
        
        return liste;
    }
    public ObservableList<Fournisseur> getAllFournisseurs(){
        try {
            PreparedStatement pt= con.prepareStatement("select * from fournisseur");
            ResultSet res = pt.executeQuery();
            ObservableList<Fournisseur> oblist = FXCollections.observableArrayList();
            while(res.next()){
                int id = res.getInt("id");
                int code =res.getInt("code");
                String nom =res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse_mail = res.getString("adresse_email");
                int telephone =res.getInt("telephone");
                String vile = res.getString("ville");
                String pays = res.getString("pays");
                String rapidite = res.getString("rapidite");
                int user_id =res.getInt("user_id");

                Fournisseur f = new Fournisseur(code, nom, prenom, adresse_mail, telephone, vile, pays, rapidite, user_id);
                oblist.add(f);
            }
            return oblist;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public ObservableList combo(){
        try {
            PreparedStatement pt= con.prepareStatement("select * from fournisseur");
            ResultSet rs = pt.executeQuery();
            ObservableList artistesCIN = FXCollections.observableArrayList();
            artistesCIN.add("Choisir un artiste");
            while(rs.next()){
                artistesCIN.add(rs.getString(3));
                artistesCIN.add(rs.getString(1));
                
                System.out.println("nom = "+rs.getString(3));
            }
            return artistesCIN;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 

@Override
      public void updateFournisseur(Fournisseur f ,int id){
        try {
            String requete = " update Fournisseur set code=? ,nom=? , prenom=? , adresse_email=?, telephone=? ,ville=? , pays=?, rapidite=?   where id='"+id+"'"  ;
            pst = con.prepareStatement(requete);
            pst.setInt(1,f.getCode());
            pst.setString(2,f.getNom());
            pst.setString(3,f.getPrenom());
            pst.setString(4,f.getAdresse_email());
            pst.setInt(5,f.getTelephone());
            pst.setString(6,f.getVille());
            pst.setString(7,f.getPays());
            pst.setString(8,f.getRapidite());
            pst.executeUpdate();
            afficherFournisseur();
        }
        catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Le fournisseur est modifié");
    }
      
      @Override
       public void deleteFournisseur(int id)  {
        try {
            String requete = " DELETE FROM Fournisseur WHERE id='"+id+"'" ;
            pst = con.prepareStatement(requete);
            ste=con.createStatement();
            ste.executeUpdate(requete);
            
        } catch (SQLException ex) {
            System.err.println("sorry");
            //Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Le fournisseur est supprimé");
       }     
       
         public ObservableList getAllfournisseursNames(){
        try {
 
            PreparedStatement pt= con.prepareStatement("SELECT * FROM fournisseur");
            ResultSet rs = pt.executeQuery();
            ObservableList groupsNames = FXCollections.observableArrayList();
            //groupsNames.add("Choisir un fournisseur");
            while(rs.next()){
                groupsNames.add(rs.getString(3));
                System.out.println(rs.getString(3));

            }
            return groupsNames;
                         
        } 
        catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
         
      public ObservableList getAllproduitssNames(){
        try {

            PreparedStatement pt= con.prepareStatement("SELECT * FROM produit");
            ResultSet rs = pt.executeQuery();
            ObservableList groupsNames = FXCollections.observableArrayList();
           // groupsNames.add("Choisir un produit");
            while(rs.next()){
                groupsNames.add(rs.getString(3));
                System.out.println(rs.getString(3));
            }
            return groupsNames;
                         
        } 
        catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
          public int getfournisseurIdByName(String nom){
              System.out.println("chnuwaaaaa");
        try {
            PreparedStatement pt= con.prepareStatement("SELECT id FROM fournisseur WHERE nom = ?");
            pt.setString(1, nom);
            ResultSet rs = pt.executeQuery();
            if(rs.next())
                      return rs.getInt(1);
             System.out.println("tawaaa");
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
             public int getProduitIdByName(String libelle){
        try {
            PreparedStatement pt= con.prepareStatement("select * from produit where libelle = ?");
            pt.setString(1, libelle);
            ResultSet rs = pt.executeQuery();
            if(rs.next())
                return rs.getInt(1);
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
             
        public int getidfournisseeurbyuser(int id){
        try {
            PreparedStatement pt= con.prepareStatement(" SELECT id FROM fournisseur WHERE user_id=?");
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if(rs.next())
                return rs.getInt(1);
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
             public void disablecomptefournisseur(int id) throws SQLException {
    
       try {
       String requete = " update fournisseur set etat_compte=?  where id='"+id+"'"  ;
       pst = con.prepareStatement(requete);
       pst.setString(1,"désactivé");
       pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
               System.out.println("L'état  est modifié");
   
    }
                  public void enablecomptefournisseur(int id) throws SQLException {
    
       try {
       String requete = " update fournisseur set etat_compte=?  where id='"+id+"'"  ;
       pst = con.prepareStatement(requete);
       pst.setString(1,"activé");
       pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
               System.out.println("L'état  est modifié");
   
    }
                
    }
        
      
































