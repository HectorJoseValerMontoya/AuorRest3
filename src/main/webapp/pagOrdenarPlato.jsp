<%-- 
    Document   : pagOrdenarPlato
    Created on : 10 oct. 2023, 18:25:33
    Author     : HJVM
--%>

<%@page import="modelo.Plato"%>
<%@page import="dao.DaoPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordenar Plato</title>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminlte.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/botones.css" rel="stylesheet" type="text/css"/>
        <link href="css/inputs.css" rel="stylesheet" type="text/css"/>
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
                        <a href="login.jsp"><button class="btn btn-danger" type="submit">Cerrar Sesion</button></a>
                    </div>
                </div>
            </nav>
        </header>

        <%
            DaoPlato daoP = new DaoPlato();
            int codMesa = Integer.parseInt(request.getParameter("codMesa"));
            int codCategoriaPlato = Integer.parseInt(request.getParameter("codCategoriaPlato"));
            int codOrden = Integer.parseInt(request.getParameter("codOrden"));
            
        %>
<br>
            <br>
            <br>
            
        <table border="0" class="table table-bordered">
            <tbody>
                <%
                    int c = 0;
                    out.print("<tr>");
                    for (Plato p : daoP.getListarPlatosActivosDeCategoria(codCategoriaPlato)) {
                %>
            <td>
            <center>
                <form action="SDetalleOrden">
                    <input type="hidden" name="op" value="1">
                    <input type="hidden" name="codMesa" value="<%=codMesa%>">
                    <input type="hidden" name="codPlato" value="<%=p.getCodPlato()%>">
                    <input type="hidden" name="codOrden" value="<%=codOrden%>">
                    <img src="<%=p.getImgPlato()%>" alt="<%=p.getImgPlato()%>" width="100px"/>
                    <br>
                    <label><%=p.getNombrePlato()%></label>
                    <br>
                    <input type="number" name="cantidadDePlato" min="0" placeholder="Cantidad..." required="true" value="0">
                    <br>
                    <input class="basico boton-azul" type="submit" value="Agregar +">
                </form>
            </center>
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
            

</body>
</html>
