/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Employer_Retour_Id;
import com.mysql.cj.jdbc.MysqlDataSource;
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
public class DepartementDao {
        
    private static final String INSERT_DEPARTEMENT_SQL = "insert into departement(Dep_Nom, Dep_Abr, Dep_date, Dep_Id_Par, Type_Id) values(?,?,?,?,?)";
    
    private static final String SELECT_DEPARTEMENT_BY_ID = "select * from departement inner join type on departement.Type_Id=type.Type_Id where departement.Dep_Id=?";
    
    private static final String SELECT_ALL_DEPARTEMENT = "select * from departement inner join type on departement.Type_Id=type.Type_Id";
    
    private static final String DELETE_DEPARTEMENT = "delete from departement where Dep_Id=?";
    
    private static final String UPDATE_DEPARTEMENT = "update departement set Dep_Nom=?, Dep_Abr=?, Dep_date=?, Dep_Id_Par=?, Type_Id=? where Dep_Id=?";
    
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
      
    public void insertDepartement(Departement dep) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_DEPARTEMENT_SQL);
            pst.setString(1, dep.getDep_nom());
            pst.setString(2, dep.getDep_abr());
            pst.setString(3, dep.getDep_date());
            pst.setInt(4, dep.getDep_id_par());
            pst.setInt(5, dep.getType_id());
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
    
    public Departement selectDepartement(int id) {
        Departement dep = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_DEPARTEMENT_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("departement.Dep_Nom");
                String abr = rs.getString("departement.Dep_Abr");
                String date = rs.getString("departement.Dep_date");
                int dep_id_par = rs.getInt("departement.Dep_Id_Par");
                int type_id = rs.getInt("departement.Type_Id");
                dep = new Departement(id,nom, abr, date, dep_id_par, type_id);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartementDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dep;
    }
    
      public List<Departement> selectAllEmployer() {
        List<Departement> deps = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_DEPARTEMENT);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("departement.Dep_Id");
                String nom = rs.getString("departement.Dep_Nom");
                String abr = rs.getString("departement.Dep_Abr");
                String date = rs.getString("departement.Dep_date");
                int dep_id_par = rs.getInt("departement.Dep_Id_Par");
                String type_nom = rs.getString("type.Type_Nom");

                deps.add(new Departement(id, nom, abr, date, dep_id_par, type_nom));
                System.out.println(nom + " " + abr);
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
        return deps;

    }
      
    public boolean updatDepartement(Departement dep) throws SQLException {
        boolean ligneUpdat;
        Connection conn = seConnecter();

        PreparedStatement pst = conn.prepareStatement(UPDATE_DEPARTEMENT);
        pst.setString(1, dep.getDep_nom());
        pst.setString(2, dep.getDep_abr());
        pst.setString(3, dep.getDep_date());
        pst.setInt(4, dep.getDep_id_par());
        pst.setInt(5, dep.getType_id());
        pst.setInt(6, dep.getDep_id());
        
        ligneUpdat = pst.executeUpdate() > 0;

        conn.close();
        return ligneUpdat;

    }
    
    public boolean deletDepartement(int id) throws SQLException {
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_DEPARTEMENT);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;

        conn.close();
        return ligneDelet;
    }
}
