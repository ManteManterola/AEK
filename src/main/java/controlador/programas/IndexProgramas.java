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
 * Servlet implementation class IndexProgramas
 */
@WebServlet("/IndexProgramas")
public class IndexProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexProgramas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", request.getParameter("msg"));
		
		ArrayList<Programa> programas = new ModeloPrograma().getAll();
		ArrayList<Curso> cursosSinPrograma = new ModeloCurso().cursosSinPrograma();
		
		request.setAttribute("programas", programas);
		request.setAttribute("cursosSinPrograma", cursosSinPrograma);
		request.getRequestDispatcher("indexPrograma.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
