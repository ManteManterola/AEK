package controlador.matriculas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;

/**
 * Implementación del Servlet AsignarCurso.
 * Este servlet se encarga de asignar un curso a un conjunto de alumnos seleccionados.
 */
@WebServlet("/AsignarCurso")
public class AsignarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet AsignarCurso.
	 */
	public AsignarCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Método GET no implementado
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID del curso seleccionado
		String idCurso = request.getParameter("idCurso");

		// Obtener la lista de IDs de alumnos seleccionados
		String[] alumnosSeleccionados = request.getParameterValues("alumnosSeleccionados[]");
		
		// Verificar si se ha seleccionado un curso y al menos un alumno
		if (idCurso.equals("0") || alumnosSeleccionados == null) {
			response.sendRedirect("IndexMatriculas?msg=insertError");
		} else {
			// Matricular a los alumnos en el curso
			ModeloAlumno modeloAlumno = new ModeloAlumno();
			modeloAlumno.matricular(idCurso, alumnosSeleccionados);
			response.sendRedirect("IndexMatriculas?msg=insertOk");
		}
		
	}

}
