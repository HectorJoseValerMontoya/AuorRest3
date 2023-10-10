<%-- 
    Document   : pagAgregarPerfil
    Created on : 8 oct. 2023, 19:18:39
    Author     : HJVM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Empleado</title>
        <link rel="stylesheet" href="css/botones.css">
        <link rel="stylesheet" href="css/select.css">
        <link rel="stylesheet" href="css/texto.css">
        <link rel="stylesheet" href="css/inputs.css">
    </head>
    <body>

    <center>
        <h1>BIENVENIDO A REGISTAR EMPLEADOS!!!</h1>

        <br><br>

        <form action="SPerfilEmpleado">
            <input type="hidden" name="op" value="1">
            <h2>Nombre del cargo</h2> <input type="text" name="nombrePerfilEmpleado">
            <br><br>
            <input class="boton-verde basico" type="submit" value="Agregar Cargo">
        </form>
        <br>
            <br>
            <a class="basico botonRedondoTitulo boton-link-azul" onclick="history.back();">Retroceder</a>
    </center>
</body>
</html>
