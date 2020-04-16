/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author baz info
 */
public class Produit {
    private int id;
     private String description;
     private String libelle;
     private int quantite;
     private int quantitemin;
     private int supprimer;
     private String datesupp;

    public Produit(String description, String libelle, int quantite, int quantitemin, int supprimer, String datesupp) {
        this.description = description;
        this.libelle = libelle;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
        this.supprimer = supprimer;
        this.datesupp = datesupp;
    }

    public Produit(int id, String description, String libelle, int quantite, int quantitemin, int supprimer, String datesupp) {
        this.id = id;
        this.description = description;
        this.libelle = libelle;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
        this.supprimer = supprimer;
        this.datesupp = datesupp;
    }

    public Produit(String description, String libelle, int quantite, int quantitemin) {
        this.description = description;
        this.libelle = libelle;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
    }

    public Produit(int id, String description, int quantite, int quantitemin) {
        this.id = id;
        this.description = description;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantitemin() {
        return quantitemin;
    }

    public void setQuantitemin(int quantitemin) {
        this.quantitemin = quantitemin;
    }

    public int getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(int supprimer) {
        this.supprimer = supprimer;
    }

    public String getDatesupp() {
        return datesupp;
    }

    public void setDatesupp(String datesupp) {
        this.datesupp = datesupp;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", description=" + description + ", libelle=" + libelle + ", quantite=" + quantite + ", quantitemin=" + quantitemin + ", supprimer=" + supprimer + ", datesupp=" + datesupp + '}';
    }
}
