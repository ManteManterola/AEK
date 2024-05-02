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
 * Servlet implementation class AsignCurso
 */
@WebServlet("/AsignCurso")
public class AsignCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recibir los datos del alumno
		int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));

		// guardar en la BBDD
		ModeloAlumno modeloAlumno = new ModeloAlumno();
		modeloAlumno.asignarCurso(idAlumno,idCurso);

		// abrir lo que quiera, en mi caso inicio
		// como ya tengo un controlador que abra el inicio redirijo a ese controlador
		response.sendRedirect("IndexAlumnos");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
