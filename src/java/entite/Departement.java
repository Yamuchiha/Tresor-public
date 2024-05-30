/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Yami Sukehiro
 */
public class Departement {
    private int dep_id;
    private String dep_nom;
    private String dep_abr;
    private String dep_date;
    private int dep_id_par;
    private int type_id;
    private String type_nom;

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_nom() {
        return dep_nom;
    }

    public void setDep_nom(String dep_nom) {
        this.dep_nom = dep_nom;
    }

    public String getDep_abr() {
        return dep_abr;
    }

    public void setDep_abr(String dep_abr) {
        this.dep_abr = dep_abr;
    }

    public String getDep_date() {
        return dep_date;
    }

    public void setDep_date(String dep_date) {
        this.dep_date = dep_date;
    }

    public int getDep_id_par() {
        return dep_id_par;
    }

    public void setDep_id_par(int dep_id_par) {
        this.dep_id_par = dep_id_par;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_nom() {
        return type_nom;
    }

    public void setType_nom(String type_nom) {
        this.type_nom = type_nom;
    }
    

    public Departement(String dep_nom, String dep_abr, String dep_date, int dep_id_par, int type_id) {
        this.dep_nom = dep_nom;
        this.dep_abr = dep_abr;
        this.dep_date = dep_date;
        this.dep_id_par = dep_id_par;
        this.type_id = type_id;
    }

    public Departement(int dep_id, String dep_nom, String dep_abr, String dep_date, int dep_id_par, int type_id) {
        this.dep_id = dep_id;
        this.dep_nom = dep_nom;
        this.dep_abr = dep_abr;
        this.dep_date = dep_date;
        this.dep_id_par = dep_id_par;
        this.type_id = type_id;
    }

    public Departement(int dep_id, String dep_nom, String dep_abr, String dep_date, int dep_id_par, String type_nom) {
        this.dep_id = dep_id;
        this.dep_nom = dep_nom;
        this.dep_abr = dep_abr;
        this.dep_date = dep_date;
        this.dep_id_par = dep_id_par;
        this.type_nom = type_nom;
    }
    
    
    
}
