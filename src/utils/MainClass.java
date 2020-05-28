/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author HP
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection cnx1= MyConnection.getInstance();
        MyConnection cnx2= MyConnection.getInstance();
        
        System.out.println(cnx1.hashCode()+" "+cnx2.hashCode());
    }
}
