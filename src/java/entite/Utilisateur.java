/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Yami Sukehiro
 */
public class Utilisateur {
    private int user_id;
    private int em_id;
    private String role;
    private String pass;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Utilisateur(int user_id, int em_id, String role, String pass) {
        this.user_id = user_id;
        this.em_id = em_id;
        this.role = role;
        this.pass = pass;
    }

    public Utilisateur(int em_id, String role, String pass) {
        this.em_id = em_id;
        this.role = role;
        this.pass = pass;
    }
    
    

  

   
    
    
}
