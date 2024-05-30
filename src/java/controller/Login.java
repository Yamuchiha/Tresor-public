/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Selection_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yami Sukehiro
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("email");
		String password = request.getParameter("password");
		Connection conn = null;
		HttpSession s = request.getSession();
		RequestDispatcher disp = null;
                Selection_User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/personnel","root","");
			//PreparedStatement pst = conn.prepareStatement("select * from user where Email = ? and Password = ?");
                        PreparedStatement pst = conn.prepareStatement("select * from employer inner join user on employer.Em_Id=user.Em_Id where employer.Email = ? and user.Password = ?");
			pst.setString(1, nom);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
                            int us_id = rs.getInt("employer.Em_Id");
                            String us_nom = rs.getString("employer.Em_nom");
                            String us_prenom = rs.getString("employer.Em_prenom");
                            String us_role = rs.getString("user.Role");
                            System.out.println(rs.getString("employer.Em_nom") + " " + rs.getString("user.Role"));
                             user = new Selection_User(us_id, us_nom, us_prenom, us_role);
				s.setAttribute("name", user);
				//s.setAttribute("role", rs.getString("user.Role"));
                                
                                if(rs.getString("user.Role").equals("Admin")){
                                   disp = request.getRequestDispatcher("affichage");
                            }else{
                                   disp = request.getRequestDispatcher("demAff");
                                }
                               
				
			}else {
				request.setAttribute("status", "failed");
				disp = request.getRequestDispatcher("Login.jsp");
				
			}
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("Login.jsp");
		disp.forward(request, response);
	}
	

}


