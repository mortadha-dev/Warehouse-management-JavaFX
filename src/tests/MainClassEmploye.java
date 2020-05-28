/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import entites.Conge;
import entites.Employe;

import services.CongeServices;
import services.EmployeServices;
import utils.MyConnection;
/**
 *
 * @author HP
 */
public class MainClassEmploye {
    
    public static void main(String[] args) {
        
//        MyConnection cnx1 = MyConnection.getInstance();
//        MyConnection cnx2 = MyConnection.getInstance();
//        
//        System.out.println(cnx1.hashCode()+ " " +cnx2.hashCode());

        EmployeServices es = new EmployeServices();
        
        Employe e = new Employe(0, "belhaj", "chaima", "21456789" ,"Sousse","hhhh");
       
        
        es.ajouteremploye(e);
        
        es.afficherAll();
        
        
            
        EmployeServices Es = new EmployeServices();
        Employe ee = new Employe();
        
        ee.setNom("amin");
        ee.setPrenom("youssef");
        ee.setNumtel("95692321");
        ee.setCin("07896325");
        ee.setEmail("amin@gmail.com");
//         Es.updateEmploye(ee, 1); 
//         Es.deleteEmploye(ee);
          
            
}
}
