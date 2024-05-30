/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EmployerDao;
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
@WebServlet(name = "emSupp", urlPatterns = {"/emSupp"})
public class Emp_Supp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      
      EmployerDao emo = new EmployerDao();
        try {
            emo.deletEmployer(id);
            request.setAttribute("status", "success");
            RequestDispatcher disp = request.getRequestDispatcher("emAcceuil");
            disp.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Emp_Supp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
