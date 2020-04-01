/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import entities.Fournisseur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author admin
 */
public interface IServiceFournisseur {
        
    void ajouterFournisseur(Fournisseur f) throws SQLException;
    public void deleteFournisseur(int id) throws SQLException ;
   // void updateFournisseur(Fournisseur f ,int id) throws SQLException;
    List<Fournisseur> afficherFournisseur() throws SQLException;
    
    
    
}
