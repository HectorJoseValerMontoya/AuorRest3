<%-- 
    Document   : pagDetalleCobrar
    Created on : 10 oct. 2023, 23:44:06
    Author     : HJVM
--%>

<%@page import="modelo.Plato"%>
<%@page import="dao.DaoPlato"%>
<%@page import="modelo.Orden"%>
<%@page import="dao.DaoOrden"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle a cobrar</title>
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

    <center>
        <br>
        <h1>Detalle de la orden.</h1>
        <br>
    </center>

    <%
        DaoOrden daoO = new DaoOrden();
        DaoPlato daoP = new DaoPlato();
        
        int codMesa = Integer.parseInt(request.getParameter("codMesa"));
    %>

    <table class="table table-bordered" border="1">
        <thead>
            <tr>
                <th><center>Nombre del plato</center></th>
                <th><center>Estado</center></th>
                <th><center>Precio U.</center></th>
                <th><center>Cantidad</center></th>
                <th><center>Monto</center></th>
            </tr>
        </thead>
        <tbody>
            <%
                double montoTotal = 0;
                for (Orden o : daoO.getListarOrdenes(daoO.getCodOrden(codMesa))) {
                    Plato p = daoP.getDatosPlato(o.getCodPlato());
                    montoTotal += p.getPrecioPlato() * o.getCantidad();
            %>
                <tr>
        <center></center>
                <td><center><%=p.getNombrePlato()%></center></td>
                <td><center><%=o.getNombreEstadoDetalleOrden()%></center></td>
                <td><center><%=p.getPrecioPlato()%></center></td>
                <td><center><%=o.getCantidad()%></center></td>
                <td><center><%=p.getPrecioPlato() * o.getCantidad()%></center></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
        
            <label>MontoTotal: <u><%=montoTotal%></u>   Soles</label>
        
        <br>
        <br>
        <br>
        
        <form action="SDetalleOrden">
            <input type="hidden" name="op" value="2">
            <input type="hidden" name="montoTotal" value="<%=montoTotal%>">
            <input type="hidden" name="codMesa" value="<%=codMesa%>">
            <label>Monto con cuanto pagar</label>
            <input type="number" name="montoDeCobro" min="0" value="<%=montoTotal%>">
            <label> Soles</label>
            <br>
            <br>
            <center>
                <input type="submit" class="basico boton-azul botonRedondoTitulo" value=" Pagar ">
            </center>
        </form>
            
            <%
                if (request.getParameter("error") != null){
                    %>
                    <label style="color: red;"><%=request.getParameter("error")%></label>
                    <%
                }
            %>

</html>
