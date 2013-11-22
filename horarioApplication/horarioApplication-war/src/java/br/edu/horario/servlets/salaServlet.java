/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import br.edu.horario.jpa.SalaFacade;
import br.edu.horario.models.Professor;
import br.edu.horario.models.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GuilhermeA
 */
@WebServlet(name = "salaServlet", urlPatterns = {"/salaServlet"})
public class salaServlet extends HttpServlet {

    @EJB
    SalaFacade salaFacade = new SalaFacade();
    
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
            out.println("<title>Servlet salaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1>Lista de Salas</h1>");

            out.println("<h2>Cadastrar Salas</h2>");
            out.println("<form action=\"salaServlet\" method=\"post\">");
            out.println("<table>\n<tr>");
            out.println("<td>Numero da Sala</td>");
            out.println("<td><input name=\"sala_value\" type=\"text\" size=\"50\" /></td>");
            out.println("</tr>\n</table>");
            out.println("</tr><tr>");
            out.println("<td>Numero do predio</td>");
            out.println("</tr><tr>");
            out.println("<td><input name=\"predio_value\" type=\"text\" size=\"50\"/></td>");
            out.println("<input name=\"btn_cadastrar\" type=\"submit\" value=\"Cadastrar\"/>\n</form>");
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Sala sala = new Sala(request.getParameter("sala_value"),request.getParameter("predio_value"));
                    salaFacade.create(sala);
                    out.println("Sala cadastrada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Professor.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Salas Cadastrados</h2>");
            List<Sala> list = salaFacade.findAll();
            for (Sala sala : list) {
                out.println(sala + "<br/>");
            }
            out.println("<br/>");
            out.println("<a href=\".\">Voltar</a>");;
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
