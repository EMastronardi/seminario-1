<%@page import="modelo.EnumTipoPlato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="controler.Sistema"%>
<%@page import="views.PlatoVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
	ArrayList<PlatoVO> platos = Sistema.getInstance().getPlatos();
	Map<Integer,String> tags = Sistema.getInstance().getTags();
	
%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Seminario I - La Cocina de Silvia</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

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
				<li class="active">Platos</li>
			</ol>

			<div class="page-header">
				<h1>Platos</h1>
			</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<button type="button" id="newPlato" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-star"></span> Nuevo Plato
				</button>
				<button type="button" id="updatePlato"
					class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-pencil"></span> Editar
				</button>
				<button type="button" id="deletePlato"
					class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-trash"></span> Eliminar
				</button>
			</div>
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th>Check</th>
						<th>ID</th>
						<th>Nombre</th>
						<th>Tipo</th>
						<th>Tag</th>
						<th>Receta</th>
						<th>Restricciones</th>
				</thead>
				<tbody>
				<%
						for (PlatoVO p : platos) {
							out.println("<tr><td><input type='checkbox' value='"
									+ p.getIdPlato()
									+ "' onClick=\"unChecked(this,'"
									+ p.getIdPlato() + "' )\"/></td>" + "<td>"
									+ p.getIdPlato() + "</td>" + "<td>"
									+ p.getNombre() + "</td>" + "<td>"
									+ p.getTipoPlato() + "</td>" + "<td>"
									+ p.getTag() + "</td>" + "<td>"
									+ "<button type=\"button\" name=\""+p.getIdPlato()+"\" " 
									+ "id=\"recetaPlato"+p.getIdPlato()+"\" class=\"btn btn-default btn-sm recetaPlato\"><span class=\"glyphicon glyphicon-pencil\"></span> Ver Receta</button> </td>"
									+"<td>"
									+ "<button type=\"button\" name=\""+p.getIdPlato()+"\" " 
									+ "id=\"restriccionesPlato"+p.getIdPlato()+"\" class=\"btn btn-default btn-sm restriccionesPlato\"><span class=\"glyphicon glyphicon-pencil\"></span> Ver Restricciones</button> </td>"
									+"</tr>");
						}
					%>
				</tbody>
			</table>
		</div>
		<!-- End content -->
		<jsp:include page="/Footer.jsp" />
		<script type="text/javascript" src="js/PlatosABM.js"></script>
		<script type="text/javascript">
		var tipoPlato = new Array();
		var tags = new Array();
		var stringTags = "";
		<%
		int i = 0;
		for (EnumTipoPlato tp : EnumTipoPlato.values()) {
			  // do what you want
			  out.println("tipoPlato["+i+"]=\""+tp.name()+"\";");
			  i++;
			}
		%>

		<% 
		int j = 0;
		Iterator itera = tags.entrySet().iterator();
		while(itera.hasNext()){
			
		}
		
		%>
	var idUsuario = "";
	var usuario = "";
	var password = "";
	// Handler for .ready() called.
	$("#newPlato").click(function() {
		CreatePlato();
	});
	$(".recetaPlato").click(function(){
		selectRecetaPlato(this.name);
	});
	$(".restriccionesPlato").click(function(){
		selectRestriccionesPlato(this.name);
	});
	function CreatePlato() {
		var options="";
		for(var i=0; i<tipoPlato.length;i++){
			options+="<option value='"+tipoPlato[i]+"'>"+tipoPlato[i]+"</option>";
		}
		bootbox
				.dialog({
					message : "<form id='createPlato' method='post' action='PlatonteServlet?action=createPlato'>"
							+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" autofocus>"
							+ "<br/>"
							+ "<label>Tipo </label><select name=\"tipo\">"+options+"</select>"
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
										|| $("#apellidoInput").val() != ''
										|| $("#calleInput").val() != ''
										|| $("#cpInput").val() != ''
										|| $("#localidadInput").val() != ''
										|| $("#telefonoInput").val() != ''
										|| $("#horaEntregaInput").val() != ''
										|| $("#estadoInput").val() != '') {
									$("#createPlato").submit();
								} else {
									alert("Para dar de alta un Plato debe ingresar todos los campos");
								}
							}
						}
					}
				});
	};


	/*$("#updateUser").click(function() {
	updateUser();
	});
	$("#deleteUser").click(function() {
	deleteUser();
	});*/
	/*function unChecked(obj, useridSelect, userselect, passelect) {
		var checks = $(":checkbox");
		for (var i = 0; i < checks.length; i++) {
			if (checks[i] != obj)
				checks[i].checked = false;
		}
		idUsuario = useridSelect;
		usuario = userselect;
		password = passelect;
	}
	 function updateUser() {
		bootbox
				.dialog({
					message : "<form id='updateuser' method='post' action='UsersServlet?action=updateUser'>"
							+ "<input type='hidden' name='iduser' value='"+idUsuario+"'/>"
							+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nameinput' name=\"usuario\" value='"+usuario+"' autofocus>"
							+ "<br/>"
							+ "<label>Password </label><input type=\"password\" class=\"form-control\" id='passinput' value='"+password+"' name=\"password\">"
							+ "</form>",
					title : "Actualizar Usuario",
					buttons : {
						success : {
							label : "Confirmar",
							className : "btn-success",
							callback : function() {
								if ($("#nameinput").val() != ''
										|| $("#passinput").val() != '') {
									$("#updateuser").submit();
								} else {
									alert("Para dar de alta un usuario debe ingresar todos los campos");
								}
							}
						}
					}
				});
	}
	function deleteUser() {
		bootbox
				.dialog({
					message : "<h3>Esta seguro que desea eliminar a "
							+ usuario
							+ " como usuario del sistema?</h2>"
							+ "<form id='deleteuser' method='post' action='UsersServlet?action=deleteUser'>"
							+ "<input type='hidden' name='iduser' value='"+idUsuario+"'/>"
							+ "</form>",
					title : "Eliminar Usuario",
					buttons : {
						success : {
							label : "Confirmar",
							className : "btn-success",
							callback : function() {
								$("#deleteuser").submit();
							}
						},
						main : {
							label : "Cancelar",
							callback : function() {
							}
						}
					}
				});
	} */
	
</script>
	</div>
	</div>
</body>
</html>
