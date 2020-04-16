/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Iservice.InterfaceEntrepot;
import entities.Entrepot;
import entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataBase;

/**
 *
 * @author baz info
 */
public class EntrepotService  implements InterfaceEntrepot<Entrepot>{
    private Connection con;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;

    public EntrepotService(){
        con = DataBase.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(Entrepot e) throws SQLException {
         PreparedStatement pst = con.prepareStatement("INSERT INTO entrepot (`nomcourtlieu`, `description`, `adress`, `codepostale`, `ville`, `pays`, `stockphysique`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        try {
            pst.setString(1, e.getNomcourtlieu());
            pst.setString(2, e.getDescription());
            pst.setString(3, e.getAdress());
            pst.setString(4, e.getCodepostale());
            pst.setString(5, e.getVille());
            pst.setString(6, e.getPays());
             pst.setInt(7, e.getStockphysique());
             pst.executeUpdate();
                 
            System.out.println("insertion réussite");
        } catch (SQLException ex) {
            Logger.getLogger(EntrepotService.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
        
    }

    
    public boolean delete(int id) {
        
    try {
            String requete = " delete from entrepot where id= '"+id+"' " ;
            pst = con.prepareStatement(requete);
            ste=con.createStatement();
            ste.executeUpdate(requete);
              return true;
        } catch (SQLException ex) {
            Logger.getLogger(EntrepotService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    public void update(Entrepot e,int id) throws SQLException{
       PreparedStatement pst = con.prepareStatement( " update entrepot set nomcourtlieu=? , description=? , adress=?  , codepostale=? , ville=? , pays=? , stockphysique=? where id='"+id+"';");
           
        try { 
            pst.setString(1,e.getNomcourtlieu());
            pst.setString(2,e.getDescription());
            pst.setString(3,e.getAdress());
            pst.setString(4,e.getCodepostale());
            pst.setString(5,e.getVille());
            pst.setString(6,e.getPays());
            pst.setInt(7,e.getStockphysique());
            pst.executeUpdate();
            System.out.println("modification réussite");
        } catch (SQLException ex) {
            Logger.getLogger(EntrepotService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Entrepot> readAll() throws SQLException {
    List<Entrepot> arr=new ArrayList<>();
    
      String req =  ("SELECT * FROM entrepot");
     ste=con.createStatement();
    ResultSet rs = ste.executeQuery(req);
     while (rs.next()) {          
                 Entrepot p =new Entrepot();
                 
               p.setId(rs.getInt(1));
               p.setNomcourtlieu(rs.getString(2));
               p.setDescription(rs.getString(3));
               p.setAdress(rs.getString(4));
               p.setCodepostale(rs.getString(5));
               p.setVille(rs.getString(6));
               p.setPays(rs.getString(7));
               p.setStockphysique(rs.getInt(8));
               arr.add(p);
     }
     System.out.println("no");
    return arr;
    }
    
    public Entrepot getEntrepotById(int id) throws SQLException {
    
      String req =  ("SELECT * FROM entrepot where id= '"+id+"' ");
     ste=con.createStatement();
    ResultSet rs = ste.executeQuery(req);
     while (rs.next()) {          
                 Entrepot p =new Entrepot();
                 
               p.setId(rs.getInt(1));
               p.setNomcourtlieu(rs.getString(2));
               p.setDescription(rs.getString(3));
               p.setAdress(rs.getString(4));
               p.setCodepostale(rs.getString(5));
               p.setVille(rs.getString(6));
               p.setPays(rs.getString(7));
               p.setStockphysique(rs.getInt(8));
               return p;
     }
     System.out.println("no");
    return null;
    }
    
    public int getEntrepotIdByEntrepot(Entrepot entrepot) throws SQLException {
     
      PreparedStatement pst = con.prepareStatement("SELECT id FROM entrepot where nomcourtlieu=? , description=? , adress=?  , codepostale=? , ville=? , pays=? , stockphysique=? ");
     pst.setString(1, entrepot.getNomcourtlieu());
     pst.setString(2,entrepot.getDescription());
     pst.setString(3,entrepot.getAdress());
     pst.setString(4,entrepot.getCodepostale());
     pst.setString(5,entrepot.getVille());
     pst.setString(6,entrepot.getPays());
     pst.setInt(7,entrepot.getStockphysique());
     ResultSet rs = pst.executeQuery();
     while (rs.next()) {          
                int p = rs.getInt(1);
    return p; 
     }
        return 0;
    
    } 
    
    
     
 public int getEntrepotIdByNom(String nom) throws SQLException {
     
      PreparedStatement pst = con.prepareStatement("SELECT id FROM entrepot where nomcourtlieu=?");
     pst.setString(1, nom);
     ResultSet rs = pst.executeQuery();
     while (rs.next()) {          
                int p = rs.getInt(1);
    return p; 
     }
        return 0;
    
    }
 
    
    public Entrepot getEntrepotByNom(String nom) throws SQLException {
        String req =  ("SELECT * FROM entrepot where nomcourtlieu= '"+nom+"'");
     ste=con.createStatement();
    ResultSet rs = ste.executeQuery(req);
     while (rs.next()) {          
                 Entrepot p =new Entrepot();
                 
               p.setId(rs.getInt(1));
               p.setNomcourtlieu(rs.getString(2));
               p.setDescription(rs.getString(3));
               p.setAdress(rs.getString(4));
               p.setCodepostale(rs.getString(5));
               p.setVille(rs.getString(6));
               p.setPays(rs.getString(7));
               p.setStockphysique(rs.getInt(8));
               
               System.out.println("no");
     return p;
     }
    return null;
    }
    
    @Override
    public boolean delete(Entrepot e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Entrepot e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entrepot> getTrier() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrepot getById(Entrepot e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
