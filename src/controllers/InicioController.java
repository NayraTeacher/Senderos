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
 * Servlet implementation class InicioController
 */
@WebServlet("/homepage")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher rd;        
	        ConnDB conn = new ConnDB();
	        RutasDao rdao = new RutasDao(conn);
	        List<Ruta> lista = rdao.getUltimos3();
	        conn.disconnect();
	        request.setAttribute("ultimos", lista);
	        rd = request.getRequestDispatcher("/index.jsp");
	        rd.forward(request, response);
	}

}
