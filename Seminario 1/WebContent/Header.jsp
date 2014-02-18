<% String pageName = utilidades.Utils.extractPageNameFromURLString(request.getRequestURI()); %>
<nav class="navbar navbar-default" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Seminario I / La Cocina de Silvia</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li <% if(pageName.equals("Home.jsp")) out.println("class=\"active\"");%> ><a href="Home.jsp">Inicio</a></li>
			<li <%if(pageName.equals("Clientes.jsp")) out.println("class=\"active\"");%>><a href="Clientes.jsp">Clientes</a></li>
			<li <%if(pageName.equals("Ingredientes.jsp")) out.println("class=\"active\"");%>><a href="Ingredientes.jsp">Ingredientes</a></li>
			<li <%if(pageName.equals("Platos.jsp")) out.println("class=\"active\"");%>><a href="Platos.jsp">Platos</a></li>
			<li <%if(pageName.equals("Menus.jsp")) out.println("class=\"active\"");%>><a href="Menus.jsp">Menus</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown">Compras <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="OrdenesCompras.jsp">Ordenes de Compras</a></li>
					<li><a href="#">Listado sarasa ....</a></li>

				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown">Planes <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="GenerarPlan.jsp">Genera Plan</a></li>
					<li><a href="ViewPlanVigente.jsp">Plan Vigente</a></li>
					<li><a href="#">Listar Planes...</a></li>

				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>