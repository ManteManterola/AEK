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
 * Servlet implementation class StoreCursos
 */
@WebServlet("/StoreCursos")
public class StoreCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreCursos() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir los datos del curso
		String nivel = request.getParameter("nivel");
		String turno = request.getParameter("turno");
		int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

		// almacenar el curso en la bbdd
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		Curso curso = new Curso();
		curso.setNivel(nivel);
		curso.setTurno(turno);
		curso.setProfesor(modeloProfesor.get(idProfesor));

		ModeloCurso modeloCurso = new ModeloCurso();
		if(modeloCurso.insert(curso) == true) {
			response.sendRedirect("IndexCursos?msg=insertOk");
		} else {
			response.sendRedirect("IndexCursos?msg=insertError");
		}

		
	}

}
