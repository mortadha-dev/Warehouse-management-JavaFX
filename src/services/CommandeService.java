/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Commande;
import entities.Produit;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author admin
 */
public class CommandeService implements IService.IServiceCommande{
    
    public Connection con ;
    public PreparedStatement pst ;
    public Statement ste ;
    public ResultSet res ;
    
    public CommandeService(){
        con = MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterCommande(Commande c) throws SQLException {
       
        try {
            String requeteInsert = "INSERT INTO Commande ( `libellecommande` , `descriptioncommande`, `quantitecommande`, `prixUnitaire`, `prixTotal`, `date`, `etat`,`nomfournisseur`,`fournisseur_id`,`produit_id` ,`commentaire` ) VALUES ('"+c.getLibellecommande()+"', '"+c.getDescriptioncommande()+"' , '"+c.getQuantitecommande()+"' , '"+0+"' , '"+0+"','"+c.getDate()+"' ,'"+"en attente"+"' ,'"+c.getNomfournisseur()+"' ,'"+c.getFournisseur_id()+"' ,'"+c.getProduit_id()+"' ,'"+""+"')";
            ste = con.createStatement();
            ste.executeUpdate(requeteInsert);    
            
        } catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("La commande est ajoutée");     
    }
    
        @Override
    public List<Commande> afficherCommande() throws SQLException {
          
        List<Commande> liste = new  ArrayList<>();
            try {
                 String req = "SELECT * FROM Commande";
                 ste = con.createStatement();
                 ResultSet res= ste.executeQuery(req);
                 while(res.next()){
                 Commande c =new Commande();
                 c.setId(res.getInt(1));
                 c.setLibellecommande(res.getString(2));
                 c.setDescriptioncommande(res.getString(3));
                 c.setQuantitecommande(res.getInt(4));
                 c.setDate(res.getString(5));
                 c.setPrixunitaire(res.getInt(6));
                 c.setPrixtotal(res.getInt(7));              
                 c.setEtat(res.getString(8));
                 c.setNomfournisseur(res.getString(9));
                 
                 liste.add(c);                           
                 }       
            } catch (SQLException e) {
               }       
        
        return liste;
    }
    
    
     @Override
    public void updateCommande(Commande c, int id) {
            try {
            String requete = " update Commande set libellecommande=? , descriptioncommande=? , quantitecommande=? , prixunitaire=?, prixtotal=? , date=? , etat=?  where id='"+id+"'"  ;
            pst = con.prepareStatement(requete);
            pst.setString(1,c.getLibellecommande());
            pst.setString(2,c.getDescriptioncommande());
            pst.setInt(3,c.getQuantitecommande());
            pst.setFloat(4,c.getPrixunitaire());
            pst.setFloat(5,c.getPrixtotal());
            pst.setString(6,c.getDate());
            pst.setString(7,c.getEtat());
            pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
               System.out.println("La commande est modifié");
   
    }
    
    @Override
    public void deleteCommande(int id) throws SQLException {
           try {
            String requete = " DELETE FROM Commande WHERE id='"+id+"'" ;
            pst = con.prepareStatement(requete);
             ste=con.createStatement();
            ste.executeUpdate(requete);
            
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.println("La commande est supprimée");
    }
    
    

      public List<Produit> afficherproduits() throws SQLException {
        List<Produit> liste = new ArrayList<>();
        ste = con.createStatement();
        ResultSet res = ste.executeQuery("SELECT id,description,libelle FROM produit");
        while(res.next()){
            int id = res.getInt("id");
            String description =res.getString("description");
            String libelle = res.getString("libelle");
            Produit p = new Produit(id, description, libelle);
            liste.add(p);
        }
        
        return liste;
    }
      
    public void accepterlacommande(Commande c, int id) throws SQLException {
    
       try {
       String requete = " update Commande set etat=?  where id='"+id+"'"  ;
       pst = con.prepareStatement(requete);
       pst.setString(1,"accepté");
       pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
               System.out.println("La commande est modifié");
   
    }
    
    public void refuserlacommande(Commande c, int id) throws SQLException {
        try {
        String requete = " update Commande set etat=?  where id='"+id+"'"  ;
        pst = con.prepareStatement(requete);
        pst.setString(1,"refusée");
        pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
               System.out.println("La commande est modifié");
   
    }

    public List<Commande> afficherlacommandeenattente() throws SQLException {
          
        List<Commande> liste = new  ArrayList<>();
        FournisseurService fs = new FournisseurService();
   try {
                 //ServiceFOSUser.getCurrentUser();
                 String req = "SELECT * FROM Commande WHERE etat LIKE 'en attente' AND fournisseur_id='"+fs.getidfournisseeurbyuser(ServiceFOSUser.getCurrentUser().getId())+"'";
                 ste = con.createStatement();
                 ResultSet res= ste.executeQuery(req);
                 while(res.next()){
                 Commande c =new Commande();
                 c.setId(res.getInt(1));
                 c.setLibellecommande(res.getString(2));
                 c.setDescriptioncommande(res.getString(3));
                 c.setQuantitecommande(res.getInt(4));
                  c.setDate(res.getString(5));
                 c.setPrixunitaire(res.getInt(6));
                 c.setPrixtotal(res.getInt(7));       
                 c.setEtat(res.getString(8));
                 liste.add(c);                           
                 }       
            } catch (SQLException e) {
               }        
        return liste;
    }
    
      public void updateprix(Commande c, int id) {
            try {
            String requete = " update Commande set prixunitaire=?, prixtotal=? where id='"+id+"'"  ;
            pst = con.prepareStatement(requete);
           // pst.setString(1,c.getLibellecommande());
           // pst.setString(2,c.getDescriptioncommande());
           // pst.setInt(3,c.getQuantitecommande());
            pst.setFloat(1,c.getPrixunitaire());
            pst.setFloat(2,c.getPrixtotal());
           // pst.setString(6,c.getDate());
           // pst.setString(7,c.getEtat());
            pst.executeUpdate();
        }
            catch (SQLException ex) {
            Logger.getLogger(FournisseurService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
               System.out.println("La commande est modifié");
   
    }
    
    
    
    
    
    
    
    
    
    
}  
              
              
              
              
              
              
              
     