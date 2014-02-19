

function selectClientesItemsMenu(idItemMenu){
	var  value  = "getClientesAjax";
	var id = idItemMenu;
	var xmlstr;
	$.ajax({
        type: "POST",
        url: "PlanServlet",
        data: { action : value, iditemmenu : id }
      }).done(function(xmlstr) {
    	  xmlobj = $.parseXML(xmlstr),
    	  $xmlobj = $(xmlobj);
    	  var rows = "";
    	  $(xmlobj).find('restricciones').each(function(){
    		    $(this).remove();
    	  });
    	 
    	  var i=0;	
    	  $(xmlobj).find('cliente').each (function() { 
    		  	i++;
    		  	console.log("<tr><td>"+i+"</td><td>"+$(this).find('apellido').text()+"</td><td>"+$(this).find('nombre').text()+"</td><td>"+$(this).find('calle').text()+"</td><td>"+$(this).find('horaEntrega').text()+"</td>");
    		  	rows+= "<tr><td>"+i+"</td><td>"+$(this).find('apellido').text()+"</td><td>"+$(this).find('nombre').text()+"</td><td>"+$(this).find('calle').text()+"</td><td>"+$(this).find('horaEntrega').text()+"</td>";  	
    	  });
    	  openDialogClientes(rows);
      });
	
}

function openDialogClientes(tableRows){
	bootbox.dialog({
		message :
			"<div class=\"panel panel-default\">"
			+ "<table class=\"table footable\" data-page-size=\"10\">"
			+ "  <thead>"
			+ "  	<tr>"
			+ "  		 <th>#</th>"
			+ "  		 <th>Nombre</th>"
			+ "  		 <th>Apellido</th>"
			+ " 		 <th>Calle</th>"
			+ " 		 <th>Hora De Entrega</th>"
			+"		</tr>"
			+ " </thead>"
			+ " <tbody>"
			+ tableRows.toString()
			+ " </tbody>"
			+" <tfoot><tr><td colspan=\"6\"><div class=\"pagination pagination-centered\"></div></td></tr></tfoot>"
			+ "</table>"
			+ "</div>",
		title : "Clientes",
		buttons : {
			success : {
				label : "OK",
				className : "btn-confirm",
				callback : function() {
				}
			}
		}
	});
	$('.footable').footable();

}