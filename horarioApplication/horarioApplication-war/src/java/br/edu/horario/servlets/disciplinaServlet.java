/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import br.edu.horario.jpa.DisciplinaFacade;
import br.edu.horario.models.Disciplina;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme
 */
public class disciplinaServlet extends HttpServlet {

    @EJB
    DisciplinaFacade facade = new DisciplinaFacade();
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
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisciplinaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Disciplinas</h1>");

            out.println("<h2>Cadastrar Disciplinas</h2>");
            out.println("<form action=\"disciplinaServlet\" method=\"post\">");
            out.println("<table>\n<tr>");
            out.println("<td>Nome da disciplina</td>");
            out.println("<td><input name=\"nome_value\" type=\"text\" size=\"50\" /></td>");
            out.println("</tr>\n</table>");
            out.println("<input name=\"btn_cadastrar\" type=\"submit\" value=\"Cadastrar\"/>\n</form>");
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Disciplina disc = new Disciplina(request.getParameter("nome_value"));
                    facade.create(disc);
                    out.println("Disciplina cadastrada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Disciplina.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Disciplinas Cadastrados</h2>");
            List<Disciplina> list = facade.findAll();
            for (Disciplina disc : list) {
                out.println(disc + "<br/>");
            }
            out.println("<br/>");
            out.println("<a href=\".\">Voltar</a>");;
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
