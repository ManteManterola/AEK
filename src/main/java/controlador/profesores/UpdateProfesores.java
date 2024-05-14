package controlador.profesores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProfesor;
import modelo.Profesor;
import modelo.Validator;

/**
 * Servlet implementation class UpdateProfesor
 */
@WebServlet("/UpdateProfesores")
public class UpdateProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfesores() {
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
		// recibir los datos de profesor
		int id = Integer.parseInt(request.getParameter("id"));
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");

		// almacenar el profesor en la bbdd
		Profesor profesor = new Profesor();
		profesor.setId(id);
		profesor.setDni(dni);
		profesor.setNombre(nombre);
		profesor.setApellido(apellido);

		ModeloProfesor modeloProfesor = new ModeloProfesor();
		
		if(modeloProfesor.checkDniNoHaCambiado(profesor)==true) {
			modeloProfesor.update(profesor);
			response.sendRedirect("IndexProfesores?msg=editOk");
		} else if (Validator.validarDni(dni)==true && modeloProfesor.checkDniRepetido(dni)==false) {
			modeloProfesor.update(profesor);
			response.sendRedirect("IndexProfesores?msg=editOk");
		} else if (Validator.validarDni(dni)==false) {
			response.sendRedirect("IndexProfesores?msg=errorFormatoDniEdit");
		} else {
			response.sendRedirect("IndexProfesores?msg=errorDniRepetidoEdit");
		}

		
	}

}
