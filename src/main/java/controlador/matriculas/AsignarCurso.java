package controlador.matriculas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;

/**
 * Servlet implementation class AsignarCurso
 */
@WebServlet("/AsignarCurso")
public class AsignarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsignarCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		// Obtener el ID del curso seleccionado
		String idCurso = request.getParameter("idCurso");
		
		// Obtener la lista de IDs de alumnos seleccionados
		String[] alumnosSeleccionados = request.getParameterValues("alumnosSeleccionados[]");
		if(idCurso==null || alumnosSeleccionados==null) {}else {
		//Matricular a los alumnos en el curso
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.matricular(idCurso, alumnosSeleccionados);
		}
		// abrir lo que quiera, en mi caso inicio
		// como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexMatriculas");
	}

}
