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
public interface InterfaceEntrepot<E> {
     void ajouter(E e) throws SQLException;
    boolean delete(E e) throws SQLException;
    boolean update(E e) throws SQLException;
    List<E> readAll() throws SQLException;
    List<E> getTrier()throws SQLException;
    E getById(E e);
}
