<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <link rel="icon" href="favicon.ico">
    <title>Rutas</title>
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
        <h3 class="text-muted">Menu</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="admin?action=crear">Nueva ruta</a></li>            
            <li><a href="ruta?action=lista">Rutas</a></li>            
          </ul>
        </nav>
      </div>

      <br>    
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Nueva ruta</h3>
        </div>
        
        <!-- 	private int id;
	private String nombre;
	private int distancia;
	private int desnivel;
	private String fecha;
	private String localizacion;
	private int dificultad;
	private String usuario; -->
        <div class="panel-body">
         <form action="ruta" method="post">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" name="nombre" id="nombre" value="" placeholder="Escriba el nombre de la ruta">
            </div>                   
            <div class="form-group">
              <label for="nombre">Distancia</label>
              <input type="text" class="form-control" name="distancia" id="distancia" value="" placeholder="Distancia en Km">
            </div>
            <div class="form-group">
              <label for="nombre">Desnivel</label>
              <input type="text" class="form-control" name="desnivel" id="desnivel" value="" placeholder="Desnivel acumulado">
            </div>                   
            <div class="form-group">
              <label for="nombre">Fecha</label>
              <input type="date" class="form-control" name="fecha" id="fecha" value="" placeholder="Fecha de realizacion">
            </div>
            <div class="form-group">
              <label for="nombre">Localizacion</label>
              <input type="text" class="form-control" name="localizacion" id="localizacion" value="" placeholder="Lugar donde se encuentra">
            </div>                   
            <div class="form-group">
              <label for="nombre">Dificultad</label>
              <input type="text" class="form-control" name="dificultad" id="dificultad" value="1" placeholder="1=facil, 2=media, 3=dificil">
            </div>
            <div class="form-group">
              <label for="nombre">Usuario</label>
              <input type="text" class="form-control" name="usuario" id="usuario" value="${usuario}" placeholder="Email del usuario">
            </div>                              
            <button type="submit" class="btn btn-primary btn-sm" >Guardar</button>
          </form>
        </div>
      </div>
            
      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; 2017 JASR.</p>
      </footer>
    </div> <!-- /container -->
  </body>
</html>
