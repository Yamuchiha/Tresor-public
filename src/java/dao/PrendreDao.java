/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Selection_Prendre;
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
public class PrendreDao {
    private static final String INSERT_PRENDRE_SQL = "insert into prendre(Em_Id, Conge_Id, Date_depart, Date_retour, Motif_conge) values(?,?,?,?,?)";
    
    private static final String SELECT_PRENDRE_BY_ID = "select * from prendre inner join employer on prendre.Em_Id=employer.Em_Id inner join conge on prendre.Conge_Id=conge.Conge_Id where prendre.Pren_Id=?";
    
    private static final String SELECT_ALL_PRENDRE = "select * from prendre inner join employer on prendre.Em_Id=employer.Em_Id inner join conge on prendre.Conge_Id=conge.Conge_Id inner join statu on statu.Sat_Id=employer.Statu_Id ";
    
    private static final String DELETE_PRENDRE = "delete from prendre where Pren_Id=?";
    
    private static final String UPDATE_PRENDRE = "update prendre set Em_Id=?, Conge_Id=?, Date_depart=?, Date_retour=?, Motif_conge =? where Pren_Id=?";
    
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
    
    public void insertPrendre(Prendre pre) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_PRENDRE_SQL);
            pst.setInt(1, pre.getEm_id());
            pst.setInt(2, pre.getConge_id());
            pst.setString(3, pre.getDate_depart());
            pst.setString(4, pre.getDate_retour());
            pst.setString(5, pre.getMotif());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    
    public Prendre selectPrendre(int id) {
        Prendre pre = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_PRENDRE_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int em_id = rs.getInt("prendre.Em_Id");
                int conge_id = rs.getInt("prendre.Conge_Id");
                String date_depart = rs.getString("prendre.Date_depart");
                String date_retour= rs.getString("prendre.Date_retour");
                String motif = rs.getString("prendre.Motif_conge");
                pre = new Prendre(id, em_id, conge_id, date_depart, date_retour, motif);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrendreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pre;
    }
    
    public List<Selection_Prendre> selectAllPrendre() {
        List<Selection_Prendre> pres = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_PRENDRE);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("prendre.Pren_Id");
                int em_id = rs.getInt("prendre.Em_Id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String conge = rs.getString("conge.Group_cong");
                String date_depart = rs.getString("prendre.Date_depart");
                String date_retour = rs.getString("prendre.Date_retour");
                String statu = rs.getString("statu.Status");

                pres.add(new Selection_Prendre(id, em_id, nom, prenom, conge, date_depart, date_retour, statu));
                //System.out.println(nom + " " + abr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrendreDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pres;

    }
    
    public boolean updatPrendre(Prendre pre) throws SQLException {
        boolean ligneUpdat;
        Connection conn = seConnecter();

        PreparedStatement pst = conn.prepareStatement(UPDATE_PRENDRE);
        pst.setInt(1, pre.getEm_id());
        pst.setInt(2, pre.getConge_id());
        pst.setString(3, pre.getDate_depart());
        pst.setString(4, pre.getDate_retour());
        pst.setString(5, pre.getMotif());
        pst.setInt(6, pre.getPren_id());

        ligneUpdat = pst.executeUpdate() > 0;

        conn.close();
        return ligneUpdat;

    }
    
    public boolean deletPrendre(int id) throws SQLException {
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_PRENDRE);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;

        conn.close();
        return ligneDelet;
    }
}
