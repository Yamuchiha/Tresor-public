/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_Validation {
    private int dem_id;
    private String nom;
    private String prenom;
    private String permission;
    private String statu_per;
    private String date;

    public int getDem_id() {
        return dem_id;
    }

    public void setDem_id(int dem_id) {
        this.dem_id = dem_id;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getStatu_per() {
        return statu_per;
    }

    public void setStatu_per(String statu_per) {
        this.statu_per = statu_per;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Selection_Validation(int dem_id, String nom, String prenom, String permission, String statu_per, String date) {
        this.dem_id = dem_id;
        this.nom = nom;
        this.prenom = prenom;
        this.permission = permission;
        this.statu_per = statu_per;
        this.date = date;
    }
    
    
}
