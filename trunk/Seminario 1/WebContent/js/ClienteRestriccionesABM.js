var idClienteChecked;
function selectRestriccionesCliente(idCliente){
	//Obtener por ajax todas las restricciones para un cliente
	var  value  = "restricciones";
	var id = idCliente;
	$.ajax({
        type: "POST",
        url: "ClienteServlet",
        data: { action : value, cliente : id }
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	  var tdStr="";
    	  var i=0;
    	  $(xml).find('restriccion').each (function() { 
    		  	tdStr+= "<tr>" 
    		  			+ "<td><input type='checkbox' name='restriccion"+i.toString()+"' value='OK' /></td>" 
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
		message :"<div class=\"panel panel-default\">"       
			+ "<div class=\"panel-heading\">"
			+ "	<div class=\"row\">"
			+ "	 	<div class=\"col-lg-6\">"
			+ "       	<form method=\"post\"  action='IngredientesServlet?action=search' id=\"theform\">"
			+ "			  <div class=\"col-lg-8\">"
			+ "			    <div class=\"input-group\">"
			+ "			      <input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\"\" />"
			+ "			      <span class=\"input-group-btn\">"
			+ "			        <button class=\"btn btn-default\" type=\"submit\">Buscar!</button>"
			+ "			      </span>"
			+ "			    </div>"
			+ "			  </div>"
			+ "		    </form>"
			+ "		 </div>"
			+ "   	</div>"
			+ "   </div>"
			+ "<table class=\"table\" id=\"restriccionTable2\">"
			+ "  <thead>"
			+ "  	<tr>"
			+ "  		 <th>Seleccionar</th>"
			+ "  		 <th>Nombre</th>"
			+ "  		 <th>Descripcion</th>"
			+ " 		 <th>Severidad</th>"
			+"</tr>"
			+ " </thead>"
			+ " <tbody>"
			+ tableRows+
			+ " </tbody>"
			+ "</table>" 
			+ "</div>"
			+ "<ul class=\"pagination\">"
			+ "<li><a href=\"#\">&laquo;</a></li>"
			+ "<li><a href=\"#\">1</a></li>"
			+ "<li><a href=\"#\">2</a></li>"
			+ "<li><a href=\"#\">3</a></li>"
			+ "<li><a href=\"#\">&raquo;</a></li>"
			+ "</ul>",
		title : "Restricciones",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					//addRestriccion();
					alert("callback");
				}
			}
		}
	});
}
function unChecked(obj, idClienteSelected){
	var checks = $( ":checkbox" );
	for (var i = 0; i<checks.length; i++){
		if(checks[i] != obj) checks[i].checked = false;
	}
	idClienteChecked = idClienteSelected;
}