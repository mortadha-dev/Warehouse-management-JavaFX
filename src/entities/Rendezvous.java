/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author derba
 */
public class Rendezvous {
    private int id;
    private String desrition;
    private Date date;
    private FOSUser idcl;
    private Date dateenvoi;
String nomfournisseur ;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesrition() {
        return desrition;
    }

    public void setDesrition(String desrition) {
        this.desrition = desrition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    public Date getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(Date dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public FOSUser getIdcl() {
        return idcl;
    }

    public void setIdcl(FOSUser idcl) {
        this.idcl = idcl;
    }

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public Rendezvous(int id, String desrition, Date date, FOSUser idcl, Date dateenvoi, String nomfournisseur) {
        this.id = id;
        this.desrition = desrition;
        this.date = date;
        this.idcl = idcl;
        this.dateenvoi = dateenvoi;
        this.nomfournisseur = nomfournisseur;
    }

   
    public Rendezvous() {
    }

    public Rendezvous(String desrition, Date date, Date dateenvoi) {
        this.desrition = desrition;
        this.date = date;
     
        this.dateenvoi = dateenvoi;
    }

    public Rendezvous(String desrition,  Date dateenvoi) {
        this.desrition = desrition;
        
        this.dateenvoi = dateenvoi;
   
    }

    @Override
    public String toString() {
        return "Rendezvous{" + "id=" + id + ", desrition=" + desrition + ", date=" + date + ", idcl=" + idcl + ", dateenvoi=" + dateenvoi + ", nomfournisseur=" + nomfournisseur + '}';
    }
    
    
    
}
