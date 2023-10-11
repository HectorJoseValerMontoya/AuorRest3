<%-- 
    Document   : pagCobrarMesa
    Created on : 10 oct. 2023, 14:43:38
    Author     : HJVM
--%>

<%@page import="modelo.Mesa"%>
<%@page import="dao.DaoMesa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cobrar Mesa</title>
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

        <%DaoMesa daoMesa = new DaoMesa();%> 
        <style>
            .img{
                margin-right: 100px;
            }
        </style>
    <center>
        <br>
        <h1>Seleccione la mesa a cobrar.</h1>
        <br>
    </center>
    <table border="0" class="table ">

        <tbody>
            <%
                int c = 0;
                out.print("<tr>");
                for (Mesa mesa : daoMesa.getMesas()) {
            %>
        <td>
            <%
                int estadoAPoner = 2;
                if (mesa.getEstadoMesa() == estadoAPoner) {
            %>
            <a href="pagDetalleCobrar.jsp?codMesa=<%=mesa.getCodMesa()%>">
                <%
                    }
                %>
                <img class="img" src="<%=mesa.getImgMesa()%>" alt="<%=mesa.getDescripcion()%>" width="250px"/>
                <br>
                <label><%=mesa.getDescripcion()%> | Mesa N° <%=mesa.getCodMesa()%> | (<%=mesa.getEstadoACancelar()%>)</label>

                <%
                    if (mesa.getEstadoMesa() == estadoAPoner) {
                %>
            </a>
            <%
                }
            %>
        </td>
        <%
            c++;
            if (c == 3) {
                c = 0;
        %>
        <tr>
            <%
                    }
                }
            %>
            </tbody>
    </table>




    <!--
        1) Escoger Mesa
        2) Escoges Categoria
        3) Escoges plato con cantidad
        4) Regresa al paso 2
    -->

</body>
</html>
