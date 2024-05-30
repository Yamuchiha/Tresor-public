/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Selection_Affectation;
import com.mysql.cj.jdbc.MysqlDataSource;
import entite.Affectation;
import entite.Departement;
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
public class AffectationDao {
    private static final String INSERT_AFFECTATION_SQL = "insert into concerner(Em_Id, Dep_Id, Annee_Aff) values(?,?,?)";
    
    private static final String SELECT_AFFECTATION_BY_ID = "select * from concerner inner join employer on concerner.Em_Id=employer.Em_Id inner join departement on concerner.Dep_Id = departement.Dep_Id where concerner.Conc_Id=?";
    
    private static final String SELECT_ALL_AFFECTATION = "select * from concerner inner join employer on concerner.Em_Id=employer.Em_Id inner join departement on concerner.Dep_Id = departement.Dep_Id inner join statu on employer.Statu_Id=statu.Sat_Id";
    
    private static final String DELETE_AFFECTATION = "delete from concerner where Conc_Id=?";
    
    private static final String UPDATE_AFFECTATION = "update concerner set Em_Id=?, Dep_Id=?, Annee_Aff=? where Conc_Id=?";
    
     public Connection seConnecter(){
        Connection conn = null;
        try {
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setServerName("localhost");
            datasource.setPort(3306);
            datasource.setDatabaseName("personnel");
            datasource.setUser("root");
            datasource.setPassword("");
            conn=datasource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
      
     
      public void insertAffectation(Affectation aff) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_AFFECTATION_SQL);
            pst.setInt(1, aff.getEm_id());
            pst.setInt(2, aff.getEm_dep());
            pst.setString(3, aff.getAnnee_Aff());
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
      
    public Affectation selectAffectation(int id) {
        Affectation aff = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_AFFECTATION_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int em_id = rs.getInt("concerner.Em_Id");
                int dep_id = rs.getInt("concerner.Dep_Id");
                String date = rs.getString("concerner.Annee_Aff");
                
                aff = new Affectation(id,em_id, dep_id, date);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AffectationDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aff;
    }
    
    
      public List<Selection_Affectation> selectAllAffectation() {
        List<Selection_Affectation> sel = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_AFFECTATION);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("concerner.Conc_Id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String fonction = rs.getString("employer.Fonction");
                String dep = rs.getString("departement.Dep_Nom");
                String annee = rs.getString("concerner.Annee_Aff");
                String statu = rs.getString("statu.Status");

                sel.add(new Selection_Affectation(id, nom, prenom, fonction, dep, annee, statu));
                //System.out.println(nom + " " + prenom + " " + fonction + " " + dep + " " + annee + " " + statu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sel;

    }
      
    
      public boolean updatAffectation(Affectation aff) throws SQLException {
        boolean ligneUpdat;
        Connection conn = seConnecter();

        PreparedStatement pst = conn.prepareStatement(UPDATE_AFFECTATION);
        pst.setInt(1, aff.getEm_id());
        pst.setInt(2, aff.getEm_dep());
        pst.setString(3, aff.getAnnee_Aff());
        pst.setInt(4, aff.getConc_id());
        

        ligneUpdat = pst.executeUpdate() > 0;

        conn.close();
        return ligneUpdat;

    }
      
      
       public boolean deletAffectation(int id) throws SQLException {
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_AFFECTATION);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;

        conn.close();
        return ligneDelet;
    }
     
       
       
    
    
}
