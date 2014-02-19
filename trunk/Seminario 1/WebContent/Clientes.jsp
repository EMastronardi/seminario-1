<%@page import="java.util.ArrayList"%>
<%@page import="controler.Sistema"%>
<%@page import="views.ClienteVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ArrayList<ClienteVO> clientes = Sistema.getInstance().getClientesVO();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Seminario I - La Cocina de Silvia / Clientes</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/footable.core.css" rel="stylesheet" type="text/css"/>
	
<!-- Custom styles for this template -->


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->


<style>
table tr th {
	text-align: center;
}

table tr td {
	text-align: center;
}

table tr.information td {
	text-align: center;
	cursor: pointer;
}

table.estaciones {
	width: 300px;
	height: 60px;
}

table.estaciones tr td {
	text-align: left;
}

div.col-lg-6 button {
	float: left
}

div.col-lg-8 {
	float: right
}

select {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.428571429;
	color: #555555;
}
</style>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/Header.jsp" />
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="Home.jsp">Inicio</a></li>
				<li class="active">Clientes</li>
			</ol>

			<div class="page-header">
				<h1>Clientes</h1>
			</div>
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<button type="button" id="newCliente"
						class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-star"></span> Nuevo Cliente
					</button>
					<button type="button" id="updateCliente"
						class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-pencil"></span> Editar
					</button>
					<button type="button" id="deleteCliente"
						class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-trash"></span> Eliminar
					</button>
<!-- 					<button type="button" id="restriccionesCliente" -->
<!-- 						class="btn btn-default btn-sm"> -->
<!-- 						<span class="glyphicon glyphicon-pencil"></span> Editar Restricciones -->
<!-- 					</button> -->
				</div>
				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>Seleccionar</th>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Calle</th>
							<th>CP</th>
							<th>Localidad</th>
							<th>Telefono</th>
							<th>Hora Entrega</th>
							<th>Estado</th>
							<th>Restricciones</th>
					</thead>
					<tbody>
					<%
						for (ClienteVO cliente : clientes) {
							out.println("<tr><td><input type='checkbox' value='"
									+ cliente.getIdCliente()
									+ "' onClick=\"unChecked(this,'"
									+ cliente.getIdCliente() + "' )\"/></td>" + "<td>"
									+ cliente.getIdCliente() + "</td>" + "<td>"
									+ cliente.getNombre() + "</td>" + "<td>"
									+ cliente.getApellido() + "</td>" + "<td>"
									+ cliente.getCalle() + "</td>" + "<td>"
									+ cliente.getCP() + "</td>" + "<td>"
									+ cliente.getLocalidad() + "</td>" + "<td>"
									+ cliente.getTelefono() + "</td>" + "<td>"
									+ cliente.getHoraEntrega() + "</td>" + "<td>"
									+ cliente.getEstado() + "</td>" + "<td>"
									+ "<button type=\"button\" name=\""+cliente.getIdCliente()+"\" " 
									+ "id=\"restriccionesCliente"+cliente.getIdCliente()+"\" class=\"btn btn-default btn-sm restriccionesCliente\"><span class=\"glyphicon glyphicon-pencil\"></span> Restricciones"
									+"</button> </td></tr>");
						}
					%>
					</tbody>
				</table>
			</div>
			<!-- End content -->
			<jsp:include page="/Footer.jsp"  />
			<script type="text/javascript" src="js/ClienteRestriccionesABM.js"></script>
			<script type="text/javascript">
			
				var idUsuario = "";
				var usuario = "";
				var password = "";
				// Handler for .ready() called.
				$("#newCliente").click(function() {
					CreateUser();
				});
				$("#updateCliente").click(function() {
					FuncionalidadNoDisponible();
				});
				$("#deleteCliente").click(function() {
					FuncionalidadNoDisponible();
				});
				$(".restriccionesCliente").click(function(){
					selectRestriccionesCliente(this.name);
				});
// 				$("#restriccionesCliente").click(function() {
// 					if(idClienteChecked != null && idClienteChecked != "")
// 						selectRestriccionesCliente(idClienteChecked);
// 					else
// 					{
// 						bootbox.dialog({
// 							message : "<label>Debe seleccionar un Cliente\.</label>"
// 						});
// 					}
// 				});
			
				function CreateUser() {
					bootbox
							.dialog({
								message : "<form id='createCliente' method='post' action='ClienteServlet?action=createUser'>"
										+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" autofocus>"
										+ "<br/>"
										+ "<label>Apellido </label><input type=\"text\" class=\"form-control\" id='apellidoInput' name=\"apellido\" autofocus>"
										+ "<br/>"
										+ "<label>Calle </label><input type=\"text\" class=\"form-control\" id='calleInput' name=\"calle\" autofocus>"
										+ "<br/>"
										+ "<label>CP </label><input type=\"text\" class=\"form-control\" id='cpInput' name=\"cp\" autofocus>"
										+ "<br/>"
										+ "<label>Localidad </label><input type=\"text\" class=\"form-control\" id='localidadInput' name=\"localidad\" autofocus>"
										+ "<br/>"
										+ "<label>Telefono </label><input type=\"text\" class=\"form-control\" id='telefonoInput' name=\"telefono\" autofocus>"
										+ "<br/>"
										+ "<label>Hora Entrega </label><input type=\"text\" class=\"form-control\" id='horaEntregaInput' name=\"horaEntrega\" autofocus>"
										+ "<br/>"
										+ "<label>Estado </label><input type=\"text\" class=\"form-control\" id='estadoInput' name=\"estado\" autofocus>"
										+ "<br/>" + "</form>",
								title : "Agregar Cliente",
								buttons : {
									success : {
										label : "Confirmar",
										className : "btn-success",
										callback : function() {
											if ($("#nombreInput").val() != ''
													|| $("#apellidoInput")
															.val() != ''
													|| $("#calleInput").val() != ''
													|| $("#cpInput").val() != ''
													|| $("#localidadInput")
															.val() != ''
													|| $("#telefonoInput")
															.val() != ''
													|| $("#horaEntregaInput")
															.val() != ''
													|| $("#estadoInput").val() != '') {
												FuncionalidadNoDisponible();
											} else {
												alert("Para dar de alta un Cliente debe ingresar todos los campos");
											}
										}
									}
								}
							});

				};
			</script>
		</div>
	</div>
</body>
</html>
