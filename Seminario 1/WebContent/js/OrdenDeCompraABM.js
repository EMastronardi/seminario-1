var idClienteChecked;
function selectIngredientesOC(idOc){
	var  value  = "ingredientes";
	var id = idOc;
	$.ajax({
        type: "POST",
        url: "OCServlet",
        data: { action : value, oc : id }
      }).done(function(xmlStr) {
    	  xml = $.parseXML(xmlStr),
    	  $xml = $(xml);
    	  var tdStr="";
    	  var i=0;
    	  $(xml).find('ItemsOrdenDeCompraVO').each (function() { 
    		  	tdStr+= "<tr>" 
    		  			//+ "<td><input type='checkbox' name='ingrediente"+i.toString()+"' value='OK' /></td>" 
    		  			+ "<td>"+$(this).find('id').text()+"</td>"
    		  			+ "<td>"+$(this).find('ingrediente').text()+"</td>"
    		  			+ "<td>"+$(this).find('cantidad').text()+ " " +$(this).find('medida').text()+"</td>"
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
			/*/*+"<button type=\"button\" id=\"newRestriccion\""
			+"	class=\"btn btn-default btn-sm\">"
			+"	<span class=\"glyphicon glyphicon-star\"></span> Agregar</button>"
			+"<button type=\"button\" id=\"deleteRestriccion\""
			+"	class=\"btn btn-default btn-sm\">"
			+"	<span class=\"glyphicon glyphicon-trash\"></span>Eliminar</button>""*/
			+"</div>"
			+ "	 	<div class=\"col-lg-12\">"
			+ "			    <div class=\"input-group\">"
			+ "			      <input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\"\" />"
			+ "			      <span class=\"input-group-btn\">"
			+ "			        <button class=\"btn btn-default\">Buscar!</button>"
			+ "			      </span>"
			+ "			    </div>"
			+ "		</div>"
			+ "	</div>"
			+ "</div>"
			+ "<table class=\"table footable\" data-page-size=\"4\" id=\"restriccionTable2\">"
			+ "  <thead>"
			+ "  	<tr>"
			+ "  		 <th>Numero</th>"
			+ "  		 <th>Nombre</th>"
			+ "  		 <th>Cantidad</th>"
			+"		</tr>"
			+ " </thead>"
			+ " <tbody>"
			+tableRows.toString()
			+ " </tbody>"
			+" <tfoot><tr><td colspan=\"6\"><div class=\"pagination pagination-centered\"></div></td></tr></tfoot>"
			+ "</table>"
			+ "</div>",
		title : "Ingredientes a Comprar",
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
/*	$("#newRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});
	$("#deleteRestriccion").click(function(){
		FuncionalidadNoDisponible();
	});*/
}


function unChecked(obj, idClienteSelected){
	var checks = $( ":checkbox" );
	for (var i = 0; i<checks.length; i++){
		if(checks[i] != obj) checks[i].checked = false;
	}
	idClienteChecked = idClienteSelected;
}