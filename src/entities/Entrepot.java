/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author tayssir
 */
public class Entrepot {
    private int id;
    private String nomcourtlieu;
    private String description;
    private String adress;
    private String codepostale;
    private String ville;
    private String pays;
    private int stockphysique;

    public Entrepot(int id, String nomcourtlieu, String description, String adress, String codepostale, String ville, String pays, int stockphysique) {
        this.id = id;
        this.nomcourtlieu = nomcourtlieu;
        this.description = description;
        this.adress = adress;
        this.codepostale = codepostale;
        this.ville = ville;
        this.pays = pays;
        this.stockphysique = stockphysique;
    }

    @Override
    public String toString() {
        return "Entrepot{" + "id=" + id + ", nomcourtlieu=" + nomcourtlieu + ", description=" + description + ", adress=" + adress + ", codepostale=" + codepostale + ", ville=" + ville + ", pays=" + pays + ", stockphysique=" + stockphysique + '}';
    }

    public Entrepot() {
    }

    public Entrepot(String nomcourtlieu, String description, String adress, String codepostale, String ville, String pays, int stockphysique) {
        this.nomcourtlieu = nomcourtlieu;
        this.description = description;
        this.adress = adress;
        this.codepostale = codepostale;
        this.ville = ville;
        this.pays = pays;
        this.stockphysique = stockphysique;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcourtlieu() {
        return nomcourtlieu;
    }

    public void setNomcourtlieu(String nomcourtlieu) {
        this.nomcourtlieu = nomcourtlieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCodepostale() {
        return codepostale;
    }

    public void setCodepostale(String codepostale) {
        this.codepostale = codepostale;
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

    public int getStockphysique() {
        return stockphysique;
    }

    public void setStockphysique(int stockphysique) {
        this.stockphysique = stockphysique;
    }
}
