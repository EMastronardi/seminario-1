<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Cocina de Silvia</title>
</head>
<body>
<% String cadena = ""; 
if(request.getParameter("usuario") != null){
	cadena = "Usuario invalido!!!";
	} 
%>
<h1 style="color: #9FCF21; font-family: Verdana, Arial, Sans-Serif">Login</h1>
	<div class="content">

	<form action="Controlador?action=validarLogin" method="post">
		<table >
			<tr>
				<td><span style="line-height: normal; font-family: Verdana, Arial, Sans-Serif; font-weight: bold">Usuario</span></td>
				<td><input type="text" name="usuario"
					style="cursor: text; height: auto; width: 138px; font-weight: normal"></td>
			</tr>
			<tr>
				<td><span style="font-family: Verdana, Arial, Sans-Serif; font-weight: bold">Contraseña</span></td>
				<td><input type="password" name="contrasenia" style="width: 138px;"></td>
			</tr>
			<tr>
		</table>
		<input type="submit" value="Aceptar" style="width: 289px; font-style: normal; font-family: Verdana, Arial, Sans-Serif">
		<span><%= cadena %></span>
		
	</form>
	</div>
</body>
</html>