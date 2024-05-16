package controlador.seguimientos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;
import modelo.ModeloSeguimiento;
import modelo.Seguimiento;
import modelo.Validator;

/**
 * Servlet implementation class UpdateSeguimientos
 * Este servlet gestiona la actualización de seguimientos en la base de datos a través de una solicitud POST.
 */
@WebServlet("/UpdateSeguimientos")
public class UpdateSeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor por defecto.
	 */
	public UpdateSeguimientos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Este método maneja las solicitudes GET, pero no realiza ninguna acción en esta implementación.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Método vacío, la lógica para manejar la actualización de seguimientos se realiza en doPost.
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Este método maneja las solicitudes POST, recibe los datos del seguimiento a actualizar y realiza la actualización en la base de datos.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir los datos del seguimiento
		String faltas = request.getParameter("faltas");
		// Validar que "faltas" sea un número entero
		if (Validator.esNumeroEntero(faltas)) {
			String participacion = request.getParameter("participacion");
			String rendimiento = request.getParameter("rendimiento");
			int nota = Integer.parseInt(request.getParameter("nota"));
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			
			// Almacenar el seguimiento actualizado en la base de datos
			ModeloAlumno modeloAlumno = new ModeloAlumno();
			Seguimiento seguimiento = new Seguimiento();
			seguimiento.setFaltas(Integer.parseInt(faltas));
			seguimiento.setParticipacion(participacion);
			seguimiento.setRendimiento(rendimiento);
			seguimiento.setNota(nota);
			seguimiento.setAlumno(modeloAlumno.get(idAlumno));
			
			ModeloSeguimiento modeloSeguimiento = new ModeloSeguimiento();
			modeloSeguimiento.update(seguimiento);
			response.sendRedirect("IndexSeguimientos?msg=editOk");	
		} else {
			response.sendRedirect("IndexSeguimientos?msg=editError");
		}
	}

}
