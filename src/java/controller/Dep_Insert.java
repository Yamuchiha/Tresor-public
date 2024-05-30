/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartementDao;
import entite.Departement;
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
@WebServlet(name = "depInsert", urlPatterns = {"/depInsert"})
public class Dep_Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String abr = request.getParameter("abr");
        String date_cre = request.getParameter("date_cre");
        int parent = Integer.parseInt(request.getParameter("parent"));
        int type = Integer.parseInt(request.getParameter("type"));
        Departement dep = new Departement(nom, abr, date_cre, parent, type);
        DepartementDao depao = new DepartementDao();
        depao.insertDepartement(dep);
        RequestDispatcher disp = request.getRequestDispatcher("depAffiche");
        disp.forward(request, response);
        
    }
    
    
     

}
