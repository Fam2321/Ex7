/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 60050257
 */
public class Ex7Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double number1 = Double.parseDouble(request.getParameter("Number1"));
        double number2 = Double.parseDouble(request.getParameter("Number2"));
        double result = 0;
        String output = "";
        if (request.getParameter("add") != null) {
            result = number1 + number2;
            request.setAttribute("operator", "+");
            output = String.valueOf(result);
        }
        if (request.getParameter("sub") != null) {
            result = number1 - number2;
            request.setAttribute("operator", "-");
            output = String.valueOf(result);
        }
        if (request.getParameter("mul") != null) {
            result = number1 * number2;
            request.setAttribute("operator", "*");
            output = String.valueOf(result);
        }
        if (request.getParameter("div") != null) {
            request.setAttribute("operator", "/");
            output = "Error Divide By 0";
            if(number2 != 0.0){
                result = number1 / number2;
                output = String.valueOf(result);
            }
        }
        
        request.setAttribute("result", output);
        request.getRequestDispatcher("/output.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
