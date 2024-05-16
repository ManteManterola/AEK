package controlador.programas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Curso;
import modelo.ModeloCurso;
import modelo.ModeloPrograma;
import modelo.Programa;

/**
 * Implementación del Servlet IndexProgramas.
 * Este servlet se encarga de mostrar la página de índice de programas, que incluye la lista de programas y los cursos sin asignar a ningún programa.
 */
@WebServlet("/IndexProgramas")
public class IndexProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet IndexProgramas.
     */
    public IndexProgramas() {
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
		request.setAttribute("msg", request.getParameter("msg"));
		
		// Obtener la lista de programas y cursos sin programa asignado
		ArrayList<Programa> programas = new ModeloPrograma().getAll();
		ArrayList<Curso> cursosSinPrograma = new ModeloCurso().cursosSinPrograma();
		
		// Establecer atributos en el request para mostrar en la página JSP
		request.setAttribute("programas", programas);
		request.setAttribute("cursosSinPrograma", cursosSinPrograma);
		
		// Redirigir la solicitud a la página de índice de programas
		request.getRequestDispatcher("indexPrograma.jsp").forward(request, response);
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
		// Redirigir las solicitudes POST a doGet
		doGet(request, response);
	}

}
