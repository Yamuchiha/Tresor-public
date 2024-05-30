/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Employer_Retour_Id;
import com.mysql.cj.jdbc.MysqlDataSource;
import dao.EmployerDao;
import entite.Joueur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "affichage", urlPatterns = {"/affichage"})
public class affichage extends HttpServlet {

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Connection conn = null;
		List<Joueur>joueurs = new ArrayList<>();
		HttpSession session = request.getSession();
		RequestDispatcher disp = null;
		try {
			MysqlDataSource datasource = new MysqlDataSource();
			datasource.setServerName("localhost");
			datasource.setPort(3306);
			datasource.setDatabaseName("tennis");
			datasource.setUser("root");
			datasource.setPassword("");
			conn = datasource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from joueur");
			while(rs.next()) {
				Joueur joueur = new Joueur();
				joueur.setId(rs.getInt("ID"));
				joueur.setNom(rs.getString("NOM"));
				joueur.setPrenom(rs.getString("PRENOM"));
				joueur.setSexe(rs.getString("SEXE"));
				//System.out.println(joueur.getId()+ ""+ joueur.getNom());
				joueurs.add(joueur);
			}
                        Statement st1 = conn.createStatement();
                        ResultSet rs1 = st1.executeQuery("select count(ID) as nombre from joueur");
                        
                        int nombre;
                        if(rs1.next()){
                            
                            nombre = rs1.getInt("nombre");
                            request.setAttribute("nombre", nombre);
                            request.setAttribute("jou", "joueur");
                        }
                        Statement st2 = conn.createStatement();
                        ResultSet rs2 = st2.executeQuery("select count(ID) as homme from joueur where SEXE='H'");
                        int homme;
                        if(rs2.next()){                 
                            homme =  rs2.getInt("homme");
                            request.setAttribute("homme", homme);
                        }
                        Statement st3 = conn.createStatement();
                        ResultSet rs3 = st3.executeQuery("select count(ID) as femme from joueur where SEXE='F'");
                        int femme;
                        if(rs3.next()){
                            femme = rs3.getInt("femme");
                            request.setAttribute("femme", femme);
                        }
			request.setAttribute("joueurs", joueurs);
			disp = request.getRequestDispatcher("dynamic.jsp");
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
                
                this.doGet(request, response);
	}
        
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		//List<Joueur>joueurs = new ArrayList<>();
		HttpSession session = request.getSession();
		RequestDispatcher disp = null;
		try {
			MysqlDataSource datasource = new MysqlDataSource();
			datasource.setServerName("localhost");
			datasource.setPort(3306);
			datasource.setDatabaseName("personnel");
			datasource.setUser("root");
			datasource.setPassword("");
			conn = datasource.getConnection();
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery("Select * from joueur");
			/*while(rs.next()) {
				Joueur joueur = new Joueur();
				joueur.setId(rs.getInt("ID"));
				joueur.setNom(rs.getString("NOM"));
				joueur.setPrenom(rs.getString("PRENOM"));
				joueur.setSexe(rs.getString("SEXE"));
				//System.out.println(joueur.getId()+ ""+ joueur.getNom());
				joueurs.add(joueur);
			}*/
                        Statement st1 = conn.createStatement();
                        ResultSet rs1 = st1.executeQuery("select count(Em_Id) as nombre from employer");
                        
                        int nombre;
                        if(rs1.next()){
                            
                            nombre = rs1.getInt("nombre");
                            request.setAttribute("nombre", nombre);
                            request.setAttribute("jou", "joueur");
                        }
                        Statement st2 = conn.createStatement();
                        ResultSet rs2 = st2.executeQuery("select count(Em_Id) as service from employer inner join statu on employer.Statu_Id=statu.Sat_Id where statu.Status='En service'");
                        int service;
                        if(rs2.next()){                 
                            service =  rs2.getInt("service");
                            request.setAttribute("service", service);
                        }
                        Statement st3 = conn.createStatement();
                        ResultSet rs3 = st3.executeQuery("select count(Em_Id) as suspendu from employer inner join statu on employer.Statu_Id=statu.Sat_Id where statu.Status='Suspendue'");
                        int suspendu;
                        if(rs3.next()){
                            suspendu = rs3.getInt("suspendu");
                            request.setAttribute("suspendu", suspendu);
                        }
                        Statement st4 = conn.createStatement();
                        ResultSet rs4 = st4.executeQuery("select count(Dem_Id) as requete from demander");
                        int requete;
                        if(rs4.next()){
                            requete = rs4.getInt("requete");
                            request.setAttribute("requete", requete);
                        }
                        
                        Statement st5 = conn.createStatement();
                        ResultSet rs5 = st5.executeQuery("select count(Dem_Id) as acceptee from demander where Dem_status = 'Acceptee'");
                        int acceptee;
                        if(rs5.next()){
                            acceptee = rs5.getInt("acceptee");
                            request.setAttribute("acceptee", acceptee);
                        }
                        
                        Statement st6 = conn.createStatement();
                        ResultSet rs6 = st6.executeQuery("select count(Dem_Id) as refuse from demander where Dem_status = 'Refuse'");
                        int refuse;
                        if(rs6.next()){
                            refuse = rs6.getInt("refuse");
                            request.setAttribute("refuse", refuse);
                        }
                        
                        Statement st7 = conn.createStatement();
                        ResultSet rs7 = st6.executeQuery("select count(Dem_Id) as en_cour from demander where Dem_status = 'En cour'");
                        int en_cour;
                        if(rs7.next()){
                            en_cour = rs7.getInt("en_cour");
                            request.setAttribute("en_cour", en_cour);
                        }
			//request.setAttribute("joueurs", joueurs);
                    EmployerDao emo = new EmployerDao();
                    List<Employer_Retour_Id> employers = emo.selectAllEmployer();
                    request.setAttribute("employers", employers);
			disp = request.getRequestDispatcher("dynamic.jsp");
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

       

}
