<%-- 
    Document   : pagEmpleados
    Created on : 8 oct. 2023, 18:54:40
    Author     : HJVM
--%>

<%@page import="dao.DaoPerfilEmpleado"%>
<%@page import="modelo.PerfilEmpleado"%>
<%@page import="modelo.Empleado"%>
<%@page import="dao.DaoEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-gradient-yellow cabecera">
                <div class="container">
                    <a class="navbar-brand" href="main.php">
                        <img src="img/logo resturante.png" alt="Bootstrap" width="130" height="80">
                    </a>
                </div>
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse textoCabecera" id="navbarNavDropdown">
                        <ul class="navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="main.jsp">Inicio</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-current="page" aria-expanded="false">Mesas</a>
                                <ul class="dropdown-menu">
                                    <li><a class="nav-link active"  aria-current="page" href="pagSeguirOrdenando.jsp">Seguir Ordenando</a></li>
                                    <li><a class="nav-link active"  aria-current="page" href="pagRealizarOrden.jsp">Realizar Orden</a></li>
                                    <li><a class="nav-link" href="pagAdministrarMesa.jsp">Administrar Mesas</a></li> 
                                    <li><a class="nav-link" href="pagCobrarMesa.jsp">Cobrar Mesa</a></li> 
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-current="page" aria-expanded="false">Administración</a>
                                <ul class="dropdown-menu">
                                    <li><a class="nav-link active"  aria-current="page" href="pagEmpleado.jsp">Empleados</a></li>
                                    <li><a class="nav-link" href="pagPlato.jsp">Platos</a></li> 
                                </ul>
                            </li>
                        </ul>
                        <a href="pagLogin.jsp"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>

        <%
            DaoEmpleado daoEmpleado = new DaoEmpleado();
            DaoPerfilEmpleado daoPerfilEmpleado = new DaoPerfilEmpleado();
        %>
        <div>
            <a class="basico botonRedondoTitulo boton-link-azul" href="pagRegistrarEmpleado.jsp">Nuevo Empleado</a>
            <a class="basico botonRedondoTitulo boton-link-azul" href="pagRegistrarPerfil.jsp">Nuevo Perfil</a>
        </div>
        <br>
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Empleados</button>
                <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Perfiles</button>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                <table class="table table-bordered">
                    <th>Codigo de Empleado<th>Nombre<th>Estado<th>Cargo<th>Editar / Eliminar
                        <%
                            for (Empleado e : daoEmpleado.getDatosEmpleadoYPerfilCompleto()) {
                                out.print("<tr><td>" + e.getCodEmpleado() + "<td>" + e.getNombreEmpleado() + " " + e.getApellidoEmpleado() + "<td>" + e.getTipoEstado() + "<td>" + e.getCargoPerfilEmpleado() + "<td>");
                        %>
                        <a class="basico botonRedondo boton-link-azul" href="pagEditarEmpleado.jsp?codEmpleado=<%=e.getCodEmpleado()%>">editar</a>
                        <a class="basico botonRedondo boton-link-rojo" href="SEmpleado?op=3&codEmpleado=<%=e.getCodEmpleado()%>">eliminar</a>
                        <%
                            }
                        %>
                </table>
            </div>
            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                <table class="table table-bordered">
                    <tr><th>Codigo<th>Cargo<th>Estado<th style="text-align: center;">Editar<th style="text-align: center;">Delete 
                            <%
                                for (PerfilEmpleado p : daoPerfilEmpleado.getPerfilesEmpleado()) {
                                    out.print("<tr><td>" + p.getCodPerfilEmpleado() + "<td>" + p.getCargoPerfilEmpleado() + "<td>" + p.getTipoEstado());
                            %>
                        <td style="text-align: center;">

                            <a class="basico botonRedondo boton-link-azul" href="pagEditarPerfil.jsp?cod=<%=p.getCodPerfilEmpleado()%>">Editar</a>
                        </td>

                        <td style="text-align: center;">
                            <a href="SPerfilEmpleado?op=3&cod=<%=p.getCodPerfilEmpleado()%>" class="btn btn-default">delete</a> 
                        </td> 
                        <%
                            }
                        %>
                </table>
            </div>
        </div>
    </body>
</html>
