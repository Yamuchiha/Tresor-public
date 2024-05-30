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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yami Sukehiro
 */
@WebServlet(name = "Em_Detail", urlPatterns = {"/Em_Detail"})
public class Em_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        EmployerDao em = new EmployerDao();
        Employer employer = em.selectEmployer(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("detailEm", employer);
        RequestDispatcher disp = request.getRequestDispatcher("emAcceuil");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
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
        Employer employer = new Employer(id,nom, prenom, date_naiss,situation, adresse, num, email, genre, date_eng, fonction, sta, motif);
        try {
            em.updatEmployer(employer);
            request.setAttribute("status", "success");
        } catch (SQLException ex) {
            Logger.getLogger(Em_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher disp = request.getRequestDispatcher("emAcceuil");
        disp.forward(request, response);
    }

  

}
