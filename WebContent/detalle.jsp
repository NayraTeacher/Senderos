<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Detalle de la ruta - ${ruta.nombre}</title>
 
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

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">ID: ${ruta.id}</h3>
        </div>
        <div class="panel-body">
          <h5><b>Ruta</b>: ${ruta.nombre}</h5>
          <h5><b>Publicado</b>: ${ruta.fecha}</h5>  
          <h5><b>Localizacion</b>: ${ruta.localizacion}</h5>                              
          <b>Distancia</b>: <p class="text-justify">${ruta.distancia} Kms</p>
          <b>Desnivel</b>: <p class="text-justify">${ruta.desnivel} m acumulado</p>
          <b>Dificultad</b>: <p class="text-justify">${ruta.dificultad}</p>
          <b>Usuario</b>: <p class="text-justify">${ruta.usuario}</p>
        </div>
        
      </div>      
      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2020 NDB.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
