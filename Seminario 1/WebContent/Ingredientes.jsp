<%@page import="java.util.ArrayList"%>
<%@page import="Controler.Sistema"%>
<%@page import="views.IngredienteVO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
	ArrayList<IngredienteVO> ingredientes = Sistema.getInstance().getIngredientes();
%>	
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>La Cocina de Silvia / Clientes</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/home.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
	<script>
	</script>
	<style>
		   table tr th {
		   		 text-align:center;
		   }
		   table tr td{
		   		   text-align:center;
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
		  <li class="active">Ingredientes</li>
		</ol>
        <div class="page-header">
          <h1>Ingredientes</h1>
        </div>
       
        <p class="lead">
		   <div class="panel panel-default">
            <!-- Default panel contents -->
            
            <div class="panel-heading">
            	<!--  
            	<form method="post"  action='ArticulosServlet?action=search' id="theform">
            	<div class="row">
				  <div class="col-lg-4">
				    <div class="input-group">
				      <input type="text" class="form-control" id="valorinput" name="valor" value="">
				      <span class="input-group-btn">
				        <button class="btn btn-default" type="submit">Buscar!</button>
				      </span>
				    </div>
				  </div>
				  </div>
				 <div class="row">
			    	<span style="padding-left: 15px;"><b>Buscar Por&nbsp;</b></span>
			    	<input type="radio" name="searchby" checked="checked" value="codigo">&nbsp;C&oacute;digo de Art&iacute;culo&nbsp;<input type="radio" name="searchby" value="deposito">&nbsp;Deposito
			    </div>
			    </form>
			    -->
			    </div>
            <!-- Table -->
     
            <table class="table">
              <thead>
			  	<tr>
			  		 <th>Check</th>
			  		 <th>Nombre</th>
			  		 <th>Canidad en Stock</th>
			  		 <th>Medida</th>
			  		 <th>Dias de Caducidad</th>
			  		 <th>Freezer</th>
			  		 <th></th>
			  </thead>
			  <tbody>
			 
			  </tbody>
		    </table>
		   
          </div>
		</p>
      </div>
    </div>
	<br/>
   <jsp:include page="/Footer.jsp" />
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootbox.min.js"></script>
  </body>
</html>