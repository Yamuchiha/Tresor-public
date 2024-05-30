/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Selection_Utilisateur;
import Selection.Selection_Validation;
import Selection.Selection_Validation_Update;
import com.mysql.cj.jdbc.MysqlDataSource;
import entite.Departement;
import entite.Prendre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yami Sukehiro
 */
public class ValidationDao {
     private static final String SELECT_ALL_DEMANDE_ENCOUR = "select * from demander inner join employer on demander.Em_Id=employer.Em_Id inner join permission on demander.Per_id=permission.Per_id where demander.Dem_status='En cour'";
     private static final String SELECT_ALL_DEMANDE_VALIDE = "select * from demander inner join employer on demander.Em_Id=employer.Em_Id inner join permission on demander.Per_id=permission.Per_id where demander.Dem_status='Acceptee'";
     private static final String SELECT_ALL_DEMANDE_REFUSE = "select * from demander inner join employer on demander.Em_Id=employer.Em_Id inner join permission on demander.Per_id=permission.Per_id where demander.Dem_status='Refuse'";
     private static final String SELECT_DEMANDE_Update = "select * from demander where Dem_id=?";
     private static final String UPDATE_DEMANDE = "update demander set Dem_status=?, Raison=? where Dem_id=?";
    public Connection seConnecter() {
        Connection conn = null;
        try {
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setServerName("localhost");
            datasource.setPort(3306);
            datasource.setDatabaseName("personnel");
            datasource.setUser("root");
            datasource.setPassword("");
            conn = datasource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public List<Selection_Validation> selectAllDemandeEncour() {
        List<Selection_Validation> valis = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_DEMANDE_ENCOUR);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int dem_id = rs.getInt("demander.Dem_id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String permission = rs.getString("permission.Permission");
                String statu_per = rs.getString("demander.Dem_status");
                String date = rs.getString("demander.Date");
                
                valis.add(new Selection_Validation(dem_id, nom, prenom, permission, statu_per, date));
                //System.out.println(nom + " " + abr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valis;

    }
    
    
    
       public List<Selection_Validation> selectAllDemandeValide() {
        List<Selection_Validation> valis = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_DEMANDE_VALIDE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int dem_id = rs.getInt("demander.Dem_id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String permission = rs.getString("permission.Permission");
                String statu_per = rs.getString("demander.Dem_status");
                String date = rs.getString("demander.Date");

                valis.add(new Selection_Validation(dem_id, nom, prenom, permission, statu_per, date));
                //System.out.println(nom + " " + abr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valis;

    }
       
       
       
       public List<Selection_Validation> selectAllDemandeRefuse() {
        List<Selection_Validation> valis = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_DEMANDE_REFUSE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int dem_id = rs.getInt("demander.Dem_id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String permission = rs.getString("permission.Permission");
                String statu_per = rs.getString("demander.Dem_status");
                String date = rs.getString("demander.Date");

                valis.add(new Selection_Validation(dem_id, nom, prenom, permission, statu_per, date));
                //System.out.println(nom + " " + abr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valis;

    }
    
    public Selection_Validation_Update selectValidationUpdate(int id) {
        Selection_Validation_Update selVal = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_DEMANDE_Update);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int dem_id = rs.getInt("Dem_id");
                String dem_req_status = rs.getString("Dem_status");
                String raison = rs.getString("Raison");              
                selVal = new Selection_Validation_Update(dem_id, dem_req_status, raison);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ValidationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return selVal;
    }
    
    public boolean updatValidation(Selection_Validation_Update val) throws SQLException {
        boolean ligneUpdat;
        Connection conn = seConnecter();

        PreparedStatement pst = conn.prepareStatement(UPDATE_DEMANDE);
        pst.setString(1, val.getDem_req_status());
        pst.setString(2, val.getRaison());
        pst.setInt(3, val.getDem_id());
       

        ligneUpdat = pst.executeUpdate() > 0;

        conn.close();
        return ligneUpdat;

    }
}
