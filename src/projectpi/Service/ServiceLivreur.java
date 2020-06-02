/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projectpi.entitys.Livreur;
import ProjectPi.connection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projectpi.views.LivreurController;

/**
 *
 * @author Mahdi
 */
public class ServiceLivreur implements ILivreur{
     private Connection cnx;

    public ServiceLivreur() {
      cnx =  MyConnection.getInstance().getCnx();
    }

   
    
     public List<Livreur> afficherAll()  {
        List<Livreur> listp = new ArrayList<>();

//     List <Livreur> listp =new ArrayList<>();
         Statement st;
        
        try {
            System.out.println("bonjour");
           
            String req = "SELECT * FROM livreure";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                Livreur l = new Livreur();
                l.setId(res.getInt(1));
                l.setNomliv(res.getString(2));
                l.setAdresseliv(res.getString(3));
                l.setNumtel(res.getInt(4));
                listp.add(l);
            }
            System.out.println(listp);

        } catch (SQLException ex) {

            System.out.println(ex);

        }
        return listp;

    }

    @Override
    public int ajout(Livreur l) {
        int id=5;
        try{
         String req = "INSERT INTO livreure (nomliv,adresseliv,numtel)VALUES (?,?,?)";
         PreparedStatement pre = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
         pre.setString(1,l.getNomliv());
          pre.setString(2,l.getAdresseliv());
          pre.setString(3, Integer.toString(l.getNumtel()));
          pre.executeUpdate();
          ResultSet tableKeys = pre.getGeneratedKeys();
                    tableKeys.next();
                     id = tableKeys.getInt(1);
         
        }

        catch (SQLException ex)
        {
             System.out.println(ex);             
        }
        return id;
    }
   
     
  
}
