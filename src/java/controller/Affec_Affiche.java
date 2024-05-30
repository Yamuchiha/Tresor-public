/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Selection_Affectation;
import dao.AffectationDao;
import dao.DepartementDao;
import entite.Departement;
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
@WebServlet(name = "affAffiche", urlPatterns = {"/affAffiche"})
public class Affec_Affiche extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AffectationDao affo = new AffectationDao();
        List<Selection_Affectation> aff = affo.selectAllAffectation();
        request.setAttribute("aff", aff);
        RequestDispatcher disp = request.getRequestDispatcher("Aff_Affiche.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
    }
    
    
    
    

}
