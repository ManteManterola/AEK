package controlador.cursos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloCurso;

/**
 * Implementación del Servlet DestroyCursos
 * Este servlet maneja la eliminación de un curso específico.
 */
@WebServlet("/DestroyCursos")
public class DestroyCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet DestroyCursos.
	 */
	public DestroyCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET para eliminar un curso.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir la id del curso
		int id = Integer.parseInt(request.getParameter("id"));

		// Crear una instancia del modelo del curso
		ModeloCurso modeloCurso = new ModeloCurso();

		// Verificar si el curso tiene algún alumno asociado
		if (modeloCurso.tieneAlgunAlumno(id) == true) {
			// Redirigir con mensaje de error si el curso tiene alumnos
			response.sendRedirect("IndexCursos?msg=deleteError");
		} else {
			// Eliminar el curso si no tiene alumnos asociados
			modeloCurso.delete(id);
			// Redirigir con mensaje de éxito
			response.sendRedirect("IndexCursos?msg=deleteOk");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP POST redirigiendo a doGet.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Redirigir la solicitud POST a doGet
		doGet(request, response);
	}
}
