/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.AllDemande;
import Selection.Employer_Retour_Id;
import Selection.Selection_User_Requete;
import com.mysql.cj.jdbc.MysqlDataSource;
import entite.Demander;
import entite.Departement;
import entite.Employer;
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
public class DemanderDao {
        private static final String INSERT_DEMANDER_SQL = "insert into demander(Em_Id, Per_id, Dem_motif) values(?,?,?)";
    
    private static final String SELECT_DEMANDER_BY_ID = "select * from demander inner join permission on demander.Per_id = permission.Per_id where demander.Em_Id=?";
    
    private static final String SELECT_DEMANDER = "select * from demander where Dem_id=?";
    
    private static final String SELECT_DEMANDER_DETAIL = "select * from demander inner join permission on demander.Per_id=permission.Per_id where demander.Dem_id=?";
    
    private static final String DELETE_DEMANDER = "delete from demander where Dem_id =?";
    
    private static final String UPDATE_DEMANDER = "update demander set Em_Id=?, Per_id=?, Dem_motif=? where Dem_id=?";
    
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
    
    public void insertDepartement(Demander dem) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_DEMANDER_SQL);
            pst.setInt(1, dem.getEm_id());
            pst.setInt(2, dem.getPer_id());
            pst.setString(3, dem.getDem_motif());
            
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DemanderDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    public List<Selection_User_Requete> selectAllUserRequete(int id) {
        List<Selection_User_Requete> userRequets = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_DEMANDER_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int dem_id = rs.getInt("demander.Dem_id");
                String permission = rs.getString("permission.Permission");
                String status = rs.getString("demander.Dem_status");
                String motif = rs.getString("demander.Dem_motif");
                String raison = rs.getString("demander.Raison");
                String date = rs.getString("demander.Date");

               userRequets.add(new Selection_User_Requete(dem_id, permission, status, motif, raison, date));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DemanderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userRequets;
    }
    
    public boolean deletDemande(int id) throws SQLException {
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_DEMANDER);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;

        conn.close();
        return ligneDelet;
    }
    
    public Demander selectDemander(int id) {
        Demander dem = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_DEMANDER);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int dem_id = rs.getInt("Dem_id");
                int em_id = rs.getInt("Em_Id");
                int per_id = rs.getInt("Per_id");
                String dem_motif = rs.getString("Dem_motif");
                dem = new Demander(dem_id, em_id, per_id, dem_motif);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DemanderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dem;
    }
    
    public AllDemande selectDetatilDemander(int id) {
        AllDemande alldem = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_DEMANDER_DETAIL);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int dem_id = rs.getInt("demander.Dem_id");
                int em_id = rs.getInt("demander.Em_Id");
                int per_id = rs.getInt("demander.Per_id");
                String dem_status = rs.getString("demander.Dem_status");
                String dem_motif = rs.getString("demander.Dem_motif");
                String raison = rs.getString("demander.Raison");
                String date = rs.getString("demander.Date");
                String permission = rs.getString("permission.Permission");
                alldem = new AllDemande(dem_id, em_id, per_id, dem_status, dem_motif, raison, date, permission);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DemanderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alldem;
    }

    public boolean updatDemande(Demander dem) throws SQLException {
        boolean ligneUpdat;
        Connection conn = seConnecter();

        PreparedStatement pst = conn.prepareStatement(UPDATE_DEMANDER);
        pst.setInt(1, dem.getEm_id());
        pst.setInt(2, dem.getPer_id());
        pst.setString(3, dem.getDem_motif());
        pst.setInt(4, dem.getDem_id());
        
        ligneUpdat = pst.executeUpdate() > 0;

        conn.close();
        return ligneUpdat;

    }
    
    
}
