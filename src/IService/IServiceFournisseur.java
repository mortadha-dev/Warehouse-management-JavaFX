/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import entities.Fournisseur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IServiceFournisseur {
    public void ajouterFournisseur(Fournisseur p ) throws SQLException;
    public List<Fournisseur> afficherFournisseur()throws SQLException ;
    public void updateFournisseur(Fournisseur f ,int id);
    public void deleteFournisseur(int code);
    
}
