<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Administración del Sistema</title>
     <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/small-business.css" rel="stylesheet">
  </head>

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">Menu</h3>
        <nav>
          <ul class="nav nav-justified">
          	<li><a href="homepage">Inicio</a></li>
            <li><a href="admin?action=crear">Nueva ruta</a></li>            
            <li><a href="ruta?action=lista">Rutas</a></li>            
          </ul>
        </nav>
      </div>
      <br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Sistema</h3>          
        </div>
        <div class="panel-body">
            <h4>${message}</h4>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2020 NDB.</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
