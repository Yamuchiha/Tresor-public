/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AffectationDao;
import entite.Affectation;
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
@WebServlet(name = "affInstert", urlPatterns = {"/affInsert"})
public class Affec_Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int per = Integer.parseInt(request.getParameter("per"));
       int dep = Integer.parseInt(request.getParameter("dep"));
       String date = request.getParameter("date");
       
       Affectation aff = new Affectation(per, dep, date);
       AffectationDao affo = new AffectationDao();
       affo.insertAffectation(aff);
       request.setAttribute("status", "success");
        RequestDispatcher disp = request.getRequestDispatcher("affAffiche");
        disp.forward(request, response);
    }
    

}
