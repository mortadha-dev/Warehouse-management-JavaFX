/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectPi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mahdi
 */
public class MyConnection {
     String url = "jdbc:mysql://localhost:3306/dev++";
    String login = "root";
    String mdp = "";
    private static MyConnection instance;
    private Connection cnx;

    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, mdp);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

}
