<%-- 
    Document   : pagAgregarCategoriaPlato
    Created on : 9 oct. 2023, 13:05:11
    Author     : HJVM
--%>

<%@page import="dao.DaoCategoriaPlato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Categoria de Plato !!!</title>
        <link rel="stylesheet" href="css/botones.css">
        <link rel="stylesheet" href="css/select.css">
        <link rel="stylesheet" href="css/texto.css">
        <link rel="stylesheet" href="css/inputs.css">
    </head>
    <body>
        <% DaoCategoriaPlato daoCP = new DaoCategoriaPlato(); %>
        <style>
            input {
                margin-bottom: 20px;
            }
            select {
                margin-bottom: 20px;
            }
        </style>

    <center>
        <h1>BIENVENIDO A AGREGAR CATEGORIA DE PLATO !!!</h1>

        <form action="SCategoriaPlato">
            <input type="hidden" name="op" value="1">
            <label>Codigo del plato: <%=daoCP.getSiguienteCodigoPlato()%></label>
            <br />
            <br />
            <br />
            <label>Nombre de la categoria del plato: </label><input type="text" name="nombrePlato" required="true"/>
            <br />
            <input class="boton-verde basico" type="submit" value="Agregar Categoria Del Plato">
        </form>
        <br>
        <br>
        <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
