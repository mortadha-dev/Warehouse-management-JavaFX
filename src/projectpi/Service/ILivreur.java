/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.Service;

import java.util.List;
import projectpi.entitys.Livreur;

/**
 *
 * @author Mahdi
 */
public interface ILivreur {
     public List<Livreur> afficherAll();
     public int ajout (Livreur l);
     
}
