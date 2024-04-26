package controlador.curso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Curso;
import modelo.ModeloCurso;

/**
 * Servlet implementation class EditCursos
 */
@WebServlet("/EditCursos")
public class EditCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//conseguir el curso
		ModeloCurso modeloCurso = new ModeloCurso();
		Curso curso = modeloCurso.get(id);
		
		//enviar el curso a la vista
		request.setAttribute("curso", curso);
		
		//abrir vista
		request.getRequestDispatcher("editCurso.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
