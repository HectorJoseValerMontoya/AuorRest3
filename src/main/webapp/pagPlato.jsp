<%-- 
    Document   : pagPlatos
    Created on : 9 oct. 2023, 00:25:43
    Author     : HJVM
--%>

<%@page import="modelo.CategoriaPlato"%>
<%@page import="dao.DaoCategoriaPlato"%>
<%@page import="modelo.Plato"%>
<%@page import="dao.DaoPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Platos</title>
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
                                    <li><a class="nav-link active"  aria-current="page" href="pagRealizarOrden.jsp">Realizar Orden</a></li>
                                    <li><a class="nav-link" href="pagAdministrarMesas.jsp">Administrar Mesas</a></li> 
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
                        <a href="login.jsp"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>
        <%
            DaoPlato daoPlato = new DaoPlato();
            DaoCategoriaPlato daoCategPlato = new DaoCategoriaPlato();
        %>
        <div>
            <a class="basico botonRedondoTitulo boton-link-azul" href="pagAgregarPlato.jsp">Agregar Plato</a>
            <a class="basico botonRedondoTitulo boton-link-azul" href="pagAgregarCategoriaPlato.jsp">Agregar Categoria Platos</a>
        </div>
        <br>
        <div>
            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Platos</button>
                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Categorias</button>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
                    <table class="table table-bordered">
                        <th class="col-sm-1">Codigo de Plato<th>Plato<th>Precio<th>Categoria<th>Editar<th>Eliminar</th>
                            <%
                                for (Plato p : daoPlato.getListarPlatosActivos()) {
                                    out.print("<tr><td>" + p.getCodPlato() + "<td>" + p.getNombrePlato() + "<td>" + p.getPrecioPlato() + "<td>" + p.getNombreCategoria());
                            %>
                        <td style="text-align: center;"><a class="basico botonRedondo boton-link-azul" href="pagEditarPlato.jsp?codigoPlato=<%=p.getCodPlato()%>">Editar</a></td>
                        <td style="text-align: center;"><a class="basico botonRedondo boton-link-rojo" href="SPlato?op=3&codigoPlato=<%=p.getCodPlato()%>">Eliminar</a></td>
                        <%
                            }
                        %>
                    </table>
                </div>
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab" tabindex="0">
                    <table class="table table-bordered">
                        <th>Codigo<th>Categoria 
                            <%
                                for (CategoriaPlato p : daoCategPlato.getListarCategoriaPlatosActivos()) {
                                    out.print("<tr><td>" + p.getCodCategoriaPlato() + "<td>" + p.getNombreCategoria() + "<td>");%>
                            <a style="text-align: center;" class="basico botonRedondo boton-link-azul" href="pagEditarCategoriaPlato.jsp?codCategoriaPlato=<%=p.getCodCategoriaPlato()%>">Editar</a>
                            <a style="text-align: center;" class="basico botonRedondo boton-link-rojo" href="SCategoriaPlato?op=3&codCategoriaPlato=<%=p.getCodCategoriaPlato()%>">Eliminar</a>
                            <%
                                }
                            %>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
