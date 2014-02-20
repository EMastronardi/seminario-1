<%@page import="views.OrdenDeCompraVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controler.Sistema"%>
<%@page import="views.ClienteVO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ArrayList<OrdenDeCompraVO> ocs = Sistema.getInstance().getOrdenesDeCompraVO();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Seminario I - La Cocina de Silvia / Ordenes de Compra</title>

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
				<li class="active">Ordenes de Compra</li>
			</ol>

			<div class="page-header">
				<h1>Ordenes de Compra</h1>
			</div>
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<div class="row">
            		<div class="col-lg-6">
						<button type="button" id="updateMenu"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil"></span> Editar OC
						</button>
						<button type="button" id="deleteMenu"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-trash"></span> Eliminar OC
						</button>
					</div>   
            	 	<div class="col-lg-6">
		            	<div class="row">
						  <div class="col-lg-8">
						    <div class="input-group">
						      <input type="text" class="form-control" id="valorinput" name="valor" value="">
						      <span class="input-group-btn">
						        <button class="btn btn-default">Buscar!</button>
						      </span>
						    </div>
						  </div>
						  </div>
					 </div>
			    	</div>
				</div>
				
				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>Seleccionar</th>
							<th>Nro OC</th>
							<th>Fecha Creacion</th>
							<th>Fecha Inicio Plan</th>
							<th>Estado</th>
							<th>Items</th>
					</thead>
					<tbody>
					<%
					DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
						for (OrdenDeCompraVO oc: ocs) {
							out.println("<tr><td><input type='checkbox' value='"
									+ oc.getIdOrdenDecompra()
									+ "' onClick=\"unChecked(this,'"
									+ oc.getIdOrdenDecompra() + "' )\"/></td>" + "<td>"
									+ oc.getIdOrdenDecompra() + "</td>" + "<td>"
									+ fecha.format(oc.getFechaCreacion()) + "</td>" + "<td>"
									+ fecha.format(oc.getFechaInicioPlan()) + "</td>" + "<td>"
									+ oc.getEstado().toString()+ "</td>" + "<td>"
									+ "<button type=\"button\" name=\""+oc.getIdOrdenDecompra()+"\" " 
									+ "id=\"restriccionesCliente"+oc.getIdOrdenDecompra()+"\" class=\"btn btn-default btn-sm restriccionesCliente\"><span class=\"glyphicon glyphicon-pencil\"></span> Ver"
									+"</button> </td></tr>");
						}
					%>
					</tbody>
				</table>
			</div>
			<!-- End content -->
			<jsp:include page="/Footer.jsp"  />
			<script type="text/javascript" src="js/OrdenDeCompraABM.js"></script>
			<script type="text/javascript">
			
				var idUsuario = "";
				var usuario = "";
				var password = "";
				// Handler for .ready() called.
				$("#newCliente").click(function() {
					FuncionalidadNoDisponible();
				});
				$("#updateCliente").click(function() {
					FuncionalidadNoDisponible();
				});
				$("#deleteCliente").click(function() {
					FuncionalidadNoDisponible();
				});
				$(".restriccionesCliente").click(function(){
					selectIngredientesOC(this.name);
				});
			
			</script>
		</div>
	</div>
</body>
</html>
