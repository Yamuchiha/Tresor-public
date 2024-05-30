/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_User_Requete {
    private int dem_id;
    private String permission;
    private String status;
    private String motif;
    private String raison;
    private String date;

    public int getDem_id() {
        return dem_id;
    }

    public void setDem_id(int dem_id) {
        this.dem_id = dem_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Selection_User_Requete(int dem_id, String permission, String status, String motif, String raison, String date) {
        this.dem_id = dem_id;
        this.permission = permission;
        this.status = status;
        this.motif = motif;
        this.raison = raison;
        this.date = date;
    }
    
    
}
