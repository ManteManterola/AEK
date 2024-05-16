package controlador.cursos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Curso;
import modelo.ModeloCurso;
import modelo.ModeloProfesor;
import modelo.Profesor;

/**
 * Implementación del Servlet IndexCursos.
 * Este servlet maneja la visualización de la lista de cursos y profesores.
 */
@WebServlet("/IndexCursos")
public class IndexCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet IndexCursos.
     */
    public IndexCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET para mostrar la lista de cursos y profesores.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Establecer el mensaje recibido en la solicitud
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener la lista de todos los cursos y profesores
		ArrayList<Curso> cursos = new ModeloCurso().getAll();
		ArrayList<Profesor> profesores = new ModeloProfesor().getAll();
		
		// Establecer los atributos para cursos y profesores
		request.setAttribute("profesores", profesores);
		request.setAttribute("cursos", cursos);

		// Redirigir a la página JSP para mostrar los cursos y profesores
		request.getRequestDispatcher("indexCurso.jsp").forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirigir la solicitud POST a doGet
		doGet(request, response);
	}

}
