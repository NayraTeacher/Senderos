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
 * Servlet implementation class BuscarController
 */
@WebServlet("/buscar")
public class BuscarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       	ConnDB conn = new ConnDB();
	        RutasDao rdao = new RutasDao(conn);
	        List<Ruta> lista = rdao.getByQuery(request.getParameter("query"));
	        conn.disconnect();
	        // Compartimos la variable lista, para poder accederla desde la vista
	        request.setAttribute("rutas", lista);
	        RequestDispatcher rd;
	        rd = request.getRequestDispatcher("/rutas.jsp");
	        rd.forward(request, response);	
		
	}

}
