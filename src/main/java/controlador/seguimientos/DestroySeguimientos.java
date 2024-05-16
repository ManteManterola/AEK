package controlador.seguimientos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloSeguimiento;

/**
 * Implementación del Servlet DestroySeguimientos.
 * Este servlet se encarga de eliminar un seguimiento de un alumno en la base de datos.
 */
@WebServlet("/DestroySeguimientos")
public class DestroySeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet DestroySeguimientos.
     */
    public DestroySeguimientos() {
        super();
    }

	/**
	 * Maneja las solicitudes HTTP GET.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se produce un error en la ejecución del servlet
	 * @throws IOException      si se produce un error de entrada/salida
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recibir el ID del alumno cuyo seguimiento se eliminará
		int id = Integer.parseInt(request.getParameter("idAlumno"));
		
		// Eliminar el seguimiento del alumno de la base de datos
		ModeloSeguimiento modeloSeguimiento = new ModeloSeguimiento();
		modeloSeguimiento.delete(id);
		
		// Redirigir a la página de índice de seguimientos con un mensaje indicando que la eliminación fue exitosa.
		response.sendRedirect("IndexSeguimientos?msg=deleteOk");
	}

	/**
	 * Maneja las solicitudes HTTP POST.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se produce un error en la ejecución del servlet
	 * @throws IOException      si se produce un error de entrada/salida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Reenviar la solicitud HTTP a doGet
		doGet(request, response);
	}

}
