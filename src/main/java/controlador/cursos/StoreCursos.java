package controlador.cursos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Curso;
import modelo.ModeloCurso;
import modelo.ModeloProfesor;

/**
 * Implementación del Servlet StoreCursos.
 * Este servlet maneja la creación y almacenamiento de cursos en la base de datos.
 */
@WebServlet("/StoreCursos")
public class StoreCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet StoreCursos.
	 */
	public StoreCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * Maneja la solicitud HTTP GET.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * Maneja la solicitud HTTP POST para almacenar un nuevo curso.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir los datos del curso
		String nivel = request.getParameter("nivel");
		String turno = request.getParameter("turno");
		int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

		// almacenar el curso en la base de datos
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		Curso curso = new Curso();
		curso.setNivel(nivel);
		curso.setTurno(turno);
		curso.setProfesor(modeloProfesor.get(idProfesor));

		ModeloCurso modeloCurso = new ModeloCurso();
		
		// Verificar si se seleccionó un profesor válido antes de insertar el curso
		if(idProfesor == 0) {
			response.sendRedirect("IndexProgramas?msg=insertError");
		} else {
			modeloCurso.insert(curso);
			response.sendRedirect("IndexProgramas?msg=insertOk");
		}
	}
}
