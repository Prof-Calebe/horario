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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GuilhermeA
 */
public class gradeServlet extends HttpServlet {
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
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\">");
            out.println("function changeFunc(){");      
            out.println("var selectBox = document.getElementById(\"selectbox\");");
            out.println("var selectedValue = selectBox.options[selectBox.selectedIndex].value;");
            out.println("var url = document.URL ;if(document.URL.indexOf('&cod') > 0)url=document.URL.substring(0,document.URL.indexOf(\"&cod\"));");
            out.println("if(selectedValue!=0) window.location.href=url+'&cod='+selectedValue;}</script>");

            out.println("<title>Servlet GradeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"header\" width='100%'>");
            out.println("<a href='gradeServlet?mode=disciplina'>Por disciplina</a>");
            out.println("<a href='gradeServlet?mode=turma'>Por Turma</a>");
            out.println("<a href='gradeServlet?mode=sala'>Por Sala</a>");
            out.println("<a href='gradeServlet?mode=professor'>Por Professor</a>");
            out.println("</div>");
            out.println("<hr>");
            //HTML disciplina  
            if(request.getParameter("mode") != null && request.getParameter("mode").equals("disciplina")){
                out.println("<h2>Grades Por Disciplinas</h2>");
                out.println("<select  id=\"selectbox\" name=\"selectbox\" onchange=\"changeFunc();\">");
                out.println("<option value=0 selected=\"true\">Selecione uma disciplina</option>");
                List<Disciplina> list = disciplinaFacade.findAll();
                for (Disciplina disc : list) {
                    out.println("<option value="+disc.getCodigo()+">"+disc.getNome()+"</option>" );
                }
                out.println("</select>");
                if(request.getParameter("cod")!=null){
                    int cod = (Integer.parseInt(request.getParameter("cod")));
                    List<Horario> lsHorarios = horarioFacade.findAll();
                    List<Horario> lsJoin = new ArrayList<Horario>();
                    for(Horario h : lsHorarios){
                        if(h.getDisciplina().getCodigo()==cod) lsJoin.add(h);
                    }
                    out.println("<hr>");
                    out.println("<table align='center' width='75%' height='75%' border='1' cellspacing='5' cellpadding='5' bgcolor='#F1F1F1'>");
                    String table = "<tr bgcolor='#FFFFFF'><th>Horario</th><th>Segunda</th><th>Terca</th><th>Quarta</th><th>Quinta</th><th>Sexta</th><th>Sabado</th></th>";
                    for(int i=1;i<=20;i++){
                        table += " <tr bgcolor='#FFFFFF' id=\""+i+"\"> ";
                        for(int j=0;j<7;j++){
                            table+="<td id='" +String.valueOf(i)+"."+String.valueOf(j)+"'> </td> ";
                        }
                        table+=" </tr> ";
                    }
                    for(Horario h : lsJoin){
                        table = table.replace("<td id='"+h.getHorario()+"."+h.getDia().ordinal()+"'>","<td>"+h.getDisciplina().getNome());
                        /*switch(h.getDia()){
                            case SEGUNDA:
                                out.println("<td>"+h.getHorario()+"</td>");
                                out.println("<td>"+h.getDisciplina().getNome()+"</td>");
                                break;
                            case TERCA:
                                break;
                            case QUARTA:
                                break;
                            case QUINTA:
                                break;
                            case SEXTA:
                                break;
                            case SABADO:
                                break;
                            default:
                        }*/
                    }
                    out.println(table);
                    out.println("</table>");
                    
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
