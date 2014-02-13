<%@page import="modelo.EnumMedida"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controler.Sistema"%>
<%@page import="views.IngredienteVO"%>
<%@page import="views.PlanDiarioVO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
	List<PlanDiarioVO> planesDiarios = Sistema.getInstance().obtenerPlanActual().getItems();
%>	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>La Cocina de Silvia / Planes</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!--  <link href="css/home.css" rel="stylesheet">-->
	<script src="https://code.jquery.com/jquery.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
	<script>
		var medidas = new Array();
		<%
		int i = 0;
		for (EnumMedida med : EnumMedida.values()) {
			  // do what you want
			  out.println("medidas["+i+"]=\""+med.name()+"\";");
			  i++;
			}
		%>
		$(function() {
					
				// Handler for .ready() called.
				$( "#newIngrediente" ).click(function() {
						createIngrediente();
				});
		});
	</script>
	<style>
		   table tr th {
		   		 text-align:center;
		   }
		   table tr td{
		   		   text-align:center;
		   } 
		   div.col-lg-6 button{ float:left}
		   div.col-lg-8 { float:right}
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
<!-- Wrap all page content here -->
    <div id="wrap">
		<jsp:include page="/Header.jsp" />
      <!-- Begin page content -->
      <div class="container">
      	<ol class="breadcrumb">
		  <li><a href="Home.jsp">Inicio</a></li>
		  <li class="active">Planes</li>
		</ol>
        <div class="page-header">
          <h1>Planes</h1>
        </div>
       
        <p class="lead">
		   <div class="panel panel-default">
            <!-- Default panel contents -->
            
            <div class="panel-heading">
            	<div class="row">
            		<div class="col-lg-6">
						<button type="button" id="generarPlanSemanal" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-star"></span> Generar Plan Semanal
						</button>
						<button type="button" id="listarPlanes"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-fast_food"></span> Ver Plan Semanal
						</button>
						<button type="button" id="deletepLAN"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-trash"></span> Eliminar Plan
						</button>
					</div>   
            	 	<div class="col-lg-6">
		            	<form method="post"  action='PlanesServlet?action=search' id="theform">
		            	<div class="row">
						  <div class="col-lg-8">
						    <div class="input-group">
						      <input type="text" class="form-control" id="valorinput" name="valor" value="">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit">Buscar!</button>
						      </span>
						    </div>
						  </div>
						  </div>
					    </form>
					 </div>
			    	</div>
			    </div>
            <!-- Table -->
     
            <table class="table">
              <thead>
			  	<tr>
			  		 <th>Check</th>
			  		 <th>Fecha</th>
			  		 <th>Cantidad</th>
			  		 <th></th>
			  </thead>
			  <tbody>
			 <% for(PlanDiarioVO plan : planesDiarios){
				// out.println("<tr><td><input type='checkbox' value='"+ing.getIdIngrediente()+"'/></td><td>"+ ing.getNombre()+"</td><td>"+ ing.getCantidadStock()+"</td><td>"+ ing.getMedida()+"</td><td>"+ ing.getDiasCaducidad()+"</td><td>"+ ing.isFreezer()+"</td>");
			 } %>
			  </tbody>
		    </table>
          </div>
		</p>
      </div>
    </div>
	<br/>
   <jsp:include page="/Footer.jsp" />

	<script src="js/IngredientesABM.js"></script>
  </body>
</html>