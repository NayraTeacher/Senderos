<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Mis senderos por el mundo</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/small-business.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Menu</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="About.html">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="rutas.jsp">Busqueda</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Alfaro-Sotos-Sendero.JPG/800px-Alfaro-Sotos-Sendero.JPG" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
        <h1 class="font-weight-light">Registro de senderos</h1>
        <p>En esta web se pretende dar informacion de rutas y senderos de todo el mundo, para el disfrute del personal y el acercamiento al mundo natural que tanto nos hace falta</p>
        <a class="btn btn-primary" href="rutas.jsp">Buscalos!</a>
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <!-- Call to Action Well -->
    <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body">
        <p class="text-white m-0">Solo publicamos senderos confirmados y realizados por alguno de los miembros del euipo o de los clubes a los que pertenecemos!</p>
      </div>
    </div>

    <!-- Content Row -->
    <div class="row">
    
           <c:forEach items="${ultimos}" var="ruta" varStatus="status">

               <div class="col-md-4 mb-5">
        <div class="card h-100">
          <div class="card-body">
            <h2 class="card-title">${ruta.nombre}</h2>
            <p class="card-text">Distancia: ${ruta.distancia} Km</p>
            <p class="card-text">Desnivel: ${ruta.desnivel} metros positivos acumulados</p>
          </div>
          <div class="card-footer">
            <a href="ruta?action=ver&id=${ruta.id}" class="btn btn-primary btn-sm">Ver mas</a>
          </div>
        </div>
      </div>

        </c:forEach> 
 

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Senderos NDB 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
