package controlador.cursos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloCurso;

/**
 * Servlet implementation class DestroyCursos
 */
@WebServlet("/DestroyCursos")
public class DestroyCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DestroyCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir la id
		int id = Integer.parseInt(request.getParameter("id"));

		// eliminar el curso
		ModeloCurso modeloCurso = new ModeloCurso();
		if(modeloCurso.tieneAlgunAlumno(id)==true) {
			response.sendRedirect("IndexCursos?msg=deleteError");
		} else {
			// eliminar el curso
			modeloCurso.delete(id);
			response.sendRedirect("IndexCursos?msg=deleteOk");
		}

		
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
