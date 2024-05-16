package controlador.alumnos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloAlumno;

/**
 * Implementación del Servlet DestroyAlumnos
 * Este servlet maneja la eliminación de un alumno en la base de datos.
 */
@WebServlet("/DestroyAlumnos")
public class DestroyAlumnos extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet DestroyAlumnos.
     */
    public DestroyAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP GET. Recibe la ID del alumno a eliminar, 
     * realiza la eliminación y redirige con un mensaje de éxito.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
     * @throws IOException      si la solicitud GET no se puede manejar
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir la ID del alumno
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Eliminar al alumno
        ModeloAlumno modeloAlumno = new ModeloAlumno();
        modeloAlumno.delete(id);
        
        // Redirigir con un mensaje de éxito
        response.sendRedirect("IndexAlumnos?msg=deleteOk");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP POST. Delegado al método doGet.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
     * @throws IOException      si la solicitud POST no se puede manejar
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
