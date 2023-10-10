<%-- 
    Document   : pagEditarCategoriaPlato
    Created on : 9 oct. 2023, 17:52:56
    Author     : HJVM
--%>

<%@page import="modelo.CategoriaPlato"%>
<%@page import="dao.DaoCategoriaPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Categoria de Plato</title>
        <link rel="stylesheet" href="css/botones.css" />
        <link rel="stylesheet" href="css/select.css" />
        <link rel="stylesheet" href="css/texto.css" />
        <link rel="stylesheet" href="css/inputs.css" />
    </head>
    <body>
        <%
            int _codCategoriaPlato = Integer.parseInt(request.getParameter("codCategoriaPlato"));
            DaoCategoriaPlato daoCP = new DaoCategoriaPlato();
            CategoriaPlato cp = daoCP.getCategoriaPlato(_codCategoriaPlato);
        %>
        <style>
            input, select, label {
                margin-bottom: 20px;
            }
        </style>
    <center>
        <h1>EDITAR CATEGORIA DE PLATO !!!</h1>
        <br>
        <form action="SCategoriaPlato">
            <input type="hidden" name="op" value="2" />
            <input type="hidden" name="codCategoriaPlato" value="<%=_codCategoriaPlato%>">
            <label>Código de categoria: " <%=cp.getCodCategoriaPlato()%> "</label>
            <br />
            <br />
            <br />
            <label>Nombre de categoria: </label>
            <input type="text" value="<%=cp.getNombreCategoria()%>" name="nombreCategoriaPlato" required="true" />
            <br />
            <input class="basico boton-verde" type="submit" value="Editar Categoria del Plato"/>
        </form>
        <br>
        <br>
        <a class="basico botonRedondoTitulo  boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
