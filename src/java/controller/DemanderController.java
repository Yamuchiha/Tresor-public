/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DemanderDao;
import dao.EmployerDao;
import entite.Demander;
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
@WebServlet(name = "demander", urlPatterns = {"/demander"})
public class DemanderController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int em_id = Integer.parseInt(request.getParameter("em_id"));
        int per_id = Integer.parseInt(request.getParameter("per_id"));
        String motif = request.getParameter("motif");
        System.out.println(em_id + " " + per_id + " " + motif);
        DemanderDao demao = new DemanderDao();
        Demander dem= new Demander(em_id, per_id, motif);
        demao.insertDepartement(dem);
        //em.insertEmployer(employer);
        //em.selectEmployer(1);
        //this.doGet(request, response);

        //System.out.println(nom + " " + prenom);
        RequestDispatcher disp = request.getRequestDispatcher("demAffAcceuil");
        disp.forward(request, response);
    }

}
