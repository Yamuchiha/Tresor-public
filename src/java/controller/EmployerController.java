/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EmployerDao;
import entite.Employer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yami Sukehiro
 */
@WebServlet(name = "employer", urlPatterns = {"/employer"})
public class EmployerController extends HttpServlet {
    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date_naiss = request.getParameter("date_naiss");
        String situation = request.getParameter("situation");
        String adresse = request.getParameter("adresse");
        String num = request.getParameter("num");
        String email = request.getParameter("email");
        String genre = request.getParameter("genre");
        String date_eng = request.getParameter("date_eng");
        String fonction = request.getParameter("fonction");
        int sta = Integer.parseInt(request.getParameter("sta"));
        String motif = request.getParameter("motif");
        System.out.println(nom + " " + prenom+ " ");
        EmployerDao em = new EmployerDao();
        Employer employer = new Employer(nom, prenom, date_naiss,situation, adresse, num, email, genre, date_eng, fonction, sta, motif);
        em.insertEmployer(employer);
        //em.selectEmployer(1);
       //this.doGet(request, response);
       
       //System.out.println(nom + " " + prenom);
       RequestDispatcher disp = request.getRequestDispatcher("afficheEmp");
       disp.forward(request, response);
    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getServletPath();
        switch (action) {
            case "/ajout":
                ajout(request, response);
                break;
            
            case "/supression":
           {
               
           try {
               supression(request, response);
           } catch (SQLException ex) {
               Logger.getLogger(EmployerController.class.getName()).log(Level.SEVERE, null, ex);
           }
             
           }
                break;

                
            case "/modification":
                
                break;
            
            case "/modif":
                modif(request, response);
                break;
            default:
                break;
        }
    }*/
    
    /*private void ajout(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date_naiss = request.getParameter("date_naiss");
        String situation = request.getParameter("situation");
        String adresse = request.getParameter("adresse");
        String num = request.getParameter("num");
        String email = request.getParameter("email");
        String genre = request.getParameter("genre");
        String date_eng = request.getParameter("date_eng");
        String fonction = request.getParameter("fonction");
        int sta = Integer.parseInt(request.getParameter("sta"));
        String motif = request.getParameter("motif");
        Employer employer = new Employer(nom, prenom, date_naiss,situation, adresse, num, email, genre, date_eng, fonction, sta, motif);
        em.insertEmployer(employer);
        response.sendRedirect("toi");
    } 
    
    private void supression(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        EmployerDao em = new EmployerDao();
        em.deletEmployer(id);
        response.sendRedirect("toi");
    }
    
    private void modif(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Employer modifEmp = em.selectEmployer(id);
        RequestDispatcher disp = request.getRequestDispatcher("useform.jsp");
        request.setAttribute("employeModif", modifEmp);
        disp.forward(request, response);
    }*/
    
    

}
