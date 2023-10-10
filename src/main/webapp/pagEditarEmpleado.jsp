<%-- 
    Document   : pagEditarEmpleado
    Created on : 8 oct. 2023, 21:24:22
    Author     : HJVM
--%>

<%@page import="dao.DaoPerfilEmpleado"%>
<%@page import="modelo.Empleado"%>
<%@page import="modelo.PerfilEmpleado"%>
<%@page import="dao.DaoEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/inputs.css" rel="stylesheet" type="text/css"/>
        <link href="css/select.css" rel="stylesheet" type="text/css"/>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            int codigo = Integer.parseInt(request.getParameter("codEmpleado"));
            DaoEmpleado daoEmp = new DaoEmpleado();
            Empleado emp = daoEmp.getDatosEmpleadoConPerfilEmpleado(codigo);
            DaoPerfilEmpleado daoPerEmp = new DaoPerfilEmpleado();
        %>
    <center>
        <h1>BIENVENIDO A EDITAR EMPLEADO!!!</h1>
        <br />
        <h2>Datos anteriores del Empleado</h2>
        <br>
        <br>
        <label>Codigo de empleado: <%=emp.getCodEmpleado()%></label>
        <br>
        <br>
        <br>
        <label>Nombre: <%=emp.getNombreEmpleado()%></label>
        <br>
        <label>Apellido: <%=emp.getApellidoEmpleado()%></label>
        <br>
        <label>Contraseña: <%=emp.getContrasenaEmpleado()%></label>
        <br>
        <label>Perfil: <%=emp.getNombreTipoPerfil()%></label>
        <br>
        <label>Estado del empleado: <%=emp.getTipoEstado()%></label>

        <br><br>
        <form action="SEmpleado">
            <input type="hidden" name="op" value="2">
            <input type="hidden" name="codEmpleado" value="<%=emp.getCodEmpleado()%>">
            <h2>Datos nuevos del Empleado</h2>
            <br>
            <label>Nombre: </label><input type="text" name="nombreEmpleado" required="true" value="<%=emp.getNombreEmpleado()%>">
            <br>  
            <label>Apellido: </label> <input type="text" name="apellidoEmpleado" required="true" value="<%=emp.getApellidoEmpleado()%>">
            <br>
            <label>Contraseña: </label><input type="password" name="contra"required="true" value="<%=emp.getContrasenaEmpleado()%>">
            <br>
            <label>Perfil: </label>
            <select name="nuevoPerfilEmpleado">
                <%
                    for (PerfilEmpleado perfil : daoPerEmp.getPerfilesEmpleado()) {
                %>
                <option value="<%=perfil.getCodPerfilEmpleado()%>"><%=perfil.getCargoPerfilEmpleado()%></option>
                <%
                    }
                %>
            </select>
            <br><br>
            <label>Estado del empleado: </label>
            <select name="estado">
                <option value="1">Activado</option>
                <option value="2">Inactivado</option>
            </select>
            <br><br><br>
            
            <input class="boton-verde" type="submit" value="Editar">
        </form>
            <br>
            <br>
            <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
