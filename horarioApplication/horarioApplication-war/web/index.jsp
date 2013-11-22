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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu</h1>
        <a href="disciplinaServlet?mode=cad">Disciplinas</a><br/>
        <a href="horarioServlet?mode=cad">Horarios</a><br/>
        <a href="professorServlet?mode=cad">Professores</a><br/>
        <a href="salaServlet?mode=cad">Sala</a><br/>
        <a href="reservaServlet">Reservas</a><br/>
    </body>
</html>
