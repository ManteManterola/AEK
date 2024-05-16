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
 * Implementación del Servlet UpdateCursos.
 * Este servlet maneja la actualización de cursos en la base de datos.
 */
@WebServlet("/UpdateCursos")
public class UpdateCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet UpdateCursos.
	 */
	public UpdateCursos() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * Maneja la solicitud HTTP POST para actualizar un curso.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir los datos de curso
		int id = Integer.parseInt(request.getParameter("id"));
		String nivel = request.getParameter("nivel");
		String turno = request.getParameter("turno");
		int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

		// almacenar el curso en la base de datos
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		Curso curso = new Curso();
		curso.setId(id);
		curso.setNivel(nivel);
		curso.setTurno(turno);
		curso.setProfesor(modeloProfesor.get(idProfesor));

		ModeloCurso modeloCurso = new ModeloCurso();
		
		// Verificar si se pudo actualizar el curso correctamente
		if(modeloCurso.update(curso) == 0) {
			response.sendRedirect("IndexCursos?msg=editError");
		} else {
			response.sendRedirect("IndexCursos?msg=editOk");
		}
	}
}
