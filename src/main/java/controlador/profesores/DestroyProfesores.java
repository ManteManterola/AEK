package controlador.profesores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProfesor;

/**
 * Servlet implementation class DestroyProfesores
 */
@WebServlet("/DestroyProfesores")
public class DestroyProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DestroyProfesores() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModeloProfesor modeloProfesor = new ModeloProfesor();

		// recibir la id
		int idProfesor = Integer.parseInt(request.getParameter("id"));
		if (modeloProfesor.imparteAlgunCurso(idProfesor)) {
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		else {
			
			// eliminar el profesor
			modeloProfesor.deleteProfesor(idProfesor);
		}

		

		// abrir lo que quiera, en mi caso inicio
		// como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexProfesores");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
