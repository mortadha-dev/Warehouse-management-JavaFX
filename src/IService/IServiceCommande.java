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
public void ajouterCommande(Commande c) throws SQLException;
public List<Commande> afficherCommande() throws SQLException ;
public void updateCommande(Commande c, int id);
public void deleteCommande(int quantitecommande) throws SQLException ;   
}
