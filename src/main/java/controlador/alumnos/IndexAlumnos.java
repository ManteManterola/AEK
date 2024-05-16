package controlador.alumnos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import modelo.Curso;
import modelo.ModeloAlumno;
import modelo.ModeloCurso;


/**
 * Implementación del Servlet IndexAlumnos
 * Este servlet maneja la visualización de la lista de alumnos y cursos.
 */
@WebServlet("/IndexAlumnos")
public class IndexAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet IndexAlumnos.
	 */
	public IndexAlumnos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET. Obtiene las listas de alumnos y cursos, y las 
	 * añade a la solicitud para ser mostradas en la vista.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener y establecer el mensaje en la solicitud
		request.setAttribute("msg", request.getParameter("msg"));

		// Obtener todas las listas de alumnos y cursos
		ArrayList<Alumno> alumnos = new ModeloAlumno().getAll();
		ArrayList<Curso> cursos = new ModeloCurso().getAll();
		
		// Establecer las listas en la solicitud
		request.setAttribute("alumnos", alumnos);
		request.setAttribute("cursos", cursos);

		// Reenviar la solicitud a la vista indexAlumno.jsp
		request.getRequestDispatcher("indexAlumno.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP POST. Delegado al método doGet.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Delegar el manejo de la solicitud POST al método doGet
		doGet(request, response);
	}

}
