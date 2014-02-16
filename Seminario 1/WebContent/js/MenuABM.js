var xml;
var idMenuChecked;
var menuEnsalada;
var menuPltoPrincipal
var menuPostre;
var menuTag;
var menuCalorias;
var menuEstado;
function createMenu(){
	var options="";
	for(var i=0; i<tags.length;i++){
		options+="<option value='"+tags[i]['id']+"'>"+tags[i]['value']+"</option>";
	}

	bootbox
	.dialog({
		message : "<form id='createMenu' method='post' action='MenuServlet?action=altaMenu'>"
				+ "<label>Ensalada </label> " 
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Ensalada</button></span></div>"
				+ "<br/>"
				+ "<label>Plato Principal </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Principal</button></span></div>"
				+ "<br/>"
				+ "<label>Postre </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Postre</button></span></div>"
				+ "<br/>"
				+ "<label>Tag</label><select name=\"tag\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Calorias </label><input type=\"text\" class=\"form-control\" id='caloriasInput' name=\"calorias\" autofocus>"
				+ "<br/>"
				+ "<label>Estado&nbsp;</label>&nbsp;<input type='radio' name='status' value='ok' checked='chekced'>&nbsp;Activo&nbsp;<input type='radio' name='status' value='no'>&nbsp;Inactivo "
				+ "<br/>"
				+ "</form>",
		title : "Agregar Menu",
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
}

function showOpenDetialsIngrediente(){
	var options="";
	
	for(var i=0; i<tags.length;i++){
		var checked;
		if(menuTag == tags[i]['value']){
			checked = "selected";
		}
		options+="<option value='"+tags[i]['id']+"' "+ checked+">"+tags[i]['value']+"</option>";
	}
	if( menuEstado == "ACTIVO"){
		var activo = "checked=\"chcked\"";
		var inactivo = "";
	}else{
		var inactivo = "checked=\"chcked\"";
		var activo = "";
	}
	bootbox
	.dialog({
		message : "<form id='createMenu' method='post' action='MenuServlet?action=altaMenu'>"
				+ "<label>Ensalada </label> " 
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\""+menuEnsalada+"\" disabled><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\" value=\"\">Buscar Ensalada</button></span></div>"
				+ "<br/>"
				+ "<label>Plato Principal </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\""+menuPltoPrincipal+"\" disabled><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Principal</button></span></div>"
				+ "<br/>"
				+ "<label>Postre </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\""+menuPostre+"\" disabled><span class=\"input-group-btn\" ><button class=\"btn btn-default\" type=\"submit\">Buscar Postre</button></span></div>"
				+ "<br/>"
				+ "<label>Tag</label><select name=\"tag\" disabled>"+options+"</select>"
				+ "<br/>"
				+ "<label>Calorias </label><input type=\"text\" class=\"form-control\" id='caloriasInput' name=\"calorias\" autofocus value=\""+menuCalorias+"\" disabled>"
				+ "<br/>"
				+ "<label>Estado&nbsp;</label>&nbsp;<input type='radio' name='status' value='ok' "+activo+" disabled>&nbsp;Activo&nbsp;<input type='radio' name='status' value='no' disabled "+inactivo+">&nbsp;Inactivo "
				+ "<br/>"
				+ "</form>",
		title : "Detalle Menu",
		buttons : {
			success : {
				label : "Confirmar",
				className : "btn-success",
				callback : function() {
					
				}
			}
		}
	});
}
function showOpenEditMenu(){
	var options="";
	
	for(var i=0; i<tags.length;i++){
		var checked;
		if(menuTag == tags[i]['value']){
			checked = "selected";
		}
		options+="<option value='"+tags[i]['id']+"' "+ checked+">"+tags[i]['value']+"</option>";
	}
	if( menuEstado == "ACTIVO"){
		var activo = "checked=\"chcked\"";
		var inactivo = "";
	}else{
		var inactivo = "checked=\"chcked\"";
		var activo = "";
	}
	bootbox
	.dialog({
		message : "<form id='createMenu' method='post' action='MenuServlet?action=altaMenu'>"
				+ "<label>Ensalada </label> " 
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\""+menuEnsalada+"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\" value=\"\">Buscar Ensalada</button></span></div>"
				+ "<br/>"
				+ "<label>Plato Principal </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"searchInput\" name=\"valor\" value=\""+menuPltoPrincipal+"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Principal</button></span></div>"
				+ "<br/>"
				+ "<label>Postre </label>"
				+ "<br/>"
				+ "<div class=\"input-group\"><input type=\"text\" class=\"form-control\" id=\"valorinput\" name=\"valor\" value=\""+menuPostre+"\"><span class=\"input-group-btn\"><button class=\"btn btn-default\" type=\"submit\">Buscar Postre</button></span></div>"
				+ "<br/>"
				+ "<label>Tag</label><select name=\"tag\">"+options+"</select>"
				+ "<br/>"
				+ "<label>Calorias </label><input type=\"text\" class=\"form-control\" id='caloriasInput' name=\"calorias\" autofocus value=\""+menuCalorias+"\">"
				+ "<br/>"
				+ "<label>Estado&nbsp;</label>&nbsp;<input type='radio' name='status' value='ok' checked='chekced' "+activo+">&nbsp;Activo&nbsp;<input type='radio' name='status' value='no' "+inactivo+">&nbsp;Inactivo "
				+ "<br/>"
				+ "</form>",
		title : "Editar Menu",
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
}
function showAlertMensaje(mesnaje){
	bootbox.alert(mesnaje, function() {createIngrediente();});
}

function deleteMenu (){	
	if(idMenuChecked != ""){	
		bootbox.dialog({
			  message: "<h3>Esta seguro que desea eliminar el Menu seleccionado?</h2>"+
			  "<form id='deletemenu' method='post' action='MenuServlet?action=eliminarMenu'>"+
				"<input type='hidden' name='idMenu' value='"+idMenuChecked+"'/>"+
		        "</form>",
			  title: "Eliminar Menu",
			  buttons: {
			    success: {
			      label: "Confirmar",
			      className: "btn-success",
			      callback: function() {
			    	 
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
function unChecked(obj, idMenuselected){
	var checks = $( ":checkbox" );
	for (var i = 0; i<checks.length; i++){
		if(checks[i] != obj) checks[i].checked = false;
	}
	idMenuChecked = idMenuselected;
	console.log($(obj).parent().parent().find("td").size());
	var strings = $(obj).parent().parent().find("td").map(function() {return $(this).text();});
	menuEnsalada = strings[1];
	menuPltoPrincipal = strings[2];
	menuPostre = strings[3];
	menuTag = strings[4];
	menuCalorias = strings[5];
	menuEstado = strings[6];
}
