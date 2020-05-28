/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Employe {
    private int idE;
    private String nom;
    private String prenom;
    private String numtel;
//    private String adresse;
    private String cin;
    private String email;
    
//    public Employe(String nom ,String prenom, String numtel, String adresse){
//        this.nom= nom;
//        this.prenom = prenom;
//        this.numtel=numtel;
//        this.adresse= adresse;
//    }

    public Employe(String nom, String prenom, String numtel, String cin, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.cin = cin;
        this.email = email;
    }

    public Employe(int idE, String nom, String prenom, String numtel, String cin, String email) {
        this.idE = idE;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.cin = cin;
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//    public Employe(int idE, String nom, String prenom, String numtel, String adresse) {
//        this.idE = idE;
//        this.nom = nom;
//        this.prenom = prenom;
//        this.numtel = numtel;
//        this.adresse = adresse;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employe other = (Employe) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        return true;
    }
   

    public Employe() {
    }

//    @Override
//    public String toString() {
//        return "Employe{" + "idE=" + idE + ", nom=" + nom + ", prenom=" + prenom + ", numtel=" + numtel + ", adresse=" + adresse + '}';
//    }
//    

    @Override
    public String toString() {
        return "Employe{" + "idE=" + idE + ", nom=" + nom + ", prenom=" + prenom + ", numtel=" + numtel + ", cin=" + cin + ", email=" + email + '}';
    }
    
    
}
