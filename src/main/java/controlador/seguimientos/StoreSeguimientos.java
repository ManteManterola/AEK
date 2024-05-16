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
 * Servlet implementation class StoreSeguimientos
 * Este servlet gestiona la inserci�n de nuevos seguimientos en la base de datos a trav�s de una solicitud POST.
 */
@WebServlet("/StoreSeguimientos")
public class StoreSeguimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 * Constructor por defecto.
	 */
	public StoreSeguimientos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Este m�todo maneja las solicitudes GET.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// M�todo vac�o, la l�gica para manejar la inserci�n de seguimientos se realiza en doPost.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Este m�todo maneja las solicitudes POST, recibe los datos del seguimiento y los inserta en la base de datos.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir los datos del seguimiento
		String faltas = request.getParameter("faltas");
		// Validar que "faltas" sea un n�mero entero
		if (Validator.esNumeroEntero(faltas)) {
			String participacion = request.getParameter("participacion");
			String rendimiento = request.getParameter("rendimiento");
			int nota = Integer.parseInt(request.getParameter("nota"));
			int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
			
			// Almacenar el seguimiento en la base de datos
			ModeloAlumno modeloAlumno = new ModeloAlumno();
			Seguimiento seguimiento = new Seguimiento();
			seguimiento.setFaltas(Integer.parseInt(faltas));
			seguimiento.setParticipacion(participacion);
			seguimiento.setRendimiento(rendimiento);
			seguimiento.setNota(nota);
			seguimiento.setAlumno(modeloAlumno.get(idAlumno));
			
			ModeloSeguimiento modeloSeguimiento = new ModeloSeguimiento();
			modeloSeguimiento.insert(seguimiento);
			response.sendRedirect("IndexSeguimientos?msg=insertOk");	
		} else {
			response.sendRedirect("IndexSeguimientos?msg=insertError");
		}
	}
}
