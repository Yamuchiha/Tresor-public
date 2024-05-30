/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AffectationDao;
import dao.DepartementDao;
import entite.Affectation;
import entite.Departement;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "affecDetail", urlPatterns = {"/affecDetail"})
public class Affec_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        AffectationDao affeo = new AffectationDao();
        Affectation affy = affeo.selectAffectation(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("affy", affy);
        RequestDispatcher disp = request.getRequestDispatcher("Aff_Detail.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = null;
        int id = Integer.parseInt(request.getParameter("id1"));
        int per = Integer.parseInt(request.getParameter("per"));
        int dep = Integer.parseInt(request.getParameter("dep"));
        String date = request.getParameter("date");
        AffectationDao affo = new AffectationDao();
        Affectation aff = new Affectation(id, per, dep, date);
                
        try {
            
            affo.updatAffectation(aff);
            request.setAttribute("status", "success");
            disp = request.getRequestDispatcher("affAffiche");
            disp.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
