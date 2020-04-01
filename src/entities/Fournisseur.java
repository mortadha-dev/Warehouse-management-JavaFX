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
public class Fournisseur {
    int id ;
    int code; 
    String nom;
    String prenom;
    String adresse_email;
    int telephone ;
    String ville ;
    String pays ;
    String rapidite;
    
    public Fournisseur (){
        
    }

    public Fournisseur( int code, String nom, String prenom, String adresse_email, int telephone, String ville, String pays,String rapidite) {
       
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_email = adresse_email;
        this.telephone = telephone;
        this.ville = ville;
        this.pays = pays;
        this.rapidite=rapidite;
    }
        public Fournisseur( int id , int code, String nom, String prenom, String adresse_email, int telephone, String ville, String pays,String rapidite) {
        this.id=id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_email = adresse_email;
        this.telephone = telephone;
        this.ville = ville;
        this.pays = pays;
        this.rapidite=rapidite;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getAdresse_email() {
        return adresse_email;
    }

    public void setAdresse_email(String adresse_email) {
        this.adresse_email = adresse_email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
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

    public String getRapidite() {
        return rapidite;
    }

    public void setRapidite(String rapidite) {
        this.rapidite = rapidite;
    }
    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", adresse_email=" + adresse_email + ", telephone=" + telephone + ", ville=" + ville + ", pays=" + pays + ", rapidite=" + rapidite + '}';
    }
}
