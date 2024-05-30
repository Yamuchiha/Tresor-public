package dao;


import Selection.Selection_Prendre;
import Selection.Selection_Utilisateur;
import com.mysql.cj.jdbc.MysqlDataSource;
import dao.DepartementDao;
import entite.Prendre;
import entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yami Sukehiro
 */
public class UtilisateurDao {
    private static final String INSERT_UTILISATEUR_SQL = "insert into user(Em_Id, Role, Password) values(?,?,?)";
    
    private static final String SELECT_UTILISATEUR_BY_ID = "select * from prendre user inner join employer on user.Em_Id=employer.Em_Id where user.User_id =?";
    
    private static final String SELECT_ALL_UTILISATEUR = "select * from user inner join employer on user.Em_Id=employer.Em_Id inner join concerner on concerner.Em_Id=employer.Em_Id inner join departement on concerner.Dep_Id=departement.Dep_Id inner join statu on statu.Sat_Id=employer.Statu_Id";
    
    private static final String DELETE_UTILISATEUR = "delete from user where User_id =?";
    
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
    
    public void insertUtilisateur(Utilisateur uti) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_UTILISATEUR_SQL);
            pst.setInt(1, uti.getEm_id());
            pst.setString(2, uti.getRole());
            pst.setString(3, uti.getPass());
            
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
       public List<Selection_Utilisateur> selectAllUtilisteur() {
        List<Selection_Utilisateur> utis = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_UTILISATEUR);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user.User_id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String role = rs.getString("user.Role");
                String email = rs.getString("employer.Email");
                String dep = rs.getString("departement.Dep_Nom");
                String fonction = rs.getString("employer.Fonction");
                String statu = rs.getString("statu.Status");

                utis.add(new Selection_Utilisateur(id, nom, prenom, role, email, dep, fonction, statu));
                //System.out.println(nom + " " + abr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return utis;

    }
       
      public boolean deletUtilisateur(int id) throws SQLException {
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_UTILISATEUR);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;

        conn.close();
        return ligneDelet;
    }
      
        public Prendre selectPrendre(int id) {
        Prendre pre = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_UTILISATEUR_BY_ID);
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
}
