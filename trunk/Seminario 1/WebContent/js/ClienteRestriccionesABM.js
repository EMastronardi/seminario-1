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
    		  			//+ "<td>"+$(this).find('severidad').text()+"</td>" 
    		  			+"</tr>";
    		  	i++;
    	  });
    	  console.log(tdStr.toString());
    	  openDialogRestriccion(tdStr.toString());
      });
}
function openDialogRestriccion(tableRows){
	
	bootbox.dialog({
		message :
			"<div class=\"panel panel-default\">"
			+ "<div class=\"panel-heading\">"
			+ "	<div class=\"row\">"
			+ "	 	<div class=\"col-lg-6\">"
			+"<button type=\"button\" id=\"newRestriccion\""
			+"	class=\"btn btn-default btn-sm\">"
			+"	<span class=\"glyphicon glyphicon-star\"></span> Agregar</button>"
			+"<button type=\"button\" id=\"deleteRestriccion\""
			+"	class=\"btn btn-default btn-sm\">"
			+"	<span class=\"glyphicon glyphicon-trash\"></span>Eliminar</button>"
			+"</div>"
			+ "	 	<div class=\"col-lg-6\">"
			+"<form method=\"post\"  action='ClienteServlet?action=search' id=\"theform\">"
			+ "			    <div class=\"input-group\">"
			+ "			      <input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\"\" />"
			+ "			      <span class=\"input-group-btn\">"
			+ "			        <button class=\"btn btn-default\" type=\"submit\">Buscar!</button>"
			+ "			      </span>"
			+ "			    </div>"
			+ "		    </form>"
			+ "		</div>"
			+ "	</div>"
			+ "</div>"
			+ "<table class=\"table footable\" data-page-size=\"4\" id=\"restriccionTable2\">"
			+ "  <thead>"
			+ "  	<tr>"
			+ "  		 <th>Seleccionar</th>"
			+ "  		 <th>Nombre</th>"
			+ "  		 <th>Descripcion</th>"
			//+ " 		 <th>Severidad</th>"
			+"		</tr>"
			+ " </thead>"
			+ " <tbody>"
			+tableRows.toString()
			+ " </tbody>"
			+" <tfoot><tr><td colspan=\"6\"><div class=\"pagination pagination-centered\"></div></td></tr></tfoot>"
			+ "</table>"
			+ "</div>",
		title : "Restricciones",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					FuncionalidadNoDisponible();
				}
			}
		}
	});
	$('.footable').footable();
	$("#newRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});
	$("#deleteRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});
}


function unChecked(obj, idClienteSelected){
	var checks = $( ":checkbox" );
	for (var i = 0; i<checks.length; i++){
		if(checks[i] != obj) checks[i].checked = false;
	}
	idClienteChecked = idClienteSelected;
}


