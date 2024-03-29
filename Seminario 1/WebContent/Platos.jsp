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
	Map<Integer, String> tags = Sistema.getInstance().getTags();
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
			<p class="lead">
			   <div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
            	<div class="row">
            		<div class="col-lg-6">
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
			<table class="table footable" data-page-size="8" data-limit-navigation="3" id="platosTable">
			
				<thead>
					<tr>
						<th>Check</th>
						<th>ID</th>
						<th>Nombre</th>
						<th>Tipo</th>
						<th>Tag</th>
						<th>Ingredientes y Receta</th>
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
									+ "id=\"recetaPlato"+p.getIdPlato()+"\" class=\"btn btn-default btn-sm recetaPlato\"><span class=\"glyphicon glyphicon-pencil\"></span> Ver </button> </td>"
									+"<td>"
									+ "<button type=\"button\" name=\""+p.getIdPlato()+"\" " 
									+ "id=\"restriccionesPlato"+p.getIdPlato()+"\" class=\"btn btn-default btn-sm restriccionesPlato\"><span class=\"glyphicon glyphicon-pencil\"></span> Ver </button> </td>"
									+"</tr>");
						}
					%>
				</tbody>
				<tfoot><tr><td colspan="7"><div class="pagination pagination-centered hide-if-no-paging"></div></td></tr></tfoot>
		
			</table>
		</div>
		</p>
		<!-- End content -->
		<jsp:include page="/Footer.jsp" />
		<script type="text/javascript" src="js/PlatosABM.js"></script>
		<script type="text/javascript">
		$('.footable').footable();
		var tipoPlato = new Array();
		var tags = new Array();
		var tag = new Array();
		
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
		while(itera.hasNext()) {
			Map.Entry me = (Map.Entry)itera.next();
			out.println("var tag"+j+"= new Array();");
			out.println("tag"+j+"['id']=\""+me.getKey()+"\";");
			out.println("tag"+j+"['value']=\""+me.getValue()+"\";");
			out.println("tags['"+j+"']=tag"+j+";");
			j++;
		}
		
		%>
		console.log(tags);
		
		
</script>
	</div>
	</div>
</body>
</html>
