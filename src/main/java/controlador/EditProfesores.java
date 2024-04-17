package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProfesor;
import modelo.Profesor;

/**
 * Servlet implementation class EditProfesores
 */
@WebServlet("/EditProfesores")
public class EditProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfesores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//conseguir el profesor
		ModeloProfesor modeloProfesor = new ModeloProfesor();
		Profesor profesor = modeloProfesor.get(id);
		
		//enviar profesor a la vista
		request.setAttribute("profesor", profesor);
		
		//abrir vista
		request.getRequestDispatcher("editProfesor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
