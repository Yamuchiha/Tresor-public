/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_Affectation {
    private int conc_id;
    private String nom;
    private String prenom;
    private String fonction;
    private String dep_nom;
    private String annee_aff;
    private String statu;

    public int getConc_id() {
        return conc_id;
    }

    public void setConc_id(int conc_id) {
        this.conc_id = conc_id;
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

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDep_nom() {
        return dep_nom;
    }

    public void setDep_nom(String dep_nom) {
        this.dep_nom = dep_nom;
    }

    public String getAnnee_aff() {
        return annee_aff;
    }

    public void setAnnee_aff(String annee_aff) {
        this.annee_aff = annee_aff;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Selection_Affectation(int conc_id, String nom, String prenom, String fonction, String dep_nom, String annee_aff, String statu) {
        this.conc_id = conc_id;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.dep_nom = dep_nom;
        this.annee_aff = annee_aff;
        this.statu = statu;
    }

    public Selection_Affectation(String nom, String prenom, String fonction, String dep_nom, String annee_aff, String statu) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.dep_nom = dep_nom;
        this.annee_aff = annee_aff;
        this.statu = statu;
    }
    
    
}
