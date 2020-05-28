/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author HP
 */
public class Conge {
   private int idconge;
    private int duree,etat;
    private String raison;
//    public String etat; 
    private String datedebut,datefin; 

    public Conge(String raison, String datedebut, String datefin) {
        this.raison = raison;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    
    
    public int getIdconge() {
        return idconge;
    }

    public void setIdconge(int idconge) {
        this.idconge = idconge;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

//    public String getEtat() {
//        return etat;
//    }
//
//    public void setEtat(String etat) {
//        this.etat = etat;
//    }

    public Conge(int idconge, int duree, String raison, String etat) {
        this.idconge = idconge;
        this.duree = duree;
        this.raison = raison;
//        this.etat = etat;
    }

    public Conge() {
    }

    @Override
    public String toString() {
        return "Conge{" + "idconge=" + idconge + ", duree=" + duree + ", raison=" + raison + ", etat=" + etat + '}';
    }
    
    
}
