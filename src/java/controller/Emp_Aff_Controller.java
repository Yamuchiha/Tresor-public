/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Employer_Retour_Id;
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

/**
 *
 * @author Yami Sukehiro
 */
@WebServlet(name = "afficheEmp", urlPatterns = {"/afficheEmp"})
public class Emp_Aff_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       EmployerDao emo = new EmployerDao();
       List<Employer_Retour_Id> employers = emo.selectAllEmployer();
       request.setAttribute("employers", employers);
       RequestDispatcher disp = request.getRequestDispatcher("Emp_Affiche.jsp");
       disp.forward(request, response);
       
       String donne =request.getParameter("donne");
       System.out.println(donne);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    
   

}
