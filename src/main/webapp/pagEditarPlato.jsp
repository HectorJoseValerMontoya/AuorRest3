<%-- 
    Document   : pagEditarPlato
    Created on : 9 oct. 2023, 16:41:56
    Author     : HJVM
--%>

<%@page import="dao.DaoPlato"%>
<%@page import="modelo.Plato"%>
<%@page import="modelo.CategoriaPlato"%>
<%@page import="dao.DaoCategoriaPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Plato</title>
        <link rel="stylesheet" href="css/botones.css">
        <link rel="stylesheet" href="css/select.css">
        <link rel="stylesheet" href="css/texto.css">
        <link rel="stylesheet" href="css/inputs.css">
    </head>
    <body>
        <%
            DaoCategoriaPlato daoCP = new DaoCategoriaPlato();
            int codigoPlato = Integer.parseInt(request.getParameter("codigoPlato"));
            DaoPlato daoP = new DaoPlato();
            Plato p = daoP.getDatosPlato(codigoPlato);
        %>
        <style>
            input, select, label {
                margin-bottom: 20px;
            }
        </style>

    <center>
        <h1>BIENVENIDO A EDITAR PLATO !!!</h1>
        <label>Codigo del plato: <%=codigoPlato%></label>
        <br />
        <br />
        <form action="SPlato">
            
            
            <input type="hidden" name="op" value="2">
            <input type="hidden" name="codigoPlato" value="<%=codigoPlato%>">
            <label>Nombre del plato: </label> <input type="text" value="<%=p.getNombrePlato()%>" name="nombrePlato" required="true" />
            <br />
            <label>Precio del plato: </label>
            <input type="number" value="<%=p.getPrecioPlato()%>" name="precioPlato" required="true" />
            <br />
            <label>Categoria: </label>
            <select name="codCategoria">
                <%
                    for(CategoriaPlato cp : daoCP.getListarCategoriaPlatosTotal()){
                    %>
                    <option value="<%=cp.getCodCategoriaPlato()%>"><%=cp.getNombreCategoria()%></option>
                    <%
                    }
                %>
            </select> <label>Categoria Anterior: <%=p.getNombreTipoCategoria()%></label> 
            <br />
            <input class="boton-verde basico" type="submit" value="Editar plato" />
            
            
        </form>
        <br>
        <br>
        <a class="basico botonRedondoTitulo  boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
