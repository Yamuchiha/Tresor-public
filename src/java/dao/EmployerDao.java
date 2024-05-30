/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Employer_Retour_Id;
import com.mysql.cj.jdbc.MysqlDataSource;
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
public class EmployerDao {
    
    private static final String INSERT_EMPLOYERS_SQL = "insert into employer(Em_Nom, Em_Prenom, Date_naiss, Etat_civil, Adresse, Contact, Email, Sexe, Date_Eng, Fonction, Statu_Id, Motif) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private static final String SELECT_EMPLOYER_BY_ID = "select * from employer inner join statu on employer.Statu_Id=statu.Sat_Id where employer.Em_Id=?";
    
    private static final String SELECT_ALL_EMPLOYER = "select * from employer inner join statu on employer.Statu_Id=statu.Sat_Id";
    
    private static final String DELETE_EMPLOYER = "delete from employer where Em_Id=?";
    
    private static final String UPDATE_EMPLOYER = "update employer set Em_Nom=?, Em_Prenom =?, Date_naiss=?, Etat_civil=?, Adresse=?, Contact=?, Email=?, Sexe=?, Date_Eng=?, Fonction=?, Statu_Id=?, Motif=? where Em_Id=?";
    
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
    
    public void insertEmployer(Employer employer){
     Connection conn = seConnecter();
     PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_EMPLOYERS_SQL);
            pst.setString(1, employer.getNom());
            pst.setString(2, employer.getPrenom());
            pst.setString(3, employer.getDate_naiss());
            pst.setString(4, employer.getEtat_civil());
            pst.setString(5, employer.getAdresse());
            pst.setString(6, employer.getContact());
            pst.setString(7, employer.getEmail());
            pst.setString(8, employer.getSexe());
            pst.setString(9, employer.getDate_eng());
            pst.setString(10, employer.getFonction());
            pst.setInt(11, employer.getStatu_id());
            pst.setString(12, employer.getMotif());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
         try {
             conn.close();
         } catch (SQLException ex) {
             Logger.getLogger(EmployerDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        }

    }
    
    
    public Employer selectEmployer(int id){
        Employer employer = null;
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_EMPLOYER_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String date_naiss = rs.getString("employer.Date_naiss");
                String etat_civil = rs.getString("employer.Etat_civil");
                String adresse = rs.getString("employer.Adresse");
                String contact = rs.getString("employer.Contact");
                String email = rs.getString("employer.Email"); 
                String sexe =rs.getString("employer.Sexe");
                String date_eng=rs.getString("employer.Date_Eng");
                String fonction= rs.getString("employer.Fonction");
                int statu_id = rs.getInt("employer.Statu_Id");
                String motif = rs.getString("employer.Motif");
                employer = new Employer(id, nom, prenom, date_naiss, etat_civil, adresse, contact, email, sexe, date_eng, fonction, statu_id, motif);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
        finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
         return employer;
    }
    public List<Employer_Retour_Id> selectAllEmployer(){
        List<Employer_Retour_Id> employers = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_EMPLOYER);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("employer.Em_Id");
                String nom = rs.getString("employer.Em_Nom");
                String prenom = rs.getString("employer.Em_Prenom");
                String date_naiss = rs.getString("employer.Date_naiss");
                String etat_civil = rs.getString("employer.Etat_civil");
                String adresse = rs.getString("employer.Adresse");
                String contact = rs.getString("employer.Contact");
                String email = rs.getString("employer.Email"); 
                String sexe =rs.getString("employer.Sexe");
                String date_eng=rs.getString("employer.Date_Eng");
                String fonction= rs.getString("employer.Fonction");
                String statu_id = rs.getString("statu.Status");
                String motif = rs.getString("employer.Motif");
                employers.add(new Employer_Retour_Id(id, nom, prenom, date_naiss, etat_civil, adresse, contact, email, sexe, date_eng, fonction, statu_id, motif));
                System.out.println(nom+ " " + prenom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return employers;
    
    }
    
    public boolean updatEmployer(Employer employer) throws SQLException{
        boolean ligneUpdat;
        Connection conn = seConnecter();
        
        
            PreparedStatement pst = conn.prepareStatement(UPDATE_EMPLOYER);
            pst.setString(1, employer.getNom());
            pst.setString(2, employer.getPrenom());
            pst.setString(3, employer.getDate_naiss());
            pst.setString(4, employer.getEtat_civil());
            pst.setString(5, employer.getAdresse());
            pst.setString(6, employer.getContact());
            pst.setString(7, employer.getEmail());
            pst.setString(8, employer.getSexe());
            pst.setString(9, employer.getDate_eng());
            pst.setString(10, employer.getFonction());
            pst.setInt(11, employer.getStatu_id());
            pst.setString(12, employer.getMotif());
            pst.setInt(13, employer.getId());
            ligneUpdat = pst.executeUpdate() > 0;
        
            conn.close();
        return ligneUpdat;
        
    }
    
    public boolean deletEmployer(int id) throws SQLException{
        boolean ligneDelet;
        Connection conn = seConnecter();
        PreparedStatement pst = conn.prepareStatement(DELETE_EMPLOYER);
        pst.setInt(1, id);
        ligneDelet = pst.executeUpdate() > 0;
        
        conn.close();
        return ligneDelet;
    }
    
    
}
