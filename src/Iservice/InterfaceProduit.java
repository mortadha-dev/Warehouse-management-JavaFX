/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author baz info
 */
public interface InterfaceProduit<P> {
     void ajouter(P p) throws SQLException;
    boolean delete(P p) throws SQLException;
    boolean update(P p) throws SQLException;
    List<P> readAll() throws SQLException;
    List<P> getTrier()throws SQLException;
    P getById(P p);
}
