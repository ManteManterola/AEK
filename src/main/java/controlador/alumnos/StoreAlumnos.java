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
 * Implementación del Servlet StoreAlumnos
 * Este servlet maneja la creación y almacenamiento de nuevos alumnos.
 */
@WebServlet("/StoreAlumnos")
public class StoreAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor para el servlet StoreAlumnos.
	 */
	public StoreAlumnos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP GET. Por ahora, solo escribe una respuesta simple.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
	 * @throws IOException      si la solicitud GET no se puede manejar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Maneja la solicitud HTTP POST. Recibe los datos del alumno, los valida y los almacena en la base de datos.
	 * 
	 * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
	 * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
	 * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
	 * @throws IOException      si la solicitud POST no se puede manejar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir los datos del alumno
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Integer edad = request.getParameter("edad") != "" ? Integer.parseInt(request.getParameter("edad")) : null;

		// Validar la edad del alumno
		if (edad == null) {
			response.sendRedirect("IndexAlumnos?msg=edadInsuficiente");
			return;
		}

		// Crear un objeto Alumno y establecer sus propiedades
		Alumno alumno = new Alumno();
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellido(apellido);
		alumno.setEdad(edad);

		// Crear una instancia de ModeloAlumno para interactuar con la base de datos
		ModeloAlumno modeloAlumno = new ModeloAlumno();

		// Validar los datos del alumno y decidir si insertarlo en la base de datos
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
