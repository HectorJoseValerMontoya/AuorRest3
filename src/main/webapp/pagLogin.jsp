<%-- 
    Document   : login
    Created on : 8 oct. 2023, 16:48:02
    Author     : HJVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pollería El Dorado</title>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color: rgb(255, 227, 142); text-align: -webkit-center;">


        <h1 style="padding-top:40px;">Polleria el dorado</h1>
        <form action="SLogin" method="post">
            <input type="hidden" name="op" value="1">
            <div style="background-color: white; width: 40%; align-content: center; padding: 50px 30px; border-radius: 21px; ">
                <h3 style=" font-weight: 900; padding-bottom: 20px;">Login</h3>
                <h4 style="text-align: left;">usuario</h4>
                <input name="user" class="form-control" type="number" placeholder="usuario" required="true">

                <h4 style="text-align: left;">contraseña</h4>
                <input name="contra" class="form-control" type="password" placeholder="contraseña" required="true" style="margin-bottom: 20px;">
                <input class="btn btn-danger btn-lg" type="submit" value="Ingresar">
            </div>
        </form>

        <a href="pagRegistrarEmpleado.jsp">Registrese nuevo empleado!!!</a>
        <br>
        <%
            if (request.getParameter("error") != null) {
                int error = Integer.parseInt(request.getParameter("error"));
                if (error != 0) {
                    switch (error) {
                        case 1:
        %>
        <label>Usuario NO Encontrado</label>
        <%
                break;
            case 2:
        %>
        <label>Contraseña Erronea</label>
        <%
                            break;
                    }
                }
            }
        %>
    </body>
</html>
