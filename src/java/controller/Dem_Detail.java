/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DemanderDao;
import dao.DepartementDao;
import dao.EmployerDao;
import entite.Demander;
import entite.Departement;
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
@WebServlet(name = "demDetail", urlPatterns = {"/demDetail"})
public class Dem_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        DemanderDao dem = new DemanderDao();
        Demander demande = dem.selectDemander(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("detailDem", demande);
        RequestDispatcher disp = request.getRequestDispatcher("demAff");
        disp.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dem_id = Integer.parseInt(request.getParameter("dem_id"));
        int em_id = Integer.parseInt(request.getParameter("em_id"));
        int per_id = Integer.parseInt(request.getParameter("per_id"));
        String motif = request.getParameter("motif");
        //System.out.println(nom + " " + abr);
        DemanderDao demao = new DemanderDao();
        Demander dem = new Demander(dem_id, em_id, per_id, motif);
        try {
            demao.updatDemande(dem);
            request.setAttribute("status", "success");
        } catch (SQLException ex) {
            Logger.getLogger(Dep_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher disp = request.getRequestDispatcher("demAff");
        disp.forward(request, response);
    }

}
