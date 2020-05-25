/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Offre;
import java.sql.Connection;
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
import utils.MyConnection;

/**
 *
 * @author admin
 */
public class OffreService {
    public Connection con ;
    public PreparedStatement pst ;
    public Statement ste ;
    public ResultSet res ;
    
    public OffreService(){
        con = MyConnection.getInstance().getCnx();
    }

 
    public void ajouterOffre(Offre c) throws SQLException {
       
        try {
            String requeteInsert = "INSERT INTO Offre ( `NomProduit` , `AncienPrix`, `NouveauPrix`, `delaivalidite`, `CodeOffre`, `reduction`, `produit_id` ) VALUES ('"+c.getNomProduit()+"', '"+c.getAncienPrix()+"', '"+c.getNouveauPrix()+"' , '"+c.getDelaivalidite()+"' ,'"+c.getCodeOffre()+"' ,'"+c.getReduction()+"' , '"+c.getProduit_id()+"')";
            ste = con.createStatement();
            ste.executeUpdate(requeteInsert);    
            
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("L'offre est ajoutée");     
    }
       public List<Offre> afficherOffre() throws SQLException {
        List<Offre> liste = new ArrayList<>();
        ste = con.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM Offre");
        while(res.next()){
            int id = res.getInt("id");
            String NomProduit =res.getString("NomProduit");
            int AncienPrix =res.getInt("AncienPrix");
            int NouveauPrix = res.getInt("NouveauPrix");
            String delaivalidite = res.getString("delaivalidite");
            float reduction = res.getFloat("reduction");
            int CodeOffre =res.getInt("CodeOffre");
            Offre f = new Offre( id , CodeOffre , NomProduit, AncienPrix, NouveauPrix, delaivalidite,reduction);;
            liste.add(f);
        }
        
        return liste;
    }
       

      public void updateOffre(Offre f ,int id){
        try {
            String requete = " update Offre set AncienPrix=? , NouveauPrix=? , delaivalidite=?, CodeOffre=?, reduction=? where id='"+id+"'"  ;
            pst = con.prepareStatement(requete);
         
            pst.setInt(1,f.getAncienPrix());
            pst.setInt (2,f.getNouveauPrix());
            pst.setString(3,f.getDelaivalidite());
            pst.setInt(4,f.getCodeOffre());
            pst.setFloat(5,f.getReduction());
            pst.executeUpdate();
            System.out.println(afficherOffre());
            ;
        }
        catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Le fournisseur est modifié");
        
    }
         public void deleteOffre(int id)  {
        try {
            String requete = " DELETE FROM Offre WHERE id='"+id+"'" ;
            pst = con.prepareStatement(requete);
            ste=con.createStatement();
            ste.executeUpdate(requete);
            
        } catch (SQLException ex) {
            System.err.println("sorry");
            //Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("L'offre est supprimé");
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
                  public ObservableList getAllproduitssNames(){
        try {

            PreparedStatement pt= con.prepareStatement("SELECT * FROM produit");
            ResultSet rs = pt.executeQuery();
            ObservableList groupsNames = FXCollections.observableArrayList();
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
    
    
}
