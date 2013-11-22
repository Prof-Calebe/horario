/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import br.edu.horario.jpa.DisciplinaFacade;
import br.edu.horario.jpa.HorarioFacade;
import br.edu.horario.models.Disciplina;
import br.edu.horario.models.EnumDiaDaSemana;
import br.edu.horario.models.Horario;
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
@WebServlet(name = "horarioServlet", urlPatterns = {"/horarioServlet"})
public class horarioServlet extends HttpServlet {
    @EJB
    DisciplinaFacade disciplinaFacade = new DisciplinaFacade();

    @EJB
    HorarioFacade facade = new HorarioFacade();
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
            out.println("<title>Servlet HorarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Horarios</h1>");

            out.println("<h2>Cadastrar Horario</h2>");
            out.println("<form action=\"horarioServlet\" method=\"post\">");
            out.println("<table>\n<tr>");
            out.println("<td>Horario</td>");
            out.println("<td><input name=\"horario_value\" type=\"text\" size=\"50\" value=\"\"/></td>");
            out.println("</tr><tr>");
            out.println("<td>Disciplina</td>");
            out.println("<td><select name=\"disciplina\">");
            List<Disciplina> lsDisciplinas = disciplinaFacade.findAll();
            for (Disciplina dis : lsDisciplinas) {
                out.println("<option value="+dis.getCodigo()+">"+dis.getNome()+"</option>" );
            }
            out.println("</select></td>");
            out.println("</tr>\n</table>");
            out.println("<input name=\"btn_cadastrar\" type=\"submit\" value=\"Cadastrar\"/>\n</form>");
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Horario hor = new Horario(request.getParameter("horario_value"),disciplinaFacade.find(Integer.parseInt(request.getParameter("disciplina"))),"N",EnumDiaDaSemana.SEGUNDA);
                    facade.create(hor);
                    out.println("Horario cadastrado com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Horario.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Horarios Cadastrados</h2>");
            List<Horario> list = facade.findAll();
            for (Horario hor : list) {
                out.println(hor + "<br/>");
            }
            out.println("<br/>");
            out.println("<a href=\".\">Voltar</a>");
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
