/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UtilisateurDao;
import entite.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UtiliInsert", urlPatterns = {"/UtiliInsert"})
public class Utili_Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nom = Integer.parseInt(request.getParameter("nom"));
        String role = request.getParameter("role");
        String passe = request.getParameter("pass");
        
        Utilisateur ut = new Utilisateur(nom, role, passe);
        UtilisateurDao utao = new UtilisateurDao();
        utao.insertUtilisateur(ut);
        request.setAttribute("status", "success");
        RequestDispatcher disp = request.getRequestDispatcher("utiAffiche");
        disp.forward(request, response);
    }
    

}
