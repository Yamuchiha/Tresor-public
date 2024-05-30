/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_Utilisateur {
    private int user_id;
    private String nom;
    private String prenom;
    private String role;
    private String email;
    private String departement;
    private String fonction;
    private String status;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Selection_Utilisateur(int user_id, String nom, String prenom, String role, String email, String departement, String fonction, String status) {
        this.user_id = user_id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.departement = departement;
        this.fonction = fonction;
        this.status = status;
    }

    public Selection_Utilisateur(String nom, String prenom, String role, String email, String departement, String fonction, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
        this.departement = departement;
        this.fonction = fonction;
        this.status = status;
    }
    
    
    
}
