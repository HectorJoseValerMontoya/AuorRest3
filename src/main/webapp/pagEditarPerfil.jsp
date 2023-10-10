<%-- 
    Document   : pagEditarPerfil
    Created on : 8 oct. 2023, 21:24:33
    Author     : HJVM
--%>

<%@page import="modelo.PerfilEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.DaoPerfilEmpleado" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>
        <link href="css/inputs.css" rel="stylesheet" type="text/css"/>
        <link href="css/select.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <style>
            input{
                margin-bottom: 20px;
            }
        </style>

        <%
            int perfilEpleado = Integer.parseInt(request.getParameter("cod"));
            DaoPerfilEmpleado daoPerEmp = new DaoPerfilEmpleado();
            PerfilEmpleado perEmp = daoPerEmp.getPerfilEmpleado(perfilEpleado);
        %>

    <center>
        <h1>BIENVENIDO A EDITAR EMPLEADO!!!</h1>
        <br />
        <label>Codigo de perfil: <%=perEmp.getCodPerfilEmpleado()%></label>
        <br />
        <br />
        <br />
        <label>Nombre de perfil: <%=perEmp.getCargoPerfilEmpleado()%></label>
        <br />
        <label>Estado del perfil: <%=perEmp.getTipoEstado()%></label>
        <br />
        <br />
        <br />
        <br />
        <form action="SPerfilEmpleado">
            <input type="hidden" name="op" value="2">
            <input type="hidden" name="codPerfil" value="<%=perEmp.getCodPerfilEmpleado()%>">
            <label>Nombre de perfil: </label> <input type="text" name="nombrePerfil" value="<%=perEmp.getCargoPerfilEmpleado()%>">
            <br />
            <label>Estado del perfil: </label> 
            <select name="estado">
                <option value="1">Activado</option>
                <option value="2">Inactivado</option>
            </select>

            <br><br>
            <input class="boton-link-verde basico" type="submit" value="Editar">
            <br>
            <br>
            <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
        </form>
    </center>
</body>
</html>
