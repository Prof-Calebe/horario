/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.horario.servlets;

import br.edu.horario.jpa.SalaFacade;
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
            out.println("<script type=\"text/javascript\">");
            out.println("function changeFunc(){");      
            out.println("var selectBox = document.getElementById(\"salas\");");
            out.println("var selectedValue = selectBox.options[selectBox.selectedIndex].value;");
            out.println("if(selectedValue!=0) window.location.href='salaServlet?mode=edit&cod='+selectedValue;}</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header\" width='100%'>");
            out.println("<a href='salaServlet?mode=cad'>Cadastrar</a>");
            out.println("<a href='salaServlet?mode=edit'>Editar</a>");
            out.println("<a href='salaServlet?mode=list'>Listar</a>");
            out.println("</div>");
            out.println("<hr>");
            //HTML cad
            if(request.getParameter("mode")!=null && request.getParameter("mode").equals("cad")){
                out.println("<h2>Cadastrar Salas</h2>");
                out.println("<form action=\"salaServlet?mode=cad\" method=\"post\">");
                out.println("<table>\n<tr>");
                out.println("<td>Numero da Sala</td>");
                out.println("<td><input name=\"sala_value\" type=\"text\" size=\"50\" /></td>");
                out.println("</tr>\n</table>");
                out.println("</tr><tr>");
                out.println("<td>Numero do predio</td>");
                out.println("</tr><tr>");
                out.println("<td><input name=\"predio_value\" type=\"text\" size=\"50\"/></td>");
                out.println("<input name=\"btn_cadastrar\" type=\"submit\" value=\"Cadastrar\"/>\n</form>");
                //HTML edit
            }else if(request.getParameter("mode")!=null && request.getParameter("mode").equals("edit")){
                out.println("<h2>Editar Sala</h2>");
                out.println("<form action=\"salaServlet?mode=edit\" method=\"post\">");
                out.println("<table>\n<tr>");
                 out.println("<select id=\"salas\" name=\"salas\" onchange=\"changeFunc();\">");
                List<Sala> list = salaFacade.findAll();
                out.println("<option value=0 selected=\"true\">Selecione uma sala</option>");
                for (Sala sala : list) {
                    out.println("<option value="+sala.getCodigo()+">"+sala.toString()+"</option>" );
                }
                out.println("</select></tr>");
                if(request.getParameter("cod")!=null){
                    out.println("</tr><hr><tr>");
                    Sala sala = salaFacade.find(Integer.parseInt(request.getParameter("cod")));
                    out.println("<tr><td>"+sala.getCodigo()+"</td>");
                    out.println("<td><input name=\"cod_value\" type=\"hidden\" size=\"50\" value=\""+sala.getCodigo()+"\" /></td>");
                    out.println("<td>Predio</td>");
                    out.println("<td><input name=\"predio_value\" type=\"text\" size=\"50\" value=\""+sala.getNumeroPredio()+"\" /></td>");
                    out.println("<td>Sala</td>");
                    out.println("<td><input name=\"sala_value\" type=\"text\" size=\"50\" value=\""+sala.getNumeroSala()+"\"/></td>");
                    out.println("</tr>\n</table>");
                    out.println("<input name=\"btn_editar\" type=\"submit\" value=\"Editar\"/><input name=\"btn_deletar\" type=\"submit\" value=\"Deletar\"/>\n</form>");
                }
                //html list
            } else if(request.getParameter("mode")!=null && request.getParameter("mode").equals("list")){
                out.println("<h2>Salas Cadastrados</h2>");
                List<Sala> list = salaFacade.findAll();
                for (Sala sala : list) {
                    out.println(sala + "<br/>");
                }
            }
            //Request cadastrar
            if (request.getParameter("btn_cadastrar") != null && request.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    Sala sala = new Sala(request.getParameter("sala_value"),request.getParameter("predio_value"));
                    salaFacade.create(sala);
                    out.println("Sala cadastrada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Sala.\n");
                } finally {
                    out.println("</font>");
                }
                //Request editar
            }else if (request.getParameter("btn_editar") != null && request.getParameter("btn_editar").equals("Editar")) {
                try {
                    out.println("<font color=\"red\">");
                    Sala sala = salaFacade.find(Integer.parseInt(request.getParameter("cod_value")));
                    sala.setNumeroPredio(request.getParameter("sala_value"));
                    sala.setNumeroSala(request.getParameter("predio_value"));
                    salaFacade.edit(sala);
                    out.println("Sala alterada com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao editar Sala.\n");
                } finally {
                    out.println("</font>");
                }
                //Request deletar
            }else if (request.getParameter("btn_deletar") != null && request.getParameter("btn_deletar").equals("Deletar")) {
                try {
                    out.println("<font color=\"red\">");
                    Sala sala = salaFacade.find(Integer.parseInt(request.getParameter("cod_value")));
                    salaFacade.remove(sala);
                    out.println("Sala removida com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao deletar Sala.Ela pode estar sendo usada em outra tabela!\n");
                } finally {
                    out.println("</font>");
                }
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
