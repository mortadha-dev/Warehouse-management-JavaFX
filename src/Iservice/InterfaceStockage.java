/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import entities.Stockage;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author baz info
 */
public interface InterfaceStockage {
    void ajouter(Stockage s,int entrepot, int produit) throws SQLException;
    public boolean delete(int id)throws SQLException;
    public void update(Stockage s,int entrepot, int produit) throws SQLException;
   // List<S> readAll() throws SQLException;
   // List<S> getTrier()throws SQLException;
   // S getById(S s);
}
