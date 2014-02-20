<%@page import="java.util.Iterator"%>
<%@page import="java.util.Locale"%>
<%@page import="modelo.EnumMedida"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="controler.Sistema"%>
<%@page import="views.IngredienteVO"%>
<%@page import="views.PlanDiarioVO"%>
<%@page import="views.PlanVO"%>
<%@page import="views.MenuVO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<PlanVO> planes = new ArrayList<PlanVO>(); 
	planes.addAll(Sistema.getInstance().getPlanesHistoricos());
	//Map<Integer, String> tags = Sistema.getInstance().getTags();
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
	
	<link href="css/footable.core.css" rel="stylesheet" type="text/css"/>
	
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
		  <li class="active">Listado de Planes</li>
		</ol>
        <div class="page-header">
          <h1>Planes Historicos</h1>
        </div>
        <p class="lead">
		   <div class="panel panel-default">
            <!-- Default panel contents -->
            
            <div class="panel-heading">
            	<div class="row">
            		<div class="col-lg-6">
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
							<th>#</th>
							<th>Fecha Inicio</th>
							<th>Fecha Fin</th>
							<th>Estado</th>
							<th>Detalle</th>
					</thead>
					<tbody>
						<%
						int i = 0;
						for (PlanVO plan : planes) {
							out.println("<tr class='information'><td class='cellclass'>" + plan.getIdPlan() + "</td>" 
										+ "<td class='cellclass'>"+ plan.getFechaInicio()
										+ "</td>" + "<td class='cellclass'>"+ plan.getFechaFin() + "</td>" 
										+ "<td class='cellclass'>"+ plan.getEstado() + "</td>" 
										+ "<td class='cellclass'><a href=''#''>Ver detalle</a></td></tr>");
						}
						%>
					</tbody>
			  <tfoot>
						<tr>
							<td colspan="7">
								<div class="pagination pagination-centered"></div>
							</td>
						</tr>
					</tfoot>
		    </table>
          </div>
		</p>
      </div>
    </div>
	<br/>
	<br/>
   <jsp:include page="/Footer.jsp" />

	<script src="js/MenuABM.js"></script>
	<script type="text/javascript">
		$(function () {
			$('.footable').footable();
		});
	</script>
	
  </body>
</html>