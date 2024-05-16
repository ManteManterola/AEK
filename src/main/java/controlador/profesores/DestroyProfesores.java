package controlador.profesores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProfesor;

/**
 * Implementación del Servlet DestroyProfesores.
 * Este servlet se encarga de manejar la eliminación de un profesor.
 */
@WebServlet("/DestroyProfesores")
public class DestroyProfesores extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     * Constructor para el servlet DestroyProfesores.
     */
    public DestroyProfesores() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP GET para eliminar un profesor.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud GET
     * @throws IOException      si la solicitud GET no se puede manejar
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModeloProfesor modeloProfesor = new ModeloProfesor();

        // Recibir el ID del profesor
        int idProfesor = Integer.parseInt(request.getParameter("id"));

        // Verificar si el profesor imparte algún curso
        if (modeloProfesor.imparteAlgunCurso(idProfesor) == true) {
            response.sendRedirect("IndexProfesores?msg=deleteError");
        } else {
            // Eliminar el profesor
            modeloProfesor.deleteProfesor(idProfesor);
            response.sendRedirect("IndexProfesores?msg=deleteOk");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP POST para eliminar un profesor.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se detecta un error de entrada o salida cuando el servlet maneja la solicitud POST
     * @throws IOException      si la solicitud POST no se puede manejar
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Método POST no implementado
        doGet(request, response);
    }
}
