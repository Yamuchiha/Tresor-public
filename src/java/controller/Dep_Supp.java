package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.DepartementDao;
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

/**
 *
 * @author Yami Sukehiro
 */
@WebServlet(name = "depSupp", urlPatterns = {"/depSupp"})
public class Dep_Supp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartementDao depao = new DepartementDao();
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher disp;
        try {
            depao.deletDepartement(id);
            request.setAttribute("status", "success");
            disp = request.getRequestDispatcher("depAffAcceuil");
            disp.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Dep_Supp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
