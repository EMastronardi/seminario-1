<%@page import="modelo.EnumMedida"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="controler.Sistema"%>
<%@page import="views.IngredienteVO"%>
<%@page import="views.EstacionVO"%>
<%@page import="views.PlanVO"%>
<%@page import="views.ItemMenuVO"%>

<%@page import="views.PlanDiarioVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	/*
	if(request.getAttribute("return") != null ){
		if(request.getAttribute("return").equals("OK")){
			PlanVO plan = Sistema.getInstance().getPlanById((int)Integer.parseInt(request.getAttribute("idPLan").toString()));	
		}	
	}else{
		String redirectURL = "GenerarPlan.jsp"; 
	    response.sendRedirect(redirectURL);
	}*/

	PlanVO plan = Sistema.getInstance().getPlanById(7);
	
	DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	String fechaInicio = format.format(plan.getFechaInicio());
	String fechaFin = format.format(plan.getFechaFin());
	List<PlanDiarioVO> planesDiarios = plan.getItems();
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>La Cocina de Silvia / Visualizaci&oacute;n Plan Vigente</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	
	<link href="css/footable.core.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" media="all" href="css/jsDatePick_ltr.min.css" />
	
    <!-- Custom styles for this template -->
    <!--  <link href="css/home.css" rel="stylesheet">-->
	
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
		
	<style>
		   table tr th {
		   		 text-align:center;
		   }
		   table tr td{
		   		   text-align:center;
		   }
		   table tr.information td{
		   		   text-align:center;
		   		   cursor:pointer;
		   }
		   table.estaciones{
		   		width: 300px;
		   		height: 60px;
		   		
		   }
		   table.estaciones tr td{
		   		text-align: left;
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
		   hr{
		   	border-top:  1px solid #C0B4B4
		   }
		   .btn-content{
			   margin: auto;
				width: 400px;
			}
		       
	</style>
  </head>

  <body>
<!-- 
- PLanes Diarios
		
		=> Date fecha;
		=> String turno;
		=> boolean feriado;
		=> ItemMenu items;
			int idItemMenu;
			String nombre;
			int cantidad;
			Menu menu;
			List<Cliente> clientes;
		=> EnumEstado estado;
		=> String tag;
 -->
<!-- Wrap all page content here -->
    <div id="wrap">
		<jsp:include page="/Header.jsp" />
		
      <!-- Begin page content -->
      <div class="container">
      	 <ol class="breadcrumb">
				<li><a href="Home.jsp">Inicio</a></li>
				<li><a href="GenerarPlan.jsp">Generar Plan</a></li>
				<li class="active">Vista Plan Vigente</li>
			</ol>

			<div class="page-header">
				<h1>Visualizaci&oacute;n plan Vigente</h1>
			</div>
     	
     	<ul class="nav nav-tabs nav-justified" id="myTab">
     		<li class="active"><a href="#Monday">Lunes</a></li>
			<li><a href="#Tuesday">Martes</a></li>
			<li><a href="#Wednesday">Miercoles</a></li>
			<li><a href="#Thursday">Jueves</a></li>
			<li><a href="#Friday">Viernes</a></li>
     	</ul>
     	<div class="panel panel-default" style="border-top:none"> 
     	<div id="content" class="tab-content">
     		<%
		 	PlanDiarioVO almuerzo;
		    PlanDiarioVO cena;
		    String active=" active";
		    List<ItemMenuVO> items;
		    int j=0;
		    for(int i = 0; i<planesDiarios.size(); i++){
		    	
		    	almuerzo = planesDiarios.get(i);
		    	i++;
		    	cena = planesDiarios.get(i);
		    	String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(almuerzo.getFecha());
		    %>
		    
		    <div class="tab-pane<% out.print(active); %>"  id="<%out.print(dayOfWeek);%>">
		    <div class="modal-body">
				<div class="col-sm-6">
			    <div class="panel">
				  <div class="panel-heading"><h4>Almuerzo</h4></div>
				<div class="panel-body">
			    	<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon">Fecha</span>
								 <input type="text" class="form-control" placeholder="<%out.println(format.format(almuerzo.getFecha())); %>" disabled>
							</div>
						</div> 
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon">Estado</span>
								<input type="text" class="form-control" placeholder="<%out.println(almuerzo.getEstado()); %>" disabled>
							</div>
						</div>
					</div>
					<br/>
					<div class="row">
						  	<div class="col-sm-6">
							   	<div class="input-group">
								  <span class="input-group-addon">Tag   </span>
								  <input type="text" class="form-control" placeholder="<%out.println(almuerzo.getTag()); %>" disabled>
								 </div>
							</div>
					</div>
					<br>
					<div class="panel panel-default">
			    	<!-- Default panel contents -->
						<div class="panel-heading">Detalles de Platos ha realizar</div>
							<!-- Table -->
							<table class="table">
							  <thead>
							  	<tr>
							  		<th>#</th>
							    	<th>Ensalada</th>
							    	<th>Principal</th>
							    	<th>Postre</th>
							    	<th>Cantidad</th>
							    	<th>Clientes</th>
							    </tr>
							  </thead>
							  <tbody>
							  	<% 
							   items = almuerzo.getItems();
							  j=1;
							   for(ItemMenuVO item:items){
								   out.print("<tr>"
								     +"<td>"+j+"</td>"										   
									+"<td>"+item.getMenu().getEnsalada().getNombre()+"</td>"	 
									+"<td>"+item.getMenu().getPrincipal().getNombre()+"</td>"
									+"<td>"+item.getMenu().getPostre().getNombre()+"</td>"
									+"<td>"+item.getCantidad()+"</td>"
									+"<td><a href=\"javascript:selectClientesItemsMenu("+item.getIdItemMenu()+")\">Ver</a></td>"
								    +"</tr>");
								   j++;
							   }
							  %>
							  </tbody>
							</table>
					</div>	
					</div>
					</div>
					</div>
			    
				<div class="col-sm-6">
			    <div class="panel">
				  <div class="panel-heading"><h4>Cena</h4></div>
				<div class="panel-body">
			    	<div class="row">
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon">Fecha</span>
								 <input type="text" class="form-control" placeholder="<%out.println(format.format(cena.getFecha())); %>" disabled>
							</div>
						</div> 
						<div class="col-sm-6">
							<div class="input-group">
								<span class="input-group-addon">Estado</span>
								<input type="text" class="form-control" placeholder="<%out.println(cena.getEstado()); %>" disabled>
							</div>
						</div>
					</div>
					<br/>
					<div class="row">
						  	<div class="col-sm-6">
							   	<div class="input-group">
								  <span class="input-group-addon">Tag   </span>
								  <input type="text" class="form-control" placeholder="<%out.println(cena.getTag()); %>" disabled>
								 </div>
							</div>
					</div>
					<br>
					<div class="panel panel-default">
					
			    	<!-- Default panel contents -->
						<div class="panel-heading">Detalles de Platos ha realizar</div>
							<!-- Table -->
							<table class="table">
							  <thead>
							  	<tr>
							  		<th>#</th>
							    	<th>Ensalada</th>
							    	<th>Principal</th>
							    	<th>Postre</th>
							    	<th>Cantidad</th>
							    	<th>Clientes</th>
							    </tr>
							  </thead>
							  <tbody>
							  <% 
							   items = cena.getItems();
							  j=1;
							   for(ItemMenuVO item:items){
								   out.print("<tr>"
								     +"<td>"+j+"</td>"										   
									+"<td>"+item.getMenu().getEnsalada().getNombre()+"</td>"	 
									+"<td>"+item.getMenu().getPrincipal().getNombre()+"</td>"
									+"<td>"+item.getMenu().getPostre().getNombre()+"</td>"
									+"<td>"+item.getCantidad()+"</td>"
									+"<td><a href=\"javascript:selectClientesItemsMenu("+item.getIdItemMenu()+")\">Ver</a></td>"
								    +"</tr>");
								   j++;
							   }
							  %>
							  	
							  </tbody>
							</table>
					</div>	
					</div>
					</div>
					</div>
					</div>
					<div class="btn-content">
				      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-print"></span> Imprimir Orden de Trabajo</button>
				      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-time"></span>  Plan Diario Finalizado</button>
				    </div>	
			    <br clear="all">
		    </div>
		    <% 		
		    	active="";
		    		}
		    %>
     	</div>	
      	</div>
      </div>
       
    </div>
	<br/>
	<br/>
   <jsp:include page="/Footer.jsp" />
   <script type="text/javascript" src="js/Planes.js"></script>
	<script type="text/javascript">
		$(function () {
			var now = new Date();
			var days = ['Domingo','Lunes','Martes','Miercoles','Jueves','Viernes','Sabado'];
			var months = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];

			var day = days[ now.getDay() ];
			var month = months[ now.getMonth() ];
			$('#myTab a').click(function (e) {
				  e.preventDefault();
				  $(this).tab('show');
			});			
		});
	</script>
	
  </body>
</html>