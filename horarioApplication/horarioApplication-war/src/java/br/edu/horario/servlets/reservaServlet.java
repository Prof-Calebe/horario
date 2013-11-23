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
             out.println("<script type=\"text/javascript\">");
            out.println("function changeFunc(){");      
            out.println("var selectBox = document.getElementById(\"reservas\");");
            out.println("var selectedValue = selectBox.options[selectBox.selectedIndex].value;");
            out.println("if(selectedValue!=0) window.location.href='reservaServlet?mode=edit&cod='+selectedValue;}</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header\" width='100%'>");
            out.println("<a href='reservaServlet?mode=cad'>Cadastrar</a>");
            out.println("<a href='reservaServlet?mode=edit'>Editar</a>");
            out.println("<a href='reservaServlet?mode=list'>Listar</a>");
            out.println("</div>");
            out.println("<hr>");
            //HTML cad
            if(request.getParameter("mode")!=null && request.getParameter("mode").equals("cad")){

                out.println("<h2>Cadastrar Reserva</h2>");
                out.println("<form action=\"reservaServlet?mode=cad\" method=\"post\">");
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
                //HTML Edit
            }else if(request.getParameter("mode")!=null && request.getParameter("mode").equals("edit")){
                out.println("<h2>Alteracao Reserva</h2>");
                out.println("<form action=\"reservaServlet?mode=edit\" method=\"post\">");
                
                out.println("Reservas");
                out.println("<select name=\"reservas\" id=\"reservas\" onchange=\"changeFunc();\">");
                out.println("<option value=0 selected=\"true\">Selecione uma reserva</option>");
                List<Reserva> lsReservas = reservaFacade.findAll();
                for (Reserva res : lsReservas) {
                    out.println("<option value="+res.getCodigo()+">"+res.toString()+"</option>" );
                }
                out.println("</select>");
                out.println("<table>\n");
                out.println("</tr><tr>");
                if(request.getParameter("cod")!=null){
                    Reserva res = reservaFacade.find(Integer.parseInt(request.getParameter("cod")));
                    out.println("<td><input name=\"cod_value\" type=\"hidden\" size=\"50\" value=\""+res.getCodigo()+"\" /></td>");
                    out.println("</tr><hr><tr>");
                    out.println("<td>Horario</td>");
                    out.println("<td><select name=\"horario\">");
                    List<Horario> lsHorarios = horarioFacade.findAll();
                    for (Horario hor : lsHorarios) {
                        if(res.getHorario().getCodigo()==hor.getCodigo()){
                            out.println("<option selected=\"true\" value="+hor.getCodigo()+">"+hor.getHorario()+"</option>" );
                        }else{
                            out.println("<option value="+hor.getCodigo()+">"+hor.getHorario()+"</option>" );
                        }
                    }
                    out.println("</select></td>");
                    out.println("</tr><tr>");
                    out.println("<td>Sala</td>");
                    out.println("<td><select name=\"sala\">");
                    List<Sala> lsSalas = salaFacade.findAll();
                    for (Sala sala : lsSalas) {
                        if(sala.getCodigo()==res.getSala().getCodigo()){
                           out.println("<option selected=\"true\" value="+sala.getCodigo()+">"+sala.toString()+"</option>" );
                        }else{
                           out.println("<option value="+sala.getCodigo()+">"+sala.toString()+"</option>" );
                        }
                    }
                    out.println("</select></td>");
                    out.println("</tr><tr>");
                    out.println("<td>Professor</td>");
                    out.println("<td><select name=\"professor\">");
                    List<Professor> lsProfessor = professorFacade.findAll();
                    for (Professor prof : lsProfessor) {
                        if(prof.getCodigo()==res.getProfessor().getCodigo()){
                            out.println("<option selected=\"true\" value="+prof.getCodigo()+">"+prof.getNome()+"</option>" );
                        }else{
                            out.println("<option value="+prof.getCodigo()+">"+prof.getNome()+"</option>" );
                        }
                    }
                    out.println("</select></td>");
                    out.println("</tr><tr>");
                    out.println("<td>Disciplina</td>");
                    out.println("<td><select name=\"disciplina\">");
                    List<Disciplina> lsDisciplinas = disciplinaFacade.findAll();
                    for (Disciplina dis : lsDisciplinas) {
                        if(dis.getCodigo()==res.getDisciplina().getCodigo()){
                            out.println("<option selected=\"true\" value="+dis.getCodigo()+">"+dis.getNome()+"</option>" );
                        }else{
                            out.println("<option value="+dis.getCodigo()+">"+dis.getNome()+"</option>" );
                        }
                    }
                    out.println("</select></td>");
                    out.println("</tr>\n</table>");
                    out.println("<input name=\"btn_editar\" type=\"submit\" value=\"Editar\"/><input name=\"btn_deletar\" type=\"submit\" value=\"Deletar\"/>\n</form>");
                }
                //HTML listar
            }else{
                out.println("<h2>Reservas Cadastrados</h2>");
                List<Reserva> list = reservaFacade.findAll();
                for (Reserva res : list) {
                    out.println(res + "<br/>");
                }                
            }
            //Request cad
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Reserva res = new Reserva(salaFacade.find(Integer.parseInt(request.getParameter("sala"))),horarioFacade.find(Integer.parseInt(request.getParameter("horario"))),disciplinaFacade.find(Integer.parseInt(request.getParameter("disciplina"))),professorFacade.find(Integer.parseInt(request.getParameter("professor"))));
                    reservaFacade.create(res);
                    out.println("Reserva cadastrada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Reserva.\n");
                } finally {
                    out.println("</font>");
                }
                //Request editar
            }else if (request.getParameter("btn_editar") != null && request.getParameter("btn_editar").equals("Editar")) {
                try {
                    out.println("<font color=\"red\">");
                    Reserva res = reservaFacade.find(Integer.parseInt(request.getParameter("cod_value")));
                    res.setSala(salaFacade.find(Integer.parseInt(request.getParameter("sala"))));
                    res.setHorario(horarioFacade.find(Integer.parseInt(request.getParameter("horario"))));
                    res.setDisciplina(disciplinaFacade.find(Integer.parseInt(request.getParameter("disciplina"))));
                    res.setProfessor(professorFacade.find(Integer.parseInt(request.getParameter("professor"))));
                    reservaFacade.edit(res);
                    out.println("Reserva editada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao editar Reserva.\n");
                } finally {
                    out.println("</font>");
                }
                //Request deletar
            }else if (request.getParameter("btn_deletar") != null && request.getParameter("btn_deletar").equals("Deletar")) {
                try {
                    out.println("<font color=\"red\">");
                    Reserva res = reservaFacade.find(Integer.parseInt(request.getParameter("cod_value")));
                    reservaFacade.remove(res);
                    out.println("Reserva deletada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao deletar Reserva.Ela pode estar sendo usada em outra tabela!\n");
                } finally {
                    out.println("</font>");
                }
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
