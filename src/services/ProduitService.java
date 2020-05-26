/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import IService.InterfaceProduit;
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
import utils.MyConnection;

/**
 *
 * @author baz info
 */
public class ProduitService implements InterfaceProduit<Produit> {

    private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet res;

    public ProduitService() {
        con = MyConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(Produit p) throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO produit (`description`, `libelle`, `quantite`, `quantitemin`, `supprimer`, `datesupp`) VALUES (?, ?, ?, ?, 0, null);");
        try {
            pst.setString(1, p.getDescription());
            pst.setString(2, p.getLibelle());
            pst.setInt(3, p.getQuantite());
            pst.setInt(4, p.getQuantitemin());

            pst.executeUpdate();

            System.out.println("insertion réussite");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }

    }

    public boolean delete(int id) {

        try {
            String requete = " delete from produit where id= '" + id + "' ";
            pst = con.prepareStatement(requete);
            ste = con.createStatement();
            ste.executeUpdate(requete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void update(Produit p, int id) {
        try {
            String requete = " update produit set description=? , libelle=? , quantite=? , quantitemin=?    where id='" + id + "'";
            pst = con.prepareStatement(requete);
            pst.setString(1, p.getDescription());
            pst.setString(2, p.getLibelle());
            pst.setInt(3, p.getQuantite());
            pst.setInt(4, p.getQuantitemin());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produit getProduitById(int id) throws SQLException {
        List<Produit> arr = new ArrayList<>();
        String req = ("SELECT * FROM produit where id= '" + id + "'");
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Produit p = new Produit();

            p.setId(rs.getInt(1));
            p.setDescription(rs.getString(2));
            p.setLibelle(rs.getString(3));
            p.setQuantite(rs.getInt(4));
            p.setQuantitemin(rs.getInt(5));

            System.out.println("no");
            return p;
        }
        return null;
    }

    public Produit getProduitBydesc(String desc) throws SQLException {
        String req = ("SELECT * FROM produit where description= '" + desc + "'");
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Produit p = new Produit();

            p.setId(rs.getInt(1));
            p.setDescription(rs.getString(2));
            p.setLibelle(rs.getString(3));
            p.setQuantite(rs.getInt(4));
            p.setQuantitemin(rs.getInt(5));

            System.out.println("no");
            return p;
        }
        return null;
    }

    public int getProduitIdBydesc(String description) throws SQLException {
        PreparedStatement pst = con.prepareStatement("SELECT id FROM produit where description=?");
        pst.setString(1, description);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int p = rs.getInt(1);
            return p;
        }
        return 0;

    }

    @Override
    public List<Produit> readAll() throws SQLException {
        List<Produit> arr = new ArrayList<>();

        String req = ("SELECT * FROM produit");
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);
        while (rs.next()) {
            Produit p = new Produit();

            p.setId(rs.getInt(1));
            p.setDescription(rs.getString(2));
            p.setLibelle(rs.getString(3));
            p.setQuantite(rs.getInt(4));
            p.setQuantitemin(rs.getInt(5));

            System.out.println("no");
            arr.add(p);
        }
        return arr;
    }

    @Override
    public boolean delete(Produit p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Produit p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> getTrier() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produit getById(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
