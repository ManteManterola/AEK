package controlador.matriculas;

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
 * Implementaci�n del Servlet IndexMatriculas.
 * Este servlet se encarga de manejar la p�gina de �ndice de matr�culas, mostrando los alumnos nuevos y los cursos disponibles para matricularse.
 */
@WebServlet("/IndexMatriculas")
public class IndexMatriculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet IndexMatriculas.
     */
    public IndexMatriculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet env�a al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Establecer mensaje de informaci�n si lo hay
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener la lista de alumnos nuevos y cursos disponibles
		ArrayList<Alumno> alumnosNuevos = new ModeloAlumno().getAlumnosNuevos();
		ArrayList<Curso> cursos = new ModeloCurso().getAll();
		
		// Establecer atributos para la lista de alumnos nuevos y cursos
		request.setAttribute("alumnosNuevos", alumnosNuevos);
		request.setAttribute("cursos", cursos);
		
		// Redirigir a la p�gina de �ndice de matr�culas
		request.getRequestDispatcher("indexMatricula.jsp").forward(request, response);
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
		// M�todo POST no implementado
		doGet(request, response);
	}

}
