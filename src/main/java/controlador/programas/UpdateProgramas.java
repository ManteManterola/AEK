package controlador.programas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloCurso;
import modelo.ModeloPrograma;
import modelo.Programa;

/**
 * Implementación del Servlet UpdateProgramas.
 * Este servlet se encarga de actualizar un programa en la base de datos.
 */
@WebServlet("/UpdateProgramas")
public class UpdateProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet UpdateProgramas.
     */
    public UpdateProgramas() {
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
		// El método GET no se utiliza en esta implementación, por lo que se deja vacío.
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
		// Recibir los datos del programa desde la solicitud
		String contenido = request.getParameter("contenido");
		String criterioEvaluacion = request.getParameter("criterioEvaluacion");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		
		// Almacenar el programa actualizado en la base de datos
		ModeloCurso modeloCurso = new ModeloCurso();
		Programa programa = new Programa();
		programa.setContenido(contenido);
		programa.setCriterioEvaluacion(criterioEvaluacion);
		programa.setCurso(modeloCurso.get(idCurso));
		
		ModeloPrograma modeloPrograma = new ModeloPrograma();
		modeloPrograma.update(programa);
		
		// Redirigir a la página de índice de programas con un mensaje indicando que la actualización fue exitosa.
		response.sendRedirect("IndexProgramas?msg=editOk");
	}
}
