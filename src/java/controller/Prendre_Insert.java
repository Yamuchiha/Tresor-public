/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PrendreDao;
import entite.Prendre;
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
@WebServlet(name = "prendreInsert", urlPatterns = {"/prendreInsert"})
public class Prendre_Insert extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int per = Integer.parseInt(request.getParameter("per"));
        int conge = Integer.parseInt(request.getParameter("conge"));
        String date_dep= request.getParameter("date_dep");
        String date_fin = request.getParameter("date_fin");
        String motif = request.getParameter("motif");
        PrendreDao preao = new PrendreDao();
        Prendre pre = new Prendre(per, conge, date_dep, date_fin, motif);
        preao.insertPrendre(pre);
        request.setAttribute("status", "success");
        RequestDispatcher disp = request.getRequestDispatcher("prendreAffiche");
        disp.forward(request, response);
    }
    

}
