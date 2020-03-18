
package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnDB;
import dao.RutasDao;
import model.Ruta;

/**
 * Servlet implementation class RutaController
 */
@WebServlet("/ruta")
public class RutaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RutaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =request.getParameter("action");
		System.out.println("Accion: " + action);
		if (action.equals("lista"))
			verListado(request, response);
		else if (action.equals("ver"))
			verDetalle(request, response);
		else
			System.out.println("Accion no implementada");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ruta ruta = new Ruta();
		ruta.setNombre(request.getParameter("nombre"));
		ruta.setDistancia(Integer.parseInt(request.getParameter("distancia")));
		ruta.setDesnivel(Integer.parseInt(request.getParameter("desnivel")));
		ruta.setFecha(request.getParameter("fecha"));
		ruta.setDificultad(Integer.parseInt(request.getParameter("dificultad")));
		ruta.setLocalizacion(request.getParameter("localizacion"));
		ruta.setUsuario(request.getParameter("usuario"));

		if (request.getSession().getAttribute("usuario") == null) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}
		
		//Imprimimos el objeto en consola (método toString)
        System.out.println(ruta);
        
        // Procesamos los datos a guardar en BD
        ConnDB conn = new ConnDB();
        RutasDao rdao = new RutasDao(conn);
        boolean status = rdao.insert(ruta);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "El servidor fue guardado correctamente.";
        } else {
            msg = "Ocurrio un error. El servidor no fue guardado.";
        }
        conn.disconnect();
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta a la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);
	}

	private void verListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       	ConnDB conn = new ConnDB();
	        RutasDao rdao = new RutasDao(conn);
	        List<Ruta> lista = rdao.getAll();
	        conn.disconnect();
	        // Compartimos la variable lista, para poder accederla desde la vista
	        request.setAttribute("rutas", lista);
	        RequestDispatcher rd;
	        rd = request.getRequestDispatcher("/rutas.jsp");
	        rd.forward(request, response);
		
	}
	
    private void verDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recibimos id del servidor a consultar
        int idruta = Integer.parseInt(request.getParameter("id"));
        ConnDB conn = new ConnDB();
        RutasDao rdao = new RutasDao(conn);
        Ruta ruta = rdao.getById(idruta);
        conn.disconnect();

        // Compartimos la variable srv para acceder desde la vista con Expression Language
        request.setAttribute("ruta", ruta);
        RequestDispatcher rd;

        // Enviarmos respuesta a la vista detalle.jsp
        rd = request.getRequestDispatcher("/detalle.jsp");
        rd.forward(request, response);

    }
	

}
