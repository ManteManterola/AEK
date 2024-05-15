package modelo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProfesorTest {

    @Test
    public void testGetId() {
        // Create an instance of Profesor
        Profesor profesor = new Profesor();

        // Set ID for the professor
        profesor.setId(1);

        // Test the getId() method
        assertEquals(1, profesor.getId());
    }


    @Test
    public void testGetDni() {
        // Create an instance of Profesor
        Profesor profesor = new Profesor();

        // Set DNI for the professor
        profesor.setDni("12345678A");

        // Test the getDni() method
        assertEquals("12345678A", profesor.getDni());
    }

    @Test
    public void testGetNombre() {
        // Create an instance of Profesor
        Profesor profesor = new Profesor();

        // Set the nombre for the professor
        profesor.setNombre("John");

        // Test the getNombre() method
        assertEquals("John", profesor.getNombre());
    }


    @Test
    public void testGetApellido() {
        // Create an instance of Profesor
        Profesor profesor = new Profesor();

        // Set the apellido for the professor
        profesor.setApellido("Perez");

        // Test the getApellido() method
        assertEquals("Perez", profesor.getApellido());
    }

}
