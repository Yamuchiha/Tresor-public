/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartementDao;
import entite.Departement;
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
@WebServlet(name = "depDetail", urlPatterns = {"/depDetail"})
public class Dep_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        DepartementDao depao = new DepartementDao();
        Departement dep = depao.selectDepartement(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("dep", dep);
        RequestDispatcher disp = request.getRequestDispatcher("depAffAcceuil");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id1"));
        String nom = request.getParameter("nom");
        String abr = request.getParameter("abr");
        String date_cre = request.getParameter("date_cre");
        int parent = Integer.parseInt(request.getParameter("parent"));
        int type = Integer.parseInt(request.getParameter("type"));
        System.out.println(nom + " " + abr);
        DepartementDao depao = new DepartementDao();
        Departement dep = new Departement(id, nom, abr,date_cre, parent, type);
        try {
            depao.updatDepartement(dep);
            request.setAttribute("status", "success");
        } catch (SQLException ex) {
            Logger.getLogger(Dep_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher disp = request.getRequestDispatcher("depAffAcceuil");
        disp.forward(request, response);
    }

    

}
