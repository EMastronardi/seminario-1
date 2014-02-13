<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="img/favicon.ico">

<title>Seminario I - La Cocina de Silvia / Home</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/home.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Wrap all page content here -->
	<div id="wrap">

		<jsp:include page="/Header.jsp" />
		<!-- Begin page content -->
		<div class="container">
			<div class="page-header">
				<h1>Bienvenido a la Cocina de Silvia</h1>
			</div>
			<p class="lead">Mediante esta interfaz Web usted podra:
			<ul>
				<li>Crear nuevos Ingredientes y Platos con sus correspondientes
					recetas</li>
				<li>Ingresar nuevos Clientes</li>
				<li>Generar el Plan Semanal</li>
				<li>Administrar las Compras</li>

			</ul>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />

</body>
</html>