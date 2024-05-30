/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Yami Sukehiro
 */
public class Employer {
    private int id;
    private String nom;
    private String prenom;
    private String date_naiss;
    private String etat_civil;
    private String adresse;
    private String contact;
    private String email;
    private String sexe;
    private String date_eng;
    private String fonction;
    private int statu_id;
    private String motif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getEtat_civil() {
        return etat_civil;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDate_eng() {
        return date_eng;
    }

    public void setDate_eng(String date_eng) {
        this.date_eng = date_eng;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getStatu_id() {
        return statu_id;
    }

    public void setStatu_id(int statu_id) {
        this.statu_id = statu_id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Employer(int id, String nom, String prenom, String date_naiss, String etat_civil, String adresse, String contact, String email, String sexe, String date_eng, String fonction, int statu_id, String motif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.etat_civil = etat_civil;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
        this.sexe = sexe;
        this.date_eng = date_eng;
        this.fonction = fonction;
        this.statu_id = statu_id;
        this.motif = motif;
    }

    public Employer(String nom, String prenom, String date_naiss, String etat_civil, String adresse, String contact, String email, String sexe, String date_eng, String fonction, int statu_id, String motif) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.etat_civil = etat_civil;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
        this.sexe = sexe;
        this.date_eng = date_eng;
        this.fonction = fonction;
        this.statu_id = statu_id;
        this.motif = motif;
    }
    
}
