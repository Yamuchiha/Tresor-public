/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Selection.Employer_Retour_Id;
import com.mysql.cj.jdbc.MysqlDataSource;
import entite.Employer;
import entite.Permission;
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
public class PermissionDao {
    private static final String INSERT_PERMISSION_SQL = "insert into permission(Permission) values(?)";
    private static final String SELECT_PERMISSION_BY_ID = "select * from permission where Per_id=?";
    private static final String SELECT_ALL_PERMISSION = "select * from permission";
    private static final String DELETE_PERMISSION = "delete from permission where Per_id=?";
    private static final String UPDATE_EMPLOYER = "update permission set Permission=? where Per_id=?";
    
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
    
    public void insertPermission(Permission permission) {
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT_PERMISSION_SQL);
            pst.setString(1, permission.getPermission());
          
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermissionDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
    
    public List<Permission> selectAllPermission() {
        List<Permission> permissions = new ArrayList<>();
        Connection conn = seConnecter();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(SELECT_ALL_PERMISSION);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Per_id");
                String permission = rs.getString("Permission");
                permissions.add(new Permission(id, permission));
                System.out.println(id + " " + permission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PermissionDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return permissions;

    }
}
