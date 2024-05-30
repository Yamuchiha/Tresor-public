/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_Prendre {
    private int pre_id;
    private int em_id;
    private String nom;
    private String prenom;
    private String conge;
    private String date_depart;
    private String date_retour;
    private String statu;

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
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

    public String getConge() {
        return conge;
    }

    public void setConge(String conge) {
        this.conge = conge;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

   

    public Selection_Prendre(int pre_id, int em_id, String nom, String prenom, String conge, String date_depart, String date_retour) {
        this.pre_id = pre_id;
        this.em_id = em_id;
        this.nom = nom;
        this.prenom = prenom;
        this.conge = conge;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
    }

    public Selection_Prendre(int em_id, String nom, String prenom, String conge, String date_depart, String date_retour) {
        this.em_id = em_id;
        this.nom = nom;
        this.prenom = prenom;
        this.conge = conge;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
    }

    public Selection_Prendre(int pre_id, int em_id, String nom, String prenom, String conge, String date_depart, String date_retour, String statu) {
        this.pre_id = pre_id;
        this.em_id = em_id;
        this.nom = nom;
        this.prenom = prenom;
        this.conge = conge;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.statu = statu;
    }

    public Selection_Prendre(int em_id, String nom, String prenom, String conge, String date_depart, String date_retour, String statu) {
        this.em_id = em_id;
        this.nom = nom;
        this.prenom = prenom;
        this.conge = conge;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.statu = statu;
    }
    
    
    
    
}
