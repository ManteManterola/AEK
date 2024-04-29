package controlador.alumnos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Alumno;
import modelo.ModeloAlumno;
import modelo.ModeloCurso;

/**
 * Servlet implementation class UpdateAlumnos
 */
@WebServlet("/UpdateAlumnos")
public class UpdateAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAlumnos() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));

		// guardar en la BBDD
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		ModeloCurso modeloCurso = new ModeloCurso();
		Alumno alumno = new Alumno();
		alumno.setId(id);
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellido(apellido);
		alumno.setEdad(edad);
		alumno.setCurso(modeloCurso.get(idCurso));

		modeloAlumno.update(alumno);

		// abrir lo que quiera, en mi caso inicio
		// como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexAlumnos");
	}

}
