/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.AllDemande;
import dao.DemanderDao;
import dao.EmployerDao;
import entite.Employer;
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
@WebServlet(name = "detailDemande", urlPatterns = {"/detailDemande"})
public class Detail_Demande_Per extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        DemanderDao dao = new DemanderDao();
        AllDemande demande = dao.selectDetatilDemander(id);
        request.setAttribute("Emstat", "success");
        request.setAttribute("demande", demande);
        RequestDispatcher disp = request.getRequestDispatcher("Requete_Detail.jsp");
        disp.forward(request, response);
        System.out.println(id);
    }

}
