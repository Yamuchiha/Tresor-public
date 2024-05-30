/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class AllDemande {
    private int dem_id;
    private int em_id;
    private int per_id;
    private String dem_status;
    private String dem_motif;
    private String raison;
    private String date;
    private String permission;

    public int getDem_id() {
        return dem_id;
    }

    public void setDem_id(int dem_id) {
        this.dem_id = dem_id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public String getDem_status() {
        return dem_status;
    }

    public void setDem_status(String dem_status) {
        this.dem_status = dem_status;
    }

    public String getDem_motif() {
        return dem_motif;
    }

    public void setDem_motif(String dem_motif) {
        this.dem_motif = dem_motif;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public AllDemande(int dem_id, int em_id, int per_id, String dem_status, String dem_motif, String raison, String date, String permission) {
        this.dem_id = dem_id;
        this.em_id = em_id;
        this.per_id = per_id;
        this.dem_status = dem_status;
        this.dem_motif = dem_motif;
        this.raison = raison;
        this.date = date;
        this.permission = permission;
    }

    public AllDemande(int em_id, int per_id, String dem_status, String dem_motif, String raison, String date, String permission) {
        this.em_id = em_id;
        this.per_id = per_id;
        this.dem_status = dem_status;
        this.dem_motif = dem_motif;
        this.raison = raison;
        this.date = date;
        this.permission = permission;
    }

    
    
    
}
