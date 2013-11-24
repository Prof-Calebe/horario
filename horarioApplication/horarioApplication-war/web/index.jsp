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
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="menuServlet" method="post">
            <p>Login</p><input name="login" type=""/></br>
            <p>Senha</p><input name="senha" type="password"/></br>
            <input type="submit" value="Logar"/>
        </form>
    </body>
</html>
