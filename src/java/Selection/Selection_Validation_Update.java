/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Selection;

/**
 *
 * @author Yami Sukehiro
 */
public class Selection_Validation_Update {
    private int dem_id;
    private String dem_req_status;
    private String raison;

    public int getDem_id() {
        return dem_id;
    }

    public void setDem_id(int dem_id) {
        this.dem_id = dem_id;
    }

    public String getDem_req_status() {
        return dem_req_status;
    }

    public void setDem_req_status(String dem_req_status) {
        this.dem_req_status = dem_req_status;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Selection_Validation_Update(int dem_id, String dem_req_status, String raison) {
        this.dem_id = dem_id;
        this.dem_req_status = dem_req_status;
        this.raison = raison;
    }
    
    
}
