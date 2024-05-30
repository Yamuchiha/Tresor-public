/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AffectationDao;
import dao.PrendreDao;
import entite.Affectation;
import entite.Prendre;
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
@WebServlet(name = "prendreDetail", urlPatterns = {"/prendreDetail"})
public class Prendre_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        PrendreDao preao = new PrendreDao();
        Prendre pren = preao.selectPrendre(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("pren", pren);
        RequestDispatcher disp = request.getRequestDispatcher("Prendre_Detail.jsp");
        disp.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = null;
        int id = Integer.parseInt(request.getParameter("id1"));
        int per = Integer.parseInt(request.getParameter("per"));
        int conge = Integer.parseInt(request.getParameter("conge"));
        String date_dep= request.getParameter("date_dep");
        String date_fin = request.getParameter("date_fin");
        String motif = request.getParameter("motif");
        PrendreDao preao = new PrendreDao();
        Prendre pre = new Prendre(id, per, conge, date_dep, date_fin, motif);

        try {

            preao.updatPrendre(pre);
            request.setAttribute("status", "success");
            disp = request.getRequestDispatcher("prendreAffiche");
            disp.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}
