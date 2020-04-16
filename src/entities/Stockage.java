 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author baz info
 */
public class Stockage {
 private int id;
 private Entrepot entrepot;
 private String nomEntrepot;
 private Produit produit;
 private String nomProduit;
 private int quantite;
 private String datedestockage;

    public Stockage(int id, Entrepot entrepot, Produit produit, int quantite, String datedestockage) {
        this.id = id;
        this.entrepot = entrepot;
        this.produit = produit;
        this.quantite = quantite;
        this.datedestockage = datedestockage;
    }

    public Stockage(int id, String nomEntrepot, String nomProduit, int quantite, String datedestockage) {
        this.id = id;
        this.nomEntrepot = nomEntrepot;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.datedestockage = datedestockage;
    }

    public Stockage(Entrepot entrepot, Produit produit, int quantite, String datedestockage) {
        this.entrepot = entrepot;
        this.produit = produit;
        this.quantite = quantite;
        this.datedestockage = datedestockage;
    }

    public Stockage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDatedestockage() {
        return datedestockage;
    }

    public void setDatedestockage(String datedestockage) {
        this.datedestockage = datedestockage;
    }

    public String getNomEntrepot() {
        return nomEntrepot;
    }

    public void setNomEntrepot(String nomEntrepot) {
        this.nomEntrepot = nomEntrepot;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    

    @Override
    public String toString() {
        return "stockage{" + "id=" + id + ", entrepot=" + entrepot + ", produit=" + produit + ", quantite=" + quantite + ", datedestockage=" + datedestockage + '}';
    }
}
