function selectRecetaPlato(idPlato){
	//Obtener por ajax la receta e ingredientes para un plato
	var  value  = "receta";
	var id = idPlato;
	$.ajax({
        type: "POST",
        url: "PlatoServlet",
        data: { action : value, plato : id }
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	  var tdStr="";
    	  var rows = "";
    	  $(xml).find('views\\.ItemIngredienteVO').each (function() { 
    		  	rows+= "<tr><td>"+$(this).find('nombre').text()+"</td><td>" + $(this).find('cantidad').text() +" " + $(this).find('medida').text() +"</td></tr>";
    		  	
      	  });
    	  tdStr +=
    		  "<ul class=\"nav nav-tabs\" id=\"myTab\">"
    		  +"<li class=\"active\"><a href=\"#receta\">Receta</a></li>"
		  	  +"<li><a href=\"#ingredientes\">Ingredientes</a></li></ul>";
    	  tdStr +=" <div id='content' class=\"tab-content\">"
    	  			+"<div class=\"tab-pane active\" id=\"receta\">" 
    	  			+"<div class=\"modal-body\">"
    	  			+"<h6><label>" + $(xml).find('receta').text() + "</label></h6></div></div>" ;
    	 
    	  tdStr +="<div class=\"tab-pane\" id=\"ingredientes\">"
    		+  "<div class=\"panel panel-default\">"
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
  			+"<form method=\"post\"  action='PlatoServlet?action=search' id=\"theform\">"
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
  			+ "			<th>Nombre</th>"
    		+ "  		<th>Cantidad</th>"
  			+"		</tr>"
  			+ " </thead>"
  			+ " <tbody>"
  			+rows
  			+ " </tbody>"
  			+" <tfoot><tr><td colspan=\"6\"><div class=\"pagination pagination-centered\"></div></td></tr></tfoot>"
  			+ "</table>"
  			+ "</div>"
    		+"</div>";
    	  tdStr+="</div>";
    	  
    	  openDialogReceta(tdStr.toString());
    	  $('.footable').footable();
      });
	
}

function selectRestriccionesPlato(idPlato){
	var  value  = "restriccionesPlato";
	var id = idPlato;
	$.ajax({
        type: "POST",
        url: "PlatoServlet",
        data: { action : value, plato : id }
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	  var rows = "";
    	  
    	  $(xml).find('restriccion').each (function() { 
    		  	rows+= "<tr><td>"+$(this).find('idRestriccion').text()+"</td><td>"+$(this).find('nombre').text()+"</td><td>"+$(this).find('descripcion').text()+"</td>";
    		  	
      	  });
    	 openDialogRestricciones(rows);
      });
	
}
function openDialogReceta(tableRows){
	
	bootbox.dialog({
		message :
			"<div class=\"panel panel-default\">"
			
			+ " <tbody>"
			+tableRows.toString()
			
			+ "</div>",
		title : "Ingredientes y Receta",
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
	$('#myTab a').click(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		});
	$("#newRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});
	$("#deleteRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});
}
function openDialogRestricciones(tableRows){
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
$("#newPlato").click(function() {
	CreatePlato();
});
$(".recetaPlato").click(function(){
	selectRecetaPlato(this.name);
});
$(".restriccionesPlato").click(function(){
	selectRestriccionesPlato(this.name);
});
function CreatePlato() {
	var options="";
	for(var i=0; i<tipoPlato.length;i++){
		options+="<option value='"+tipoPlato[i]+"'>"+tipoPlato[i]+"</option>";
	}
	var optionsTags="";
	for(var i=0; i<tags.length;i++){
		optionsTags+="<option value='"+tags[i]['id']+"'>"+tags[i]['value']+"</option>";
	}
	
	bootbox
			.dialog({
				message : "<form id='createPlato' method='post' action='PlatonteServlet?action=createPlato'>"
						+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" autofocus>"
						+ "<br/>"
						+ "<label>Tipo </label><select name=\"tipo\">"+options+"</select>"
						+ "<br/>"
						+ "<label>Tag</label><select name=\"tag\">"+optionsTags+"</select>"
						+ "<br/>"
						+ "<label>Receta </label><textarea id='recetaInput' name='receta' class=\"form-control\" rows=\"3\" autofocus></textarea>"
						+ "<br/>"
						+ "</form>",
				title : "Agregar Plato",
				buttons : {
					success : {
						label : "Confirmar",
						className : "btn-success",
						callback : function() {
							if ($("#nombreInput").val() != ''
									|| $("#nombreInput").val() != ''
									|| $("#recetaInput").val() != '') {
								FuncionalidadNoDisponible();
							} else {
								alert("Para dar de alta un Plato debe ingresar todos los campos");
							}
						}
					}
				}
			});
	$('.footable').footable();
	
};

function selectIngredientes(){
	//Obtener por ajax todos los ingredientes
	var  value  = "ingredientes";
	var ingsStr = "";
	$.ajax({
        type: "POST",
        url: "PlatoServlet",
        async: false,
        data: { action : value}
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	 
    	  var i = 0;
    	  $(xml).find('ingrediente').each (function() { 
    		  ingsStr+= "<tr>"
  		  		+ "<td><input type='checkbox' name='ingrediente"+i.toString()+"' value='OK' /></td>" 
  		  		+ "<td>"+$(this).find('nombre').text()+"</td><td><input type='text'></td>" 
  		  		+ "</tr>";
  		  	
    	  });
    	  //ingsStr+="</tbody></table></div></div></div>";

    	  
    	  //openDialogReceta(tdStr.toString());
      });
	return ingsStr;

}

/*$("#updateUser").click(function() {
updateUser();
});
$("#deleteUser").click(function() {
deleteUser();
});*/
/*function unChecked(obj, useridSelect, userselect, passelect) {
	var checks = $(":checkbox");
	for (var i = 0; i < checks.length; i++) {
		if (checks[i] != obj)
			checks[i].checked = false;
	}
	idUsuario = useridSelect;
	usuario = userselect;
	password = passelect;
}
 function updateUser() {
	bootbox
			.dialog({
				message : "<form id='updateuser' method='post' action='UsersServlet?action=updateUser'>"
						+ "<input type='hidden' name='iduser' value='"+idUsuario+"'/>"
						+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nameinput' name=\"usuario\" value='"+usuario+"' autofocus>"
						+ "<br/>"
						+ "<label>Password </label><input type=\"password\" class=\"form-control\" id='passinput' value='"+password+"' name=\"password\">"
						+ "</form>",
				title : "Actualizar Usuario",
				buttons : {
					success : {
						label : "Confirmar",
						className : "btn-success",
						callback : function() {
							if ($("#nameinput").val() != ''
									|| $("#passinput").val() != '') {
								$("#updateuser").submit();
							} else {
								alert("Para dar de alta un usuario debe ingresar todos los campos");
							}
						}
					}
				}
			});
}
function deleteUser() {
	bootbox
			.dialog({
				message : "<h3>Esta seguro que desea eliminar a "
						+ usuario
						+ " como usuario del sistema?</h2>"
						+ "<form id='deleteuser' method='post' action='UsersServlet?action=deleteUser'>"
						+ "<input type='hidden' name='iduser' value='"+idUsuario+"'/>"
						+ "</form>",
				title : "Eliminar Usuario",
				buttons : {
					success : {
						label : "Confirmar",
						className : "btn-success",
						callback : function() {
							$("#deleteuser").submit();
						}
					},
					main : {
						label : "Cancelar",
						callback : function() {
						}
					}
				}
			});
} */