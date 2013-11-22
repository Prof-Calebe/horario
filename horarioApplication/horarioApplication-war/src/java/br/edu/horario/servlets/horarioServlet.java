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
            out.println("<script type=\"text/javascript\">");
            out.println("function changeFunc(){");      
            out.println("var selectBox = document.getElementById(\"horarios\");");
            out.println("var selectedValue = selectBox.options[selectBox.selectedIndex].value;");
            out.println("if(selectedValue!=0) window.location.href='horarioServlet?mode=edit&cod='+selectedValue;}</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header\" width='100%'>");
            out.println("<a href='horarioServlet?mode=cad'>Cadastrar</a>");
            out.println("<a href='horarioServlet?mode=edit'>Editar</a>");
            out.println("<a href='horarioServlet?mode=list'>Listar</a>");
            out.println("</div>");
            out.println("<hr>");
            if(request.getParameter("mode")!= null && request.getParameter("mode").equals("cad")){
                out.println("<h2>Cadastrar Horario</h2>");
                out.println("<form action=\"horarioServlet?mode=cad\" method=\"post\">");
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
            } else if(request.getParameter("mode")!= null && request.getParameter("mode").equals("edit")){
                out.println("<h2>Editar Horarios</h2>");
                out.println("<form action=\"horarioServlet?mode=edit\" method=\"post\">");
                out.println("<table>\n<tr>");
                out.println("<select value=\"Horario\" id=\"horarios\" name=\"horarios\" onchange=\"changeFunc();\">");
                List<Horario> list = facade.findAll();
                out.println("<option value=0 selected=\"true\">Selecione uma horario</option>");
                for (Horario hor : list) {
                    out.println("<option value="+hor.getCodigo()+">"+hor.toString()+"</option>" );
                }
                out.println("</select></tr>");
                out.println("<tr>");
                String cod = null;
                
                if(request.getParameter("cod")!=null){
                    cod = request.getParameter("cod");
                    Horario h = facade.find(Integer.parseInt(cod));
                    out.println("</tr><hr><tr>");
                    out.print("<td id=\"cod\">"+h.getCodigo()+"</td>");
                    out.println("<td><input id=\"cod_value\" name=\"cod_value\" type=\"hidden\" size=\"50\" value=\""+h.getCodigo()+"\" /></td>");
                    out.println("<td>Horario</td>");
                    out.println("<td><input id=\"horario_value\" name=\"horario_value\" type=\"text\" size=\"50\" value=\""+h.getHorario()+"\" /></td>");
                    out.println("<td>Disciplina</td>");
                    out.println("<td><select value=\"Disciplina\" id=\"disciplinas\" name=\"disciplinas\">");
                    List<Disciplina> lsDis = disciplinaFacade.findAll();
                    for (Disciplina disc : lsDis) {
                        if(disc.getCodigo()==(h.getDisciplina().getCodigo())){
                            out.println("<option selected=\"true\" value="+disc.getCodigo()+">"+disc.getNome()+"</option>" );
                        }else{
                            out.println("<option value="+disc.getCodigo()+">"+disc.getNome()+"</option>" );
                        }
                    }
                    out.println("</td></select>");
                    out.println("<td>Turma</td>");
                    out.println("<td><input id=\"turma_value\" name=\"turma_value\" type=\"text\" size=\"50\" value=\""+h.getTurma()+"\" /></td>");
                    out.println("<td>Dia da semana</td>");
                    out.println("<td><select name=\"dia_value\">");
                    for(EnumDiaDaSemana dia : EnumDiaDaSemana.values()){
                        if(h.getDia()==dia){
                            out.println("<option selected=\"true\" value="+dia.name()+">"+dia.name()+"</option>");
                        }else{
                            out.println("<option value="+dia.name()+">"+dia.name()+"</option>");
                        }
                    }
                    out.println("</select></td>");
                    out.println("</tr>");

                    out.println("</tr>\n</table>");
                    out.println("<input name=\"btn_editar\" type=\"submit\" value=\"Editar\"/><input name=\"btn_deletar\" type=\"submit\" value=\"Deletar\"/>\n</form>");
                }
            }else if(request.getParameter("mode")!= null && request.getParameter("mode").equals("list")){
                out.println("<h2>Horarios Cadastrados</h2>");
                List<Horario> list = facade.findAll();
                for (Horario hor : list) {
                    out.println(hor + "<br/>");
                }
            }
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
            }else if (request.getParameter("btn_deletar") != null && request.getParameter("btn_deletar").equals("Deletar")) {
                try {
                    out.println("<font color=\"red\">");
                    Horario hor = facade.find(Integer.parseInt(request.getParameter("cod_value")));
                    facade.remove(hor);
                    out.println("Horario deletado com sucesso.Atualize a página");
                } catch (Exception e) {
                    out.println("Erro ao gravar Horario.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
            }else if (request.getParameter("btn_editar") != null && request.getParameter("btn_editar").equals("Editar")) {
                try {
                    out.println("<font color=\"red\">");
                    Horario hor = facade.find(Integer.parseInt(request.getParameter("cod_value")));
                    hor.setDisciplina(disciplinaFacade.find(Integer.parseInt(request.getParameter("disciplinas"))));
                    hor.setTurma(request.getParameter("turma_value"));
                    hor.setHorario(request.getParameter("horario_value"));
                    hor.setDia(EnumDiaDaSemana.valueOf(request.getParameter("dia_value")));
                    facade.edit(hor);
                    out.println("Horario alterado com sucesso.Atualize a página");
                } catch (Exception e) {
                    out.println("Erro ao gravar Horario.\n");
                    for (StackTraceElement element : e.getStackTrace()) {
                        out.println(element+"<br>");
                    }
                } finally {
                    out.println("</font>");
                }
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
