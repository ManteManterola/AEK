package controlador.alumnos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import modelo.ModeloAlumno;
import modelo.Validator;

/**
 * Servlet implementation class StoreAlumnos
 */
@WebServlet("/StoreAlumnos")
public class StoreAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreAlumnos() {
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
		// recibir los datos del alumno
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Integer edad = request.getParameter("edad") != "" ? Integer.parseInt(request.getParameter("edad")) : null;

		
		if (edad == null) {
			response.sendRedirect("IndexAlumnos?msg=edadInsuficiente");
			return;
		}

		// guardar en la BBDD
		Alumno alumno = new Alumno();
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellido(apellido);
		alumno.setEdad(edad);

		ModeloAlumno modeloAlumno = new ModeloAlumno();

		// enviar mensaje de respuesta y decidir si insertar o no
		if (Validator.validarDni(dni) == true && modeloAlumno.checkDniRepetido(dni) == false && edad >= 16) {
			modeloAlumno.insert(alumno);
			response.sendRedirect("IndexAlumnos?msg=insertOk");
		} else if (edad < 16) {
			response.sendRedirect("IndexAlumnos?msg=edadInsuficiente");
		} else if (modeloAlumno.checkDniRepetido(dni) == true) {
			response.sendRedirect("IndexAlumnos?msg=errorDniRepetidoInsert");
		} else {
			response.sendRedirect("IndexAlumnos?msg=errorFormatoDniInsert");
		}

	}

}
