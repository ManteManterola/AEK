package controlador.seguimientos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import modelo.ModeloAlumno;
import modelo.ModeloSeguimiento;
import modelo.Seguimiento;

/**
 * Implementaci�n del Servlet IndexSeguimientos.
 * Este servlet gestiona la visualizaci�n de la p�gina de �ndice de seguimientos, mostrando la lista de seguimientos y los alumnos sin seguimiento.
 */
@WebServlet("/IndexSeguimientos")
public class IndexSeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet IndexSeguimientos.
     */
    public IndexSeguimientos() {
        super();
    }

	/**
	 * Maneja las solicitudes HTTP GET.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
	 * @throws ServletException si se produce un error en la ejecuci�n del servlet
	 * @throws IOException      si se produce un error de entrada/salida
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Establecer mensaje de informaci�n si se proporciona
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener la lista de seguimientos y de alumnos sin seguimiento
		ArrayList<Seguimiento> seguimientos = new ModeloSeguimiento().getAll();
		ArrayList<Alumno> alumnosSinSeguimiento = new ModeloAlumno().alumnosSinSeguimiento();
		
		// Establecer los atributos de solicitud con los datos obtenidos
		request.setAttribute("alumnosSinSeguimiento", alumnosSinSeguimiento);
		request.setAttribute("seguimientos", seguimientos);
		
		// Reenviar la solicitud a la vista correspondiente para su presentaci�n
		request.getRequestDispatcher("indexSeguimiento.jsp").forward(request, response);
	}

	/**
	 * Maneja las solicitudes HTTP POST.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
	 * @throws ServletException si se produce un error en la ejecuci�n del servlet
	 * @throws IOException      si se produce un error de entrada/salida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Reenviar la solicitud HTTP a doGet
		doGet(request, response);
	}

}
