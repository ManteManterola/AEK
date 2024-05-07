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
 * Servlet implementation class IndexMatriculas
 */
@WebServlet("/IndexMatriculas")
public class IndexMatriculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexMatriculas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Alumno> alumnosNuevos = new ModeloAlumno().getAlumnosNuevos();
		ArrayList<Curso> cursos = new ModeloCurso().getAll();
		
		request.setAttribute("alumnosNuevos", alumnosNuevos);
		request.setAttribute("cursos", cursos);
		
		request.getRequestDispatcher("indexMatricula.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
