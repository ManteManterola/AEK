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
 * Implementación del Servlet StoreProfesores.
 * Este servlet se encarga de almacenar un nuevo profesor en la base de datos.
 */
@WebServlet("/StoreProfesores")
public class StoreProfesores extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     * Constructor del servlet StoreProfesores.
     */
    public StoreProfesores() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP GET.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se produce un error en la ejecución del servlet
     * @throws IOException      si se produce un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * Maneja la solicitud HTTP POST para almacenar un nuevo profesor.
     * 
     * @param request  Objeto HttpServletRequest que contiene la solicitud realizada por el cliente al servlet
     * @param response Objeto HttpServletResponse que contiene la respuesta que el servlet envía al cliente
     * @throws ServletException si se produce un error en la ejecución del servlet
     * @throws IOException      si se produce un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibir los datos del profesor
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        // Almacenar el profesor en la base de datos
        Profesor profesor = new Profesor();
        profesor.setDni(dni);
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);

        ModeloProfesor modeloProfesor = new ModeloProfesor();

        // Enviar mensaje de respuesta y decidir si insertar o no
        if (Validator.validarDni(dni) && !modeloProfesor.checkDniRepetido(dni)) {
            modeloProfesor.insertarProfesor(profesor);
            response.sendRedirect("IndexProfesores?msg=insertOk");
        } else if (!Validator.validarDni(dni)) {
            response.sendRedirect("IndexProfesores?msg=errorFormatoDniInsert");
        } else {
            response.sendRedirect("IndexProfesores?msg=errorDniRepetidoInsert");
        }
    }

}
