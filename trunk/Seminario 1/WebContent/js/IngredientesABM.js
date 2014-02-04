
function createIngrediente(){
	var options="";
	for(var i=0; i<medidas.length;i++){
		options+="<option value='"+medidas[i]+"'>"+medidas[i]+"</option>";
	}
	bootbox
	.dialog({
		message : "<form id='createIngrediente' method='post' action='IngredienteServlet?action=createIngrediente'>"
				+ "<label>Nombre </label><input type=\"text\" class=\"form-control\" id='nombreInput' name=\"nombre\" autofocus>"
				+ "<br/>"
				+ "<label>Cantidad en Stock </label><input type=\"text\" class=\"form-control\" id='stockInput' name=\"stock\" autofocus>"
				+ "<br/>"
				+ "<label>Medida </label><select name=\"medida\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Dias de Caducidad </label><input type=\"text\" class=\"form-control\" id='diasCaducidadInput' name=\"diascaducidad\" autofocus>"
				+ "<br/>"
				+ "<label>Freezer </label><input type=\"checkbox\" id='freezerInput' name=\"freezer\" autofocus>"
				+ "<br/>" + "</form>",
		title : "Agregar Ingrediente",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					if ($("#nombreInput").val() != ''
							|| $("#stockInput").val() != ''
							|| $("#diasCaducidadInput").val() != ''
							|| $("#freezerInput").val() != '') {
						$("#createIngrediente").submit();
					} else {
						alert("Para dar de alta un Ingrediente debe ingresar todos los campos");
					}
				}
			}
		}
	});
}