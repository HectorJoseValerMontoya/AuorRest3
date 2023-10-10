<%-- 
    Document   : pagAgregarEmpleado
    Created on : 8 oct. 2023, 18:12:48
    Author     : HJVM
--%>

<%@page import="modelo.PerfilEmpleado"%>
<%@page import="dao.DaoPerfilEmpleado"%>
<%@page import="dao.DaoEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Empleado</title>
    <link rel="stylesheet" href="css/botones.css">
    <link rel="stylesheet" href="css/select.css">
    <link rel="stylesheet" href="css/texto.css">
    <link rel="stylesheet" href="css/inputs.css">
</head>
<body>
    <%
        DaoPerfilEmpleado daoPerfilEmpleado = new DaoPerfilEmpleado(); 
        DaoEmpleado daoEmp = new DaoEmpleado();
    %>
    
    <center>
        <h1>BIENVENIDO A REGISTAR EMPLEADOS!!!</h1>

        <br><br>

        <label>Codigo de este empleado: <%=daoEmp.getSiguienteCodEmpleado()%></label>
        
        <form action="SEmpleado">
            <input type="hidden" name="op" value="1">
            <h2>Nombre del empleado</h2> <input type="text" name="nombreEmpleado">
            <h2>Apellido del empleado</h2> <input type="text" name="apellidoEmpleado">
            <h2>Cargo del empleado</h2>
            <select name="codPerfilEmpleado">
                <%
                    for(PerfilEmpleado perfil : daoPerfilEmpleado.getPerfilesEmpleado()){
                    %>
                    <option value="<%=perfil.getCodPerfilEmpleado()%>"><%=perfil.getCargoPerfilEmpleado()%></option>
                    <%
                    }
                %>
            </select>

            <h2>Contraseña del empleado</h2> <input type="password" name="contrasenaEmpleado">
            <br><br>
            <input class="boton-verde basico" type="submit" value="Agregar Empelado">
        </form>
            <br>
            <br>
            <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
</html>
