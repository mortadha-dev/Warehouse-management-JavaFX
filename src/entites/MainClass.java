/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author HP
 */
public class MainClass {
   static String url="jdbc:mysql://localhost:3306/pidev";
   static String login="root";
   static String mdp="";
    public static void main(String[] args) {
       try {
           Connection cnx =DriverManager.getConnection(url, login, mdp);
            System.out.println("connexion etablie");
       } catch (SQLException ex) {
           System.out.println(ex);
       }
    }
}
