package controlador.historico;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloHistorico;

/**
 * Implementaci�n del Servlet DestroyHistoricos.
 * Este servlet maneja la eliminaci�n de registros hist�ricos en la base de datos.
 */
@WebServlet("/DestroyHistoricos")
public class DestroyHistoricos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet DestroyHistoricos.
     */
    public DestroyHistoricos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET para eliminar un registro hist�rico.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recibir la id del curso
		int id = Integer.parseInt(request.getParameter("idCurso"));
		
		// eliminar el registro hist�rico
		ModeloHistorico modeloHistorico = new ModeloHistorico();
		modeloHistorico.delete(id);
		
		// redireccionar a la p�gina de �ndice de registros hist�ricos con un mensaje de eliminaci�n exitosa
		response.sendRedirect("IndexHistoricos?msg=deleteOk");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP POST.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
