/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jbean.Validate;
import java.sql.*;

/**
 *
 * @author jhari
 */
@WebServlet(name = "Student_Login_Servlet", urlPatterns = {"/Student_Login_Servlet"})
public class Student_Login_Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Student_Login_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println ("UVI ID or Password is incorrect");
            String UV_ID= request.getParameter("UVI_ID");
            int Uid= Integer.parseInt(UV_ID);
            String UVpass=request.getParameter("UVI_pass");
            
            
            if (Validate.checkUser(Uid, UVpass)){
                out.println ("Validated!");
                RequestDispatcher rs = request.getRequestDispatcher ("CourseSelection.html");
                rs.forward(request, response);
                out.println ("Welcome, user " + Uid);
            }else{
                out.println ("UVI ID or Password is incorrect");
                RequestDispatcher rs=request.getRequestDispatcher("index.html");
                rs.forward(request, response);
            }
            
            out.println("<h1>Servlet Student_Login_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("I am in the do post");
        try{
        processRequest(request, response);
        }
        catch (Exception e) {}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
