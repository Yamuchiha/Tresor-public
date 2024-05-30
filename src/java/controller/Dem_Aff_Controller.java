/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Employer_Retour_Id;
import Selection.Selection_User;
import Selection.Selection_User_Requete;
import dao.DemanderDao;
import dao.EmployerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "demAff", urlPatterns = {"/demAff"})
public class Dem_Aff_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp;
        if (request.getSession().getAttribute("name") != null) {
            Selection_User us = (Selection_User) request.getSession().getAttribute("name");
            int id = us.getUs_id();
            DemanderDao demao = new DemanderDao();
            List<Selection_User_Requete> userRequets = demao.selectAllUserRequete(id);
            request.setAttribute("userRequets", userRequets);
            disp = request.getRequestDispatcher("Tableau_User.jsp");
            disp.forward(request, response);
        }else{
            disp = request.getRequestDispatcher("Login");
            disp.forward(request, response);
        }
        


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
