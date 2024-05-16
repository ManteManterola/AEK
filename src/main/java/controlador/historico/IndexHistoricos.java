package controlador.historico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Historico;
import modelo.ModeloHistorico;

/**
 * Implementación del Servlet IndexHistoricos.
 * Este servlet maneja la visualización de la lista de registros históricos en la interfaz de usuario.
 */
@WebServlet("/IndexHistoricos")
public class IndexHistoricos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet IndexHistoricos.
     */
    public IndexHistoricos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET para mostrar la lista de registros históricos.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Establecer el mensaje de la solicitud, si hay uno
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener todos los registros históricos
		ArrayList<Historico> historicos = new ModeloHistorico().getAll();
		
		// Establecer los registros históricos como atributo de la solicitud
		request.setAttribute("historicos", historicos);
		
		// Redireccionar a la página de índice de registros históricos
		request.getRequestDispatcher("indexHistorico.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP POST.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
