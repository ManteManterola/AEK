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
 * Servlet implementation class UpdateCursos
 */
@WebServlet("/UpdateCursos")
public class UpdateCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir los datos de curso
		int id = Integer.parseInt(request.getParameter("id"));
		String nivel = request.getParameter("nivel");
		String turno = request.getParameter("turno");
		int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

		// almacenar el curso en la bbdd
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		Curso curso = new Curso();
		curso.setId(id);
		curso.setNivel(nivel);
		curso.setTurno(turno);
		curso.setProfesor(modeloProfesor.get(idProfesor));

		ModeloCurso modeloCurso = new ModeloCurso();
		modeloCurso.update(curso);

		// abrir lo que quiera, en mi caso inicio
		// como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexCursos");
	}

}
