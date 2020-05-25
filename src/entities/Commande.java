/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class Commande { 
    int produit_id;
    int id ;
    String libellecommande ;
    String descriptioncommande;
    int quantitecommande;
    float prixunitaire;
    float prixtotal;
    String date;
    String etat ;
    String nomfournisseur ;
    String nomproduit;
    Produit id_produit;
    Fournisseur id_fournisseur ;
    
    public Commande(){
        
    }
    
//     public Commande(String libellecommande){
//         this.libellecommande = libellecommande;
//        
//    }
      public Commande(String etat){
         this.etat = etat;
        
    }
      
      public Commande(float prixunitaire, float prixtotal) {
        ;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
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
        public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
        this.date = date;   

    }
      

    public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date, String etat,String nomfournisseur,String nomproduit ,int fournisseur_id, int produit_id) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.prixunitaire = prixunitaire;
        this.prixtotal = prixtotal;
        this.date = date;   
        this.etat = etat;
        this.nomfournisseur= nomfournisseur;
        this.fournisseur_id= fournisseur_id;
        this.produit_id=produit_id;
        this.nomproduit=nomproduit;
    }
    public Commande(String libellecommande, String descriptioncommande, int quantitecommande,String date,int fournisseur_id, int produit_id) {
        this.libellecommande = libellecommande;
        this.descriptioncommande = descriptioncommande;
        this.quantitecommande = quantitecommande;
        this.date = date;   
      
        this.fournisseur_id= fournisseur_id;
        this.produit_id=produit_id;
    }
     int fournisseur_id;

     public Commande(String libellecommande, String descriptioncommande, int quantitecommande, float prixunitaire, float prixtotal, String date, int fournisseur_id, int produit_id) {
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

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    public Produit getId_produit() {
        return id_produit;
    }

    public void setId_produit(Produit id_produit) {
        this.id_produit = id_produit;
    }

    public Fournisseur getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Fournisseur id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }
    
    
    
    
    
    

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", libellecommande=" + libellecommande + ", descriptioncommande=" + descriptioncommande + ", quantitecommande=" + quantitecommande + ", prixunitaire=" + prixunitaire + ", prixtotal=" + prixtotal + ", date=" + date + ", etat=" + etat + '}';
    }

           
    
}
