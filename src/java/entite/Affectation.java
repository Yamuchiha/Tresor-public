/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Yami Sukehiro
 */
public class Affectation {
    private int conc_id;
    private int em_id;
    private int em_dep;
    private String annee_Aff;

    public int getConc_id() {
        return conc_id;
    }

    public void setConc_id(int conc_id) {
        this.conc_id = conc_id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public int getEm_dep() {
        return em_dep;
    }

    public void setEm_dep(int em_dep) {
        this.em_dep = em_dep;
    }

    public String getAnnee_Aff() {
        return annee_Aff;
    }

    public void setAnnee_Aff(String annee_Aff) {
        this.annee_Aff = annee_Aff;
    }

    public Affectation(int conc_id, int em_id, int em_dep, String annee_Aff) {
        this.conc_id = conc_id;
        this.em_id = em_id;
        this.em_dep = em_dep;
        this.annee_Aff = annee_Aff;
    }

    public Affectation(int em_id, int em_dep, String annee_Aff) {
        this.em_id = em_id;
        this.em_dep = em_dep;
        this.annee_Aff = annee_Aff;
    }
    
    
}
