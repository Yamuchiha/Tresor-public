/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Selection.Selection_Validation_Update;
import dao.AffectationDao;
import dao.DemanderDao;
import dao.ValidationDao;
import entite.Affectation;
import entite.Demander;
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
@WebServlet(name = "valDetail", urlPatterns = {"/valDetail"})
public class Val_Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        ValidationDao valao = new ValidationDao();
        Selection_Validation_Update valdetail = valao.selectValidationUpdate(id);
        request.setAttribute("Emstat", "success");
        session.setAttribute("valdetail", valdetail);
        RequestDispatcher disp = request.getRequestDispatcher("valAffEn");
        disp.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = null;
        int dem_id = Integer.parseInt(request.getParameter("dem_id"));
        String dem_req_status = request.getParameter("dem_req_status");       
        String raison = request.getParameter("raison");
        ValidationDao valao = new ValidationDao();
        Selection_Validation_Update vals = new Selection_Validation_Update(dem_id, dem_req_status, raison);

        try {

            valao.updatValidation(vals);
            request.setAttribute("status", "success");
            disp = request.getRequestDispatcher("valAffEn");
            disp.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
