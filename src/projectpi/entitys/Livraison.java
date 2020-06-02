/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpi.entitys;

import java.time.LocalDate;
import java.util.Date;


/**
 *
 * @author Mahdi
 */
public class Livraison {
    
       public int id;
    public int livreure_id;
    public String ville;
    public String pays;
    public String adresse;
    public String etat;
    public String livreure;
    public String heurliv;
    public String commande;
    public String client;
    public LocalDate dateliv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivreure_id() {
        return livreure_id;
    }

    public void setLivreure_id(int livreure_id) {
        this.livreure_id = livreure_id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getHeurliv() {
        return heurliv;
    }

    public void setHeurliv(String heurliv) {
        this.heurliv = heurliv;
    }

    public String getCommande() {
        return commande;
    }

    public Livraison() {
    }

    public Livraison(int id, int livreure_id, String ville, String pays, String adresse, String etat, String heurliv, String commande, String client, LocalDate dateliv, String livreure) {
        this.id = id;
        this.livreure_id = livreure_id;
        this.ville = ville;
        this.pays = pays;
        this.adresse = adresse;
        this.etat = etat;
        this.heurliv = heurliv;
        this.commande = commande;
        this.client = client;
        this.dateliv = dateliv;
        this.livreure = livreure;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDateliv() {
        return dateliv;
    }

    public void setDateliv(LocalDate dateliv) {
        this.dateliv = dateliv;
    }

    public String getLivreure() {
        return livreure;
    }

    public void setLivreure(String livreure) {
        this.livreure = livreure;
    }
    
    
}
