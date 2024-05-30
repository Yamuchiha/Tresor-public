/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Selection_Prendre;
import Selection.Selection_Utilisateur;
import dao.PrendreDao;
import dao.UtilisateurDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "utiAffiche", urlPatterns = {"/utiAffiche"})
public class Uti_Affiche extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurDao utao = new UtilisateurDao();
        List<Selection_Utilisateur> utis = utao.selectAllUtilisteur();
        request.setAttribute("utis", utis);
        RequestDispatcher disp = request.getRequestDispatcher("Utilisateur_Affiche.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
