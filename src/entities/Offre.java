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
public class Offre {
    int id ;
    int CodeOffre;
    String NomProduit;
    int AncienPrix;
    int NouveauPrix;
    String delaivalidite;
    float reduction ; 
     int produit_id;
    
    public Offre(){
        
    }

    public Offre(int id ,int CodeOffre , String NomProduit, int AncienPrix, int NouveauPrix, String delaivalidite,float reduction) {
       this.id=id ;
        this.CodeOffre= CodeOffre;
        this.NomProduit = NomProduit;
        this.AncienPrix = AncienPrix;
        this.NouveauPrix = NouveauPrix;
        this.delaivalidite = delaivalidite;
        this.reduction=reduction ;
    }
     public Offre(int CodeOffre ,int produit_id , int AncienPrix, int NouveauPrix, String delaivalidite) {
        this.CodeOffre= CodeOffre;
        this.AncienPrix = AncienPrix;
        this.NouveauPrix = NouveauPrix;
        this.delaivalidite = delaivalidite;
        this.produit_id=produit_id;
      
    }
      public Offre(String NomProduit, int AncienPrix, int NouveauPrix, String delaivalidite ,int CodeOffre ,float reduction , int produit_id) {
       this.NomProduit=NomProduit;
        this.CodeOffre= CodeOffre;
        this.AncienPrix = AncienPrix;
        this.NouveauPrix = NouveauPrix;
        this.delaivalidite = delaivalidite;
        this.reduction=reduction;
        this.produit_id=produit_id;
        
      }
       public Offre(int CodeOffre, int AncienPrix, int NouveauPrix, String delaivalidite, float reduction  ) {
      
        this.CodeOffre= CodeOffre;
        this.AncienPrix = AncienPrix;
        this.NouveauPrix = NouveauPrix;
        this.delaivalidite = delaivalidite;
        this.reduction=reduction;
        
      }
  
           
           
           
       
      
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return NomProduit;
    }

    public void setNomProduit(String NomProduit) {
        this.NomProduit = NomProduit;
    }

    public int getAncienPrix() {
        return AncienPrix;
    }

    public void setAnciePrix(int AnciePrix) {
        this.AncienPrix = AnciePrix;
    }

    public int getNouveauPrix() {
        return NouveauPrix;
    }

    public void setNouveauPrix(int NouveauPrix) {
        this.NouveauPrix = NouveauPrix;
    }

    public String getDelaivalidite() {
        return delaivalidite;
    }

    public void setDelaivalidite(String delaivalidite) {
        this.delaivalidite = delaivalidite;
    }


    public int getCodeOffre() {
        return CodeOffre;
    }

    public void setCodeOffre(int CodeOffre) {
        this.CodeOffre = CodeOffre;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
