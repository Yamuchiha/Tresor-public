/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Yami Sukehiro
 */
public class Prendre {
    private int pren_id;
    private int em_id;
    private int conge_id;
    private String date_depart;
    private String date_retour;
    private String motif;

    public int getPren_id() {
        return pren_id;
    }

    public void setPren_id(int pren_id) {
        this.pren_id = pren_id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public int getConge_id() {
        return conge_id;
    }

    public void setConge_id(int conge_id) {
        this.conge_id = conge_id;
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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Prendre(int pren_id, int em_id, int conge_id, String date_depart, String date_retour, String motif) {
        this.pren_id = pren_id;
        this.em_id = em_id;
        this.conge_id = conge_id;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.motif = motif;
    }

    public Prendre(int em_id, int conge_id, String date_depart, String date_retour, String motif) {
        this.em_id = em_id;
        this.conge_id = conge_id;
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.motif = motif;
    }
    
    
}
