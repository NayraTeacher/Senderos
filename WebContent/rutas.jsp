<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Lista de todas las rutas</title>
     <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/small-business.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Rutas</h3>
        <nav>
          <ul class="nav nav-justified">
          	<li><a href="homepage">Inicio</a></li>
            <li><a href="admin?action=crear">Nueva ruta</a></li>            
            <li><a href="ruta?action=lista">Rutas</a></li>            
          </ul>
        </nav>
      </div>
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar ruta..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-primary btn-sm">Buscar</button>
      </form>
      <br><br><br>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Lista de Rutas</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">ID</th>
                <th>Ruta</th>
                <th>Publicada</th>                
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${rutas}" var="ruta" varStatus="status">
                <tr>
                  <td class="left">${ruta.id}</td>
                  <td>${ruta.nombre}</td>
                  <td>${ruta.fecha}</td>
                  <td><a class="btn btn-primary btn-sm" href="ruta?action=ver&id=${ruta.id}" role="button">Ver Detalles</a>
                  </td>  
                </tr>
              </c:forEach>                      
            </tbody>           
          </table>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2020 NDB.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
