/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
/**
 *
 * @author admin
 */
public class Commande {
    int fournisseur_id;
    int produit_id;
    int id ;
    String libellecommande ;
    String descriptioncommande;
    int quantitecommande;
    float prixunitaire;
    float prixtotal;
    String date;
    String etat ;
    
    public Commande(){
        
    }
     public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date, String etat) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
        this.date = date;   
        this.etat = etat;
    }

    public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date, String etat, int fournisseur_id, int produit_id) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
        this.date = date;   
        this.etat = etat;
        this.fournisseur_id= fournisseur_id;
        this.produit_id=produit_id;
    }
    
     public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
        this.date = date;   
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellecommande() {
        return libellecommande;
    }

    public void setLibellecommande(String libellecommande) {
        this.libellecommande = libellecommande;
    }

    public String getDescriptioncommande() {
        return descriptioncommande;
    }

    public void setDescriptioncommande(String descriptioncommande) {
        this.descriptioncommande = descriptioncommande;
    }

    public int getQuantitecommande() {
        return quantitecommande;
    }

    public void setQuantitecommande(int quantitecommande) {
        this.quantitecommande = quantitecommande;
    }

    public float getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(float prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public float getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(float prixtotal) {
        this.prixtotal = prixtotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", libellecommande=" + libellecommande + ", descriptioncommande=" + descriptioncommande + ", quantitecommande=" + quantitecommande + ", prixunitaire=" + prixunitaire + ", prixtotal=" + prixtotal + ", date=" + date + ", etat=" + etat + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            
           
    
}
