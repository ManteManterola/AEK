package controlador.programas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloPrograma;


/**
 * Servlet implementation class DestroyProgramas
 */
@WebServlet("/DestroyProgramas")
public class DestroyProgramas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyProgramas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir la id
				int id = Integer.parseInt(request.getParameter("idCurso"));
				
				//eliminar el seguimiento
				ModeloPrograma modeloPrograma = new ModeloPrograma();
				modeloPrograma.delete(id);
				
				// abrir lo que quiera, en mi caso inicio
				// como ya tengo un controlador que abra el inicio redirijo a ese controlador
				response.sendRedirect("IndexProgramas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
