<%-- 
    Document   : pagAgregarPlato
    Created on : 9 oct. 2023, 12:21:12
    Author     : HJVM
--%>

<%@page import="modelo.CategoriaPlato"%>
<%@page import="dao.DaoCategoriaPlato"%>
<%@page import="dao.DaoPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Plato!!!</title>
        <link rel="stylesheet" href="css/botones.css">
        <link rel="stylesheet" href="css/select.css">
        <link rel="stylesheet" href="css/texto.css">
        <link rel="stylesheet" href="css/inputs.css">
    </head>
    <body>
        <style>
            input {
                margin-bottom: 20px;
            }
            select {
                margin-bottom: 20px;
            }
        </style>

        <%
            DaoPlato daoPlato = new DaoPlato();
            DaoCategoriaPlato daoCP = new DaoCategoriaPlato();
        %>

    <center>
        <h1>BIENVENIDO A AGREGAR PLATO !!!</h1>

        <form action="SPlato">
            <input type="hidden" name="op" value="1">
            <input type="hidden" name="codPlato" value="<%=daoPlato.getSiguienteCodigoPlato()%>">
            <label>Codigo del plato: <%=daoPlato.getSiguienteCodigoPlato()%></label>
            <br />
            <br />
            <br />
            <label>Nombre del plato: </label><input type="text" name="nombrePlato" required="true"/>
            <br />
            <label>Precio del plato: </label><input type="number" name="precioPlato"  required="true"/>
            <br />
            <select name="categoriaDelPlato">
                <%
                    for (CategoriaPlato cp : daoCP.getListarCategoriaPlatosTotal()) {
                %>
                <option value="<%=cp.getCodCategoriaPlato()%>"><%=cp.getNombreCategoria()%></option>
                <%
                    }
                %>
            </select>
            <br />
            <label>Imagen del plato: </label> <input type="file" name="imagenPlato"/>
            <br>
            <input class="boton-verde basico" type="submit" value="Agregar Plato">
        </form>
        <br>
        <br>
        <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
