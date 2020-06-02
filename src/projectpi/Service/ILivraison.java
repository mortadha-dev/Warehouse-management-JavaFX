/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.Service;

import java.util.List;
import javafx.collections.ObservableList;
import projectpi.entitys.Livraison;



/**
 *
 * @author Mahdi
 */
public interface ILivraison {
    
     public List<Livraison> afficherAll();
     public int ajout (Livraison l);
      public ObservableList<String> getNonLiv();
     
    
}
