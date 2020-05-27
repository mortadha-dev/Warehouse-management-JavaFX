  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Iservice.InterfaceStockage;
import entities.Produit;

import entities.Stockage;
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
import utils.DataBase;

/**
 *
 * @author baz info
 */
public class StockageService implements InterfaceStockage {

    private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet res;

    public StockageService() {
        con = DataBase.getInstance().getConnection();

    }

    
    public void ajouter(Stockage s) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO stockage (`id_entrepot`, `id_produit`, `quantite`, `datedestockage`) VALUES (? , ? , ?, ?);");
        try {
            pst.setInt(1, s.getEntrepot().getId());
            pst.setInt(2, s.getProduit().getId());
            pst.setInt(3, s.getQuantite());
            pst.setString(4, s.getDatedestockage());

            pst.executeUpdate();

            System.out.println("le produit est stocké");
        } catch (SQLException ex) {
            Logger.getLogger(StockageService.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }

    }

    @Override
    public boolean delete(int id) {

        try {
            String requete = "delete from stockage where id= '" + id + "' ";
            pst = con.prepareStatement(requete);
            ste = con.createStatement();
            ste.executeUpdate(requete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StockageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void update(Stockage s, int entrepot, int produit) {
        try {
            String requete = " update stockage set id_entrepot=? , id_produit=? , quantite=? , datedestockage=? where id_entrepot='" + entrepot + "' and id_produit='" + produit + "'";
            pst = con.prepareStatement(requete);
            pst.setInt(1, s.getEntrepot().getId());
            pst.setInt(2, s.getProduit().getId());
            pst.setInt(3, s.getQuantite());
            pst.setString(4, s.getDatedestockage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouter(Stockage s, int entrepot, int produit) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public ObservableList<Stockage> readAll() throws SQLException {
        ObservableList<Stockage> stocklist = FXCollections.observableArrayList();
         
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM stockage ");
            ResultSet rs = pst.executeQuery();

            EntrepotService es = new EntrepotService();
            ProduitService ps = new ProduitService();
            while (rs.next()) {
                stocklist.add(new Stockage(
                        rs.getInt(1),
                        es.getEntrepotById(rs.getInt(2)).getNomcourtlieu(),
                        ps.getProduitById(rs.getInt(3)).getDescription(),
                        rs.getInt(4),rs.getString(5)));

              //  System.out.println("Abonnement : id = " + rs.getInt(1) + " | catégorie = " + es.getEntrepotById(rs.getInt(2)) + 
                //        " | notre produit \n = " + ps.getProduitById(rs.getInt(3)) +" | notre quantite = " + rs.getString(4) +" | notre decde stockage = " + rs.getString(5));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stocklist;
    }

public List<Produit> readnonstocker() throws SQLException {
        List<Produit> arr=new ArrayList<>();
    
      String req =  ("SELECT * FROM produit WHERE id NOT IN (SELECT produit.id FROM produit JOIN stockage ON produit.id = stockage.id_produit GROUP BY produit.id) ");
     ste=con.createStatement();
    ResultSet rs = ste.executeQuery(req); 
        
            while (rs.next()) {          
                 Produit p =new Produit();
                 
               p.setId(rs.getInt(1));
               p.setDescription(rs.getString(2));
               p.setLibelle(rs.getString(3));
               p.setQuantite(rs.getInt(4));
               p.setQuantitemin(rs.getInt(5));
               
               
               
               System.out.println("Produit : id = " + rs.getInt(1) + " | description = " + rs.getString(2) + 
                         " | quantite = " + rs.getString(4) );
            
     arr.add(p); }
        return arr;
    }
public List<Produit> readpartialstocker() throws SQLException {
        List<Produit> arr=new ArrayList<>();
    
      String req =  ("SELECT * FROM produit WHERE produit.quantite > (SELECT SUM(stockage.quantite) FROM stockage WHERE produit.id = stockage.id_produit) ");
     ste=con.createStatement();
    ResultSet rs = ste.executeQuery(req); 
        
            while (rs.next()) {          
                 Produit p =new Produit();
                 
               p.setId(rs.getInt(1));
               p.setDescription(rs.getString(2));
               p.setLibelle(rs.getString(3));
               p.setQuantite(rs.getInt(4));
               p.setQuantitemin(rs.getInt(5));
               
               
               
               System.out.println("Produit : id = " + rs.getInt(1) + " | description = " + rs.getString(2) + 
                         " | quantite = " + rs.getString(4) );
            
     arr.add(p); }
        return arr;
    }}