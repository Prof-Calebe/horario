/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import br.edu.horario.jpa.DisciplinaFacade;
import br.edu.horario.jpa.HorarioFacade;
import br.edu.horario.jpa.ProfessorFacade;
import br.edu.horario.jpa.ReservaFacade;
import br.edu.horario.jpa.SalaFacade;
import br.edu.horario.models.Disciplina;
import br.edu.horario.models.EnumDiaDaSemana;
import br.edu.horario.models.Horario;
import br.edu.horario.models.Professor;
import br.edu.horario.models.Reserva;
import br.edu.horario.models.Sala;
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
public class reservaServlet extends HttpServlet {
    @EJB
    ReservaFacade reservaFacade = new ReservaFacade();
    @EJB
    HorarioFacade horarioFacade = new HorarioFacade();
    @EJB
    ProfessorFacade professorFacade = new ProfessorFacade();
    @EJB
    SalaFacade salaFacade = new SalaFacade();
    @EJB
    DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
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
            out.println("<title>Servlet reservaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Reservas</h1>");

            out.println("<h2>Cadastrar Reserva</h2>");
            out.println("<form action=\"reservaServlet\" method=\"post\">");
            out.println("<table>\n<tr>");
            out.println("<td>Horario</td>");
            out.println("<td><select name=\"horario\">");
            List<Horario> lsHorarios = horarioFacade.findAll();
            for (Horario hor : lsHorarios) {
                out.println("<option value="+hor.getCodigo()+">"+hor.getHorario()+"</option>" );
            }
            out.println("</select></td>");
            out.println("</tr><tr>");
            out.println("<td>Sala</td>");
            out.println("<td><select name=\"sala\">");
            List<Sala> lsSalas = salaFacade.findAll();
            for (Sala sala : lsSalas) {
                out.println("<option value="+sala.getCodigo()+">"+sala.toString()+"</option>" );
            }
            out.println("</select></td>");
            out.println("</tr><tr>");
            out.println("<td>Professor</td>");
            out.println("<td><select name=\"professor\">");
            List<Professor> lsProfessor = professorFacade.findAll();
            for (Professor prof : lsProfessor) {
                out.println("<option value="+prof.getCodigo()+">"+prof.getNome()+"</option>" );
            }
            out.println("</select></td>");
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
                    Reserva res = new Reserva(salaFacade.find(Integer.parseInt(request.getParameter("sala"))),horarioFacade.find(Integer.parseInt(request.getParameter("horario"))),disciplinaFacade.find(Integer.parseInt(request.getParameter("disciplina"))),professorFacade.find(Integer.parseInt(request.getParameter("professor"))));
                    reservaFacade.create(res);
                    out.println("Reserva cadastrada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Reserva.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Reservas Cadastrados</h2>");
            List<Reserva> list = reservaFacade.findAll();
            for (Reserva res : list) {
                out.println(res + "<br/>");
            }
            out.println("<br/>");
            out.println("<a href=\".\">Voltar</a>");
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
