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

<title>Seminario I - La Cocina de Silvia / Clientes</title>

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
		<div class="container"></div>
	</div>
	<!-- End content -->
			<jsp:include page="/Footer.jsp" />
	
</body>
</html>