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
	List<MenuVO> menusVO = Sistema.getInstance().getMenus();
	Map<Integer, String> tags = Sistema.getInstance().getTags();
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>La Cocina de Silvia / Menu</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	
	<link href="css/footable.core.css" rel="stylesheet" type="text/css"/>
	
    <!-- Custom styles for this template -->
    <!--  <link href="css/home.css" rel="stylesheet">-->
	<script>
		var tags = new Array();
		var tag = new Array();
		<%
		int i = 0;
		Iterator itera = tags.entrySet().iterator();
		while(itera.hasNext()) {
			Map.Entry me = (Map.Entry)itera.next();
			out.println("tag['id']=\""+me.getKey()+"\";");
			out.println("tag['value']=\""+me.getValue()+"\";");
			out.println("tags["+i+"]=tag;");
			i++;
		}
		%>
		var estaciones = new Array();
		<%
		 i = 0;
		for (EstacionVO est : estaciones) {
			  // do what you want
			  out.println("estaciones["+i+"]=\""+est.getEstacion()+"\";");
			  i++;
			}
		%>
	</script>
	
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
		  <li class="active">Menús</li>
		</ol>
        <div class="page-header">
          <h1>Menús</h1>
        </div>
       <%
          if(request.getAttribute("return") != null ){
        	if(request.getAttribute("return").equals("OK")){
        		out.println("<div class=\"alert alert-success\"><b>El proceso se ha realizado de manera exitosa.</b></div>");
        	}else{
        		out.println("<div class=\"alert alert-danger\"><b>El proceso se ha finalizado con error. Vuelva a intentarlo nuevamente.</b></div>");
        	}
          }
          %>
        <p class="lead">
		   <div class="panel panel-default">
            <!-- Default panel contents -->
            
            <div class="panel-heading">
            	<div class="row">
            		<div class="col-lg-6">
						<button type="button" id="newMenu" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-star"></span> Nuevo Menu
						</button>
						<button type="button" id="updateMenu"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil"></span> Editar
						</button>
						<button type="button" id="deleteMenu"
							class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-trash"></span> Eliminar
						</button>
					</div>   
            	 	<div class="col-lg-6">
		            	<form method="post"  action='IngredientesServlet?action=search' id="theform">
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
							<th>Ensalada</th>
							<th>Plato Principal</th>
							<th>Postre</th>
							<th>Tag</th>
							<th>Calorias Totales</th>
							<th>Estado</th>
					</thead>
					<tbody>
						<%
						for (MenuVO menu : menusVO) {
							out.println("<tr class='information'><td><input type='checkbox' value='"
									+ menu.getIdMenu()
									+ "' onClick=\"unChecked(this,'"
									+ menu.getIdMenu() + "' )\"/></td>" + "<td class='cellclass'>"
									+ menu.getEnsalada()+ "</td>" + "<td class='cellclass'>"
									+ menu.getPrincipal() + "</td>" + "<td class='cellclass'>"
									+ menu.getPostre() + "</td>" + "<td class='cellclass'>"
									+ menu.getTag() + "</td>" + "<td class='cellclass'>"
									+ menu.getCalorias() + "</td>" + "<td class='cellclass'>"
									+ menu.getEstado() + "</td></tr>");
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
			$( "#newMenu" ).click(function() {
				createMenu();
			});
			$( "#updateMenu" ).click(function() {
				getMenu("edit");
			});
			$( "#deleteMenu" ).click(function() {
				deleteMenu();
			});
			$(".cellclass").click(function() {
				$(this).parent().find(":checkbox").trigger('click');
				getIngrediente("view");	
				$(this).parent().find(":checkbox").trigger('click');	
			});
			
			$(".information").hover(
				function() {
					  $(this).css('background-color', '#e7e7e7')
				}, function() {
					  $(this).css('background-color', '')
			 });
		});
	</script>
	
  </body>
</html>