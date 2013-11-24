/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GuilhermeA
 */
@WebServlet(name = "menuServlet", urlPatterns = {"/menuServlet"})
public class menuServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet menuServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Menu</h1>");
            if(request.getParameter("login").equals("coord") && request.getParameter("senha").equals("coord")){
                out.println("<h2>Cadastros/Edição</h2>");
                out.println("<a href=\"disciplinaServlet?mode=cad\">Disciplinas</a><br/>");
                out.println("<a href=\"horarioServlet?mode=cad\">Horarios</a><br/>");
                out.println("<a href=\"professorServlet?mode=cad\">Professores</a><br/>");
                out.println("<a href=\"salaServlet?mode=cad\">Sala</a><br/>");
                out.println("<a href=\"reservaServlet?mode=cad\">Reservas</a><br/>");
            }
            out.println("<h2>Grades</h2>");
            out.println("<a href=\"gradeServlet?mode=disciplina\">Por Disciplinas</a><br/>");
            out.println("<a href=\"gradeServlet?mode=turma\">Por Turma</a><br/>");
            out.println("<a href=\"gradeServlet?mode=sala\">Por Sala</a><br/>");
            out.println("<a href=\"gradeServlet?mode=professor\">Por Professor</a><br/>");
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
