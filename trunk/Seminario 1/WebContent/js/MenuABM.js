
var xml;
var idIngredienteChecked;
function createMenu(){
	var options="";
	for(var i=0; i<tags.length;i++){
		options+="<option value='"+tags[i]['id']+"'>"+tags[i]['nombre']+"</option>";
	}

	bootbox
	.dialog({
		message : "<form id='createMenu' method='post' action='MenuServlet?action=altaMenu'>"
				+ "<label>Ensalada </label><input type=\"text\" class=\"form-control\" id='ensaladaInput' name=\"ensalada\" autofocus>"
				+ "<br/>"
				+ "<label>Plato Principal </label><input type=\"text\" class=\"form-control\" id='principalInput' name=\"principal\" autofocus>"
				+ "<br/>"
				+ "<label>Postre </label><input type=\"text\" class=\"form-control\" id='postreInput' name=\"postre\" autofocus>"
				+ "<br/>"
				+ "<label>Tag</label><select name=\"medida\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Calorias </label><input type=\"text\" class=\"form-control\" id='diasCaducidadInput' name=\"diascaducidad\" autofocus>"
				+ "<br/>"
				+ "<label>Estado&nbsp;</label>&nbsp;<input type='radio' name='freezer' value='ok' checked='chekced'>&nbsp;Activo&nbsp;<input type='radio' name='freezer' value='no'>&nbsp;Inactivo "
				+ "<br/>"
				+ "</form>",
		title : "Agregar Menu",
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
						alert("Para dar de alta un Menu debe ingresar todos los campos");
					}
				}
			}
		}
	});
}
function getIngrediente(actioncallback){
	var  value  = "getIngredienteAjax";
	$.ajax({
        type: "POST",
        url: "IngredienteServlet",
        data: { action : value , idIngrediente : idIngredienteChecked}
      }).done(function(xmlStr) {
    	  console.log(xmlStr);
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml); 
    	  var estacionName = $(xml).find('nombre').text();
    	  var cantidadStock = $(xml).find('cantidadStock').text();
    	  var estacionMedida = $(xml).find('medida').text();
    	  var diasCaducidad =  $(xml).find('diasCaducidad').text();
    	  var freezer =  $(xml).find('freezer').text();
    	  var estacionesItem = new Array(0, 0, 0, 0);
    	  var i = 0;
    	  
    	  $(xml).find('estacionItem').each (function() { 
  		  	 estacionesItem[(parseInt($(this).find("idEstacion").text())-1)] = 1;
    	  });
    	  if(actioncallback == "edit"){
    		  showOpenEditIngrediente(estacionName, cantidadStock, estacionMedida , diasCaducidad, freezer, estacionesItem);  
    	  }else{
    		  showOpenDetialsIngrediente(estacionName, cantidadStock, estacionMedida , diasCaducidad, freezer, estacionesItem);
    	  }
    	  
    	});
}
function showOpenDetialsIngrediente(estacionName, cantidadStock, estacionMedida , diasCaducidad, freezer, estacionesItem){
	var options="";
	for(var i=0; i<medidas.length;i++){
		var select = (estacionMedida == medidas[i])?"selected":"";
		options+="<option value='"+medidas[i]+"'"+select+ " >"+medidas[i]+"</option>";
	}
	var checked =new Array("","","","");
	if(estacionesItem[0]==1){ checked[0] = "checked='checked'";}
	if(estacionesItem[1]==1){ checked[1] = "checked='checked'";}
	if(estacionesItem[2]==1){ checked[2] = "checked='checked'";}
	if(estacionesItem[3]==1){ checked[3] = "checked='checked'";}
	if(freezer == 'true'){
		var freezerTrue = "checked='checked'";
		var freezerFalse = "";
	}else{
		var freezerFalse = "checked='checked'";
		var freezerTrue = "";	
	}
	bootbox
	.dialog({
		message : "<form id='updateFormIngrediente' method='post' action='IngredienteServlet?action=editIngrediente'>"
				+ "<input type=\"hidden\" id='idInput' name=\"idIngrediente\" value=\""+idIngredienteChecked+"\" autofocus>"
				+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" value=\""+estacionName+"\" autofocus disabled>"
				+ "<br/>"
				+ "<label>Cantidad en Stock </label><input type=\"text\" class=\"form-control\" id='stockInput' name=\"stock\" value=\""+cantidadStock+"\" autofocus disabled>"
				+ "<br/>"
				+ "<label>Medida </label><select name=\"medida\" disabled>"+options+"</select>"
				+ "<br/>"
				+ "<label>Dias de Caducidad </label><input type=\"text\" class=\"form-control\" id='diasCaducidadInput' name=\"diascaducidad\" value=\""+diasCaducidad+"\" autofocus disabled>"
				+ "<br/>"
				+ "<label>Freezer&nbsp;</label>&nbsp;<input type='radio' name='freezer' value='ok' checked='chekced' "+freezerTrue+">&nbsp;Si&nbsp;<input type='radio' name='freezer' value='no' disabled "+freezerFalse+">&nbsp;No "
				+ "<br/><br/>"
				+ "<label>Estaciones </label>"
				+ "<br/><br/>"
				+ "<table class=\"estaciones\" align=\"center\">" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='otonioInput' name=\"otinio\" value=\""+estaciones[0]+"\" "+checked[0]+" autofocus disabled><td/>" 
					+ "<td>"+estaciones[0]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='inviernoInput' name=\"invierno\" value=\""+estaciones[1]+"\" "+checked[1]+" autofocus disabled><td/>" 
					+ "<td>"+estaciones[1]+"<td/>" 
				+ "</tr>" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='primaInput' name=\"primavera\" value=\""+estaciones[2]+"\" "+checked[2]+"  autofocus disabled><td/>" 
					+ "<td>"+estaciones[2]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='veranoInput' name=\"verano\" name=\"estacion[3]\" value=\""+estaciones[3]+"\" "+checked[3]+"  autofocus disabled><td/>" 
					+ "<td>"+estaciones[3]+"<td/>" 
				+ "</tr>"
				+ "</table>"
				+ "</form>",
		title : "Ingrediente Detalles",
		buttons : {
			success : {
				label : "OK",
				className : "btn-confirm",
				callback : function() {
				}
			}
		}
	});
}
function showOpenEditIngrediente(estacionName, cantidadStock, estacionMedida , diasCaducidad, freezer, estacionesItem){
	var options="";
	for(var i=0; i<medidas.length;i++){
		var select = (estacionMedida == medidas[i])?"selected":"";
		options+="<option value='"+medidas[i]+"'"+select+ " >"+medidas[i]+"</option>";
	}
	var checked =new Array("","","","");
	if(estacionesItem[0]==1){ checked[0] = "checked='checked'";}
	if(estacionesItem[1]==1){ checked[1] = "checked='checked'";}
	if(estacionesItem[2]==1){ checked[2] = "checked='checked'";}
	if(estacionesItem[3]==1){ checked[3] = "checked='checked'";}
	
	
	bootbox
	.dialog({
		message : "<form id='updateFormIngrediente' method='post' action='IngredienteServlet?action=editIngrediente'>"
				+ "<input type=\"hidden\" id='idInput' name=\"idIngrediente\" value=\""+idIngredienteChecked+"\" autofocus>"
				+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" value=\""+estacionName+"\" autofocus>"
				+ "<br/>"
				+ "<label>Cantidad en Stock </label><input type=\"text\" class=\"form-control\" id='stockInput' name=\"stock\" value=\""+cantidadStock+"\" autofocus>"
				+ "<br/>"
				+ "<label>Medida </label><select name=\"medida\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Dias de Caducidad </label><input type=\"text\" class=\"form-control\" id='diasCaducidadInput' name=\"diascaducidad\" value=\""+diasCaducidad+"\" autofocus>"
				+ "<br/>"
				+ "<label>Freezer&nbsp;</label>&nbsp;<input type='radio' name='freezer' value='ok' checked='chekced'>&nbsp;Si&nbsp;<input type='radio' name='freezer' value='no'>&nbsp;No "
				+ "<br/><br/>"
				+ "<label>Estaciones </label>"
				+ "<br/><br/>"
				+ "<table class=\"estaciones\" align=\"center\">" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='otonioInput' name=\"otinio\" value=\""+estaciones[0]+"\" "+checked[0]+" autofocus><td/>" 
					+ "<td>"+estaciones[0]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='inviernoInput' name=\"invierno\" value=\""+estaciones[1]+"\" "+checked[1]+" autofocus><td/>" 
					+ "<td>"+estaciones[1]+"<td/>" 
				+ "</tr>" 
				+ "<tr>" 
					+ "<td><input type=\"checkbox\" id='primaInput' name=\"primavera\" value=\""+estaciones[2]+"\" "+checked[2]+"  autofocus><td/>" 
					+ "<td>"+estaciones[2]+"<td/>" 
					+ "<td><input type=\"checkbox\" id='veranoInput' name=\"verano\" name=\"estacion[3]\" value=\""+estaciones[3]+"\" "+checked[3]+"  autofocus><td/>" 
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
						$("#updateFormIngrediente").submit();
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
function deleteIngrediente (){	
	if(idIngredienteChecked != ""){	
		bootbox.dialog({
			  message: "<h3>Esta seguro que desea eliminar el Ingrediente ?</h2>"+
			  "<form id='deleteingrediente' method='post' action='IngredienteServlet?action=eliminarIngrediente'>"+
				"<input type='hidden' name='idIngrediente' value='"+idIngredienteChecked+"'/>"+
		        "</form>",
			  title: "Eliminar Ingrediente",
			  buttons: {
			    success: {
			      label: "Confirmar",
			      className: "btn-success",
			      callback: function() {
			    	  $( "#deleteingrediente" ).submit();
			      }
			    },
		        main: {
				      label: "Cancelar",
				      callback: function() {
				      }
				}
			  }
		});
	} else {
		bootbox.alert("Debe seleccionar un Ingrediente!", function() {});
	}
}
function unChecked(obj, idingredienteselected){
	var checks = $( ":checkbox" );
	for (var i = 0; i<checks.length; i++){
		if(checks[i] != obj) checks[i].checked = false;
	}
	idIngredienteChecked = idingredienteselected;
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