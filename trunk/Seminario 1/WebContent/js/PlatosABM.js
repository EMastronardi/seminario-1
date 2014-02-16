function selectRecetaPlato(idPlato){
	//Obtener por ajax todas las restricciones para un cliente
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
    	  tdStr +=
    		  "<ul class=\"nav nav-tabs\" id=\"myTab\">"
    		  +"<li class=\"active\"><a href=\"#receta\">Receta</a></li>"
		  	  +"<li><a href=\"#ingredientes\">Ingredientes</a></li></ul>";
    	  tdStr +=" <div id='content' class=\"tab-content\">"
    	  			+"<div class=\"tab-pane active\" id=\"receta\">" 
    	  			+"<div class=\"modal-body\">"
    	  			+"<h6><label>" + $(xml).find('receta').text() + "</label></h6></div></div>" ;
    	  tdStr +="<div class=\"tab-pane\" id=\"ingredientes\">"
    		  	+"<div class=\"modal-body\">"
    		  	+ "<table class=\"table footable\" data-page-size=\"4\" data-limit-navigation=\"3\" id=\"restriccionTable2\">"
    			+ "  <thead>"
    			+ "  	<tr>"
    			+ "  		 <th>Nombre</th>"
    			+ "  		 <th>Cantidad</th>"
    			+"		</tr>"
    			+ " </thead>"
    			+ " <tbody>";
    	  $(xml).find('ingrediente').each (function() { 
  		  	tdStr+= "<tr><td>"+$(this).find('nombre').text()+"</td><td>" + $(this).find('cantidadStock').text() +"</td></tr>";
  		  	
    	  });
    	  tdStr+="</tbody></table></div></div></div>";
    	  
    	  openDialogReceta(tdStr.toString());
      });

}

function openDialogReceta(tableRows){
	
	bootbox.dialog({
		message :
			"<div class=\"panel panel-default\">"
			
			+ " <tbody>"
			+tableRows.toString()
			
			+ "</div>",
		title : "Receta e Ingredientes",
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
	var ings =  selectIngredientes();
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
						+ "<label>Ingredientes </label>"
						+ "<table class=\"table footable\" data-page-size=\"3\" data-limit-navigation=\"3\"  id=\"ingredientesTable\">"
		    			+ "  <thead>"
		    			+ "  	<tr>"
		    			+ "  		 <th>Seleccionar</th>"	
		    			+ "  		 <th>Nombre</th>"
		    			+ "  		 <th>Cantidad</th>"
		    			+"		</tr>"
		    			+ " </thead>"
		    			+ " <tbody>"
		    			+ings
		    			+ " </tbody>"
		    			+" <tfoot><tr><td colspan=\"6\"><div class=\"pagination pagination-centered hide-if-no-paging\"></div></td></tr></tfoot>"
		    			+ "</table>"
		    			
						+ "<label>Restricciones </label><input type=\"text\" class=\"form-control\" id='cpInput' name=\"cp\" autofocus>"
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
									|| $("#recetaInput").val() != ''
									|| $("#cpInput").val() != ''
									|| $("#localidadInput").val() != ''
									|| $("#telefonoInput").val() != ''
									|| $("#horaEntregaInput").val() != ''
									|| $("#estadoInput").val() != '') {
								$("#createPlato").submit();
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