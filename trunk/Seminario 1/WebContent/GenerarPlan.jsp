<%@page import="modelo.EnumMedida"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controler.Sistema"%>
<%@page import="views.IngredienteVO"%>
<%@page import="views.EstacionVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<script>
	
<% 
	Map<Integer, String> tags = Sistema.getInstance().getTags();
%>	

	</script>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>La Cocina de Silvia / Generar Plan</title>

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
		  <li class="active">Generar Plan</li>
		</ol>
        <div class="page-header">
          <h1>Generar Plan Semanal</h1>
        </div>
        <%
if(request.getAttribute("return") != null ){
	if(request.getAttribute("return").equals("NOK")){
		out.println("<div class=\"alert alert-danger\"><b>Existe un Plan vigente generado. Se debe finalizar el Plan Vigente para poder generar uno nuevo.</b></div>");
	}
}
%>
        <p class="lead">  
        	<div class="panel panel-default">
            <!-- Default panel contents -->
	            <div class="panel-heading">
	            <form action="PlanServlet?action=generarPlan" method="post" id="idFormGeneratePlan" name="formGeneratePlan">
	            	<div class="row"> 
					  <div class="col-lg-6">
					  	<h3>Ingrese la fecha de inicio del plan</h3>
					    <div class="input-group">
						  <span class="input-group-addon">Fecha</span>
						  <input type="text" class="form-control" placeholder="dd-mm-aaaa" name="fechaInicio" id="idInputDate">
						</div>
					    <br/>
					    <button type="button" class="btn btn-default btn-md" id="idButtonConfirm">
						  <span class="glyphicon glyphicon-ok"></span> Confirmar!
						</button>
						<input type="hidden" name="fechaFin" id="idFechaFin" value="">
					  </div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
					<hr/>
					<div id="dayList">
					</div>
				</form>
	            </div>
            </div>
        </p>
    </div>
	<br/>
	<br/>
   <jsp:include page="/Footer.jsp" />
	<script type="text/javascript">
		var tags = new Array();
		var tag = new Array();
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
		$(function () {
			var now = new Date();
			var days = ['Domingo','Lunes','Martes','Miercoles','Jueves','Viernes','Sabado'];
			var months = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];

			var day = days[ now.getDay() ];
			var month = months[ now.getMonth() ];
			console.log(day);
			var g_globalObject = new JsDatePick({
				useMode:2,
				target:"idInputDate",
				dateFormat:"%d-%m-%Y",
				imgPath:"../img/",
				limitToToday:false
				/*selectedDate:{				
					day:5,						
					month:9,
					year:2006
				}
				yearsRange:[1978,2020],
				limitToToday:false,
				cellColorScheme:"beige",
				dateFormat:"%m-%d-%Y",
				imgPath:"img/",
				weekStartDay:1*/
			});
			g_globalObject.setOnSelectedDelegate(function(){
				var obj = g_globalObject.getSelectedDay();
				var dateSelected = new Date();
				dateSelected.setFullYear(obj.year,obj.month-1,obj.day);
				if(now > dateSelected){
					bootbox.alert("<h3>No puede ingresar un dia anterior a la fecha actual</h3>");
					//alert("No puede ingresar un dia anterior al dia de la fecha");
				}else{ //controlar que no sea ni domingo ni sabado!!!!
					document.getElementById("idInputDate").value = obj.day + "-" + obj.month + "-" + obj.year;
				}
			});
			
			$("#idButtonConfirm").click(function() {
				var options="<option>Selecccionar un TAG</option>";
				for(var i=0; i<tags.length;i++){
					options+="<option value='"+tags[i]['id']+"'>"+tags[i]['value']+"</option>";
				}
				var obj = g_globalObject.getSelectedDay();
				var iterate = new Date();
				iterate.setFullYear(obj.year,obj.month-1,obj.day);
				var html="<h4><span class=\"glyphicon glyphicon-tags\"></span>&nbsp;&nbsp;&nbsp;Listado de tag por Dias</h4><br/>";
				console.log(iterate.getDay());
				while(iterate.getDay() < 6){
						html+="<div class=\"row\">"
					  			+ "<div class=\"col-lg-6\">"
					    		+	"<div class=\"input-group\">"
					      		+ 		"<span class=\"input-group-addon\">Tag - "+days[iterate.getDay()]+" Almuerzo</span>"
					      		+		"<select name=\"tag"+days[iterate.getDay()]+"Alm\">"+options+"</select>"
					  			+ 	"</div><!-- /input-group -->"
					  			+ "</div><!-- /.col-lg-6 -->"
					  			+ "<div class=\"col-lg-6\">"
					    		+	"<div class=\"input-group\">"
					      		+ 		"<span class=\"input-group-addon\">Tag - "+days[iterate.getDay()]+" Cena</span>"
					      		+		"<select name=\"tag"+days[iterate.getDay()]+"Cen\">"+options+"</select>"
					  			+ 	"</div><!-- /input-group -->"
					  			+ "</div><!-- /.col-lg-6 -->"
					  			+"</div><br/>";					  			 
					  			$("#idFechaFin").val(iterate.getDate()+"-"+(iterate.getMonth()+1)+"-"+iterate.getFullYear());
					  			console.log($("#idFechaFin").val());
					  			iterate.setDate(iterate.getDate()+1);
				}
				
				html+="<button type=\"button\" class=\"btn btn-default btn-md\" id=\"idButtonGenerate\"><span class=\"glyphicon glyphicon-flash\"></span> Generar Plan!</button>"
				$( "#dayList").html(html);
				$("#idButtonGenerate").click(function() {
						$("#idFormGeneratePlan").submit();
					
				});
			});
			
		});
	</script>
	
  </body>
</html>