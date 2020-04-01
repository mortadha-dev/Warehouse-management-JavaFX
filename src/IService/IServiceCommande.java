/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import entities.Commande;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IServiceCommande {
    
    void ajouterCommande(Commande c) throws SQLException;
    public void deleteCommande(int id) throws SQLException ;
    void updateCommande(Commande c ,int id) throws SQLException;
    List<Commande> afficherCommande() throws SQLException;
    
    
    
}
