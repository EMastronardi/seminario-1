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
    		  	+ "<table class=\"table footable\" data-page-size=\"4\" id=\"restriccionTable2\">"
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