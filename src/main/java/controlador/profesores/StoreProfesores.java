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
 * Servlet implementation class StoreProfesores
 */
@WebServlet("/StoreProfesores")
public class StoreProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreProfesores() {
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
		// recibir los datos del profesor
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");

		// almacenar la tarea en la BBDD
		Profesor profesor = new Profesor();
		profesor.setDni(dni);
		profesor.setNombre(nombre);
		profesor.setApellido(apellido);

		ModeloProfesor modeloProfesor = new ModeloProfesor();

		// enviar mensaje de respuesta y decidir si insertar o no
		if(Validator.validarDni(dni)==true && modeloProfesor.checkDniRepetido(dni)==false) {
			modeloProfesor.insertarProfesor(profesor);
			response.sendRedirect("IndexProfesores?msg=insertOk");
		} else if (Validator.validarDni(dni)==false){
			response.sendRedirect("IndexProfesores?msg=errorFormatoDniInsert");
		} else {
			response.sendRedirect("IndexProfesores?msg=errorDniRepetidoInsert");
		}
	}

}
