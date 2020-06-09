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
public class Reclamation {
    private int id;
    private Date date;
    private String description;
    private Boolean etat;
    private String type;
    private String tetat;
  
    public String getTetat() {
        return tetat;
    }

    public void setTetat(String tetat) {
        this.tetat = tetat;
    }
    private FOSUser idclient;
String emailuser;
String nomfournisseur ;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", date=" + date + ", description=" + description + ", etat=" + etat + ", type=" + type + ", tetat=" + tetat + ", emailuser=" + emailuser + ", idclient=" + idclient + ", nomfournisseur=" + nomfournisseur + '}';
    }

  
    
    public Reclamation() {
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Reclamation(Date date, String description, String type, FOSUser idclient) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.idclient = idclient;
    }

    public FOSUser getIdclient() {
        return idclient;
    }

    public void setIdclient(FOSUser idclient) {
        this.idclient = idclient;
    }

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public Reclamation(Date date, String description, String type,FOSUser idclient, String nomfournisseur) {
        this.date = date;
        this.description = description;
        this.type = type;
        this.idclient=idclient;
        this.nomfournisseur = nomfournisseur;
    }
public Reclamation(Date date, String description, String type,Boolean etat, String nomfournisseur) {
        this.date = date;
        this.description = description;
        this.type = type;
        
        this.nomfournisseur = nomfournisseur;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }


            
          public Reclamation(Date date, String description, Boolean etat,String type) {
        this.date = date;
        this.description = description;
        this.type = type;
    
     this.etat=etat;
    }


          
}
