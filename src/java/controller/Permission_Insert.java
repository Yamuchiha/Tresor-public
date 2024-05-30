/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PermissionDao;
import dao.PrendreDao;
import entite.Permission;
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
@WebServlet(name = "permInsert", urlPatterns = {"/permInsert"})
public class Permission_Insert extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String permission = request.getParameter("permission");
        PermissionDao permao = new PermissionDao();
        Permission perm = new Permission(permission);
        permao.insertPermission(perm);
        request.setAttribute("status", "success");
        RequestDispatcher disp = request.getRequestDispatcher("permAffiche");
        disp.forward(request, response);
    }

}
