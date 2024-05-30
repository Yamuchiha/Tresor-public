/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_User {
    private int us_id;
    private String us_nom;
    private String us_prenom;
    private String us_role;

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public String getUs_nom() {
        return us_nom;
    }

    public void setUs_nom(String us_nom) {
        this.us_nom = us_nom;
    }

    public String getUs_prenom() {
        return us_prenom;
    }

    public void setUs_prenom(String us_prenom) {
        this.us_prenom = us_prenom;
    }

    public String getUs_role() {
        return us_role;
    }

    public void setUs_role(String us_role) {
        this.us_role = us_role;
    }

    public Selection_User(int us_id, String us_nom, String us_prenom, String us_role) {
        this.us_id = us_id;
        this.us_nom = us_nom;
        this.us_prenom = us_prenom;
        this.us_role = us_role;
    }

    public Selection_User(String us_nom, String us_prenom, String us_role) {
        this.us_nom = us_nom;
        this.us_prenom = us_prenom;
        this.us_role = us_role;
    }
    
    
}
