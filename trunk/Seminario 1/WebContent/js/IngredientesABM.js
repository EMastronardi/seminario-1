
var xml;
function createIngrediente(){
	var options="";
	for(var i=0; i<medidas.length;i++){
		options+="<option value='"+medidas[i]+"'>"+medidas[i]+"</option>";
	}

	bootbox
	.dialog({
		message : "<form id='createIngrediente' method='post' action='IngredienteServlet?action=altaIngrediente'>"
				+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" autofocus>"
				+ "<br/>"
				+ "<label>Cantidad en Stock </label><input type=\"text\" class=\"form-control\" id='stockInput' name=\"stock\" autofocus>"
				+ "<br/>"
				+ "<label>Medida </label><select name=\"medida\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Dias de Caducidad </label><input type=\"text\" class=\"form-control\" id='diasCaducidadInput' name=\"diascaducidad\" autofocus>"
				+ "<br/>"
				+ "<label>Freezer&nbsp;</label>&nbsp;<input type='radio' name='freezer' value='ok' checked='chekced'>&nbsp;Si&nbsp;<input type='radio' name='freezer' value='no'>&nbsp;No "
				+ "<br/><br/>"
				+ "<label>Estaciones </label>"
				+ "<br/><br/>"
				+ "<table class=\"estaciones\" align=\"center\">" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='otonioInput' name=\"otinio\" value=\""+estaciones[0]+"\" autofocus><td/>" 
					+ "<td>"+estaciones[0]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='inviernoInput' name=\"invierno\" value=\""+estaciones[1]+"\" autofocus><td/>" 
					+ "<td>"+estaciones[1]+"<td/>" 
				+ "</tr>" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='primaInput' name=\"primavera\" value=\""+estaciones[2]+"\" autofocus><td/>" 
					+ "<td>"+estaciones[2]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='veranoInput' name=\"verano\" name=\"estacion[3]\" value=\""+estaciones[3]+"\" autofocus><td/>" 
					+ "<td>"+estaciones[3]+"<td/>" 
				+ "</tr>"
				+ "</table>"
				+ "</form>",
		title : "Agregar Ingrediente",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					if ($("#nombreInput").val() != ''
							&& $("#stockInput").val() != ''
							&& $("#diasCaducidadInput").val() != '') {
						$("#createIngrediente").submit();
					} else {
						alert("Para dar de alta un Ingrediente debe ingresar todos los campos");
					}
				}
			}
		}
	});
}

function showAlertMensaje(mesnaje){
	bootbox.alert(mesnaje, function() {createIngrediente();});
}
function selectRestriccion(){
	//Obtener por ajax todas las restricciones
	var  value  = "restriccionAjax";
	$.ajax({
        type: "POST",
        url: "IngredienteServlet",
        data: { action : value  }
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	  var tdStr="";
    	  var i=0;
    	  $(xml).find('restriccion').each (function() { 
    		  	tdStr+= "<tr>" 
    		  			+ "<td><input type='checkbox' checked='' name='restriccion"+i+"' value='OK'></td>" 
    		  			+ "<td>"+$(this).find('nombre').text()+"</td>"
    		  			+ "<td>"+$(this).find('descripcion').text()+"</td>"
    		  			+ "<td>"+$(this).find('severidad').text()+"</td>" 
    		  			+"</tr>";
    		  	i++;
    	  });
    	  openDialogRestriccion(tdStr.toString());
      });
}
function openDialogRestriccion(tableRows){
	bootbox
	.dialog({
		message : "<div class=\"panel panel-default\">"       
			+ "<div class=\"panel-heading\">"
			+ "	<div class=\"row\">"
			+ "	 	<div class=\"col-lg-6\">"
			+ "       	<form method=\"post\"  action='IngredientesServlet?action=search' id=\"theform\">"
			+ "			  <div class=\"col-lg-8\">"
			+ "			    <div class=\"input-group\">"
			+ "			      <input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\"\">"
			+ "			      <span class=\"input-group-btn\">"
			+ "			        <button class=\"btn btn-default\" type=\"submit\">Buscar!</button>"
			+ "			      </span>"
			+ "			    </div>"
			+ "			  </div>"
			+ "		    </form>"
			+ "		 </div>"
			+ "   	</div>"
			+ "   </div>"
			+ "<table class=\"table\" id=\"restriccionTable\">"
			+ "  <thead>"
			+ "  	<tr>"
			+ "  		 <th>Seleccionar</th>"
			+ "  		 <th>Nombre</th>"
			+ "  		 <th>Descripcion</th>"
			+ " 		 <th>Severidad</th>"
			+ " </thead>"
			+ " <tbody>"
			+  tableRows +
			+ "  </tbody>"
			+ "</table>" 
			+ "</div>"
			+ "<ul class=\"pagination\">"
			+ "<li><a href=\"#\">&laquo;</a></li>"
			+ "<li><a href=\"#\">1</a></li>"
			+ "<li><a href=\"#\">2</a></li>"
			+ "<li><a href=\"#\">3</a></li>"
			+ "<li><a href=\"#\">&raquo;</a></li>"
			+ "</ul>",
		title : "Seleccionar Restriccion",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					addRestriccion();
				}
			}
		}
	});
}
function addRestriccion(){
	var checks = $( "#restriccionTable :checkbox" );
//	for (var i = 0; i<checks.length; i++){
		
//			alert(checks[i].checked);
		
//	}
	var check;
	$("#restriccionTable tbody tr").each(function(){
//		check = $(this).find("checkbox");
//		alert(check.checked);	
		alert($(this).find("checkbox")[0].is(":checked"));
		//alert($(this).find("checkbox").is(":checked"));		
		//$(this).find("td").slice(0, 2).addClass("black");
	});
}