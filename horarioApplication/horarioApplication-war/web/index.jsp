<%-- 
    Document   : index
    Created on : Nov 19, 2013, 10:04:39 AM
    Author     : guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
    </head>
    <body>
        <h1>Menu</h1>
        <h2>Cadastros/Edição</h2>
        <a href="disciplinaServlet?mode=cad">Disciplinas</a><br/>
        <a href="horarioServlet?mode=cad">Horarios</a><br/>
        <a href="professorServlet?mode=cad">Professores</a><br/>
        <a href="salaServlet?mode=cad">Sala</a><br/>
        <a href="reservaServlet?mode=cad">Reservas</a><br/>
        <h2>Grades</h2>
        <a href="gradeServlet?mode=disciplina">Por Disciplinas</a><br/>
        <a href="gradeServlet?mode=turma">Por Turma</a><br/>
        <a href="gradeServlet?mode=sala">Por Sala</a><br/>
        <a href="gradeServlet?mode=professor">Por Professor</a><br/>
    </body>
</html>
