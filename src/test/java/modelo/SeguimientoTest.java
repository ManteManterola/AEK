package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SeguimientoTest {

    @Test
    public void testGetNota() {
    
        Seguimiento seguimiento = new Seguimiento();

        
        seguimiento.setNota(80);

       
        assertEquals(80, seguimiento.getNota());
    }

    @Test
    public void testGetFaltas() {
   
        Seguimiento seguimiento = new Seguimiento();

        
        seguimiento.setFaltas(33);

      
        assertEquals(33, seguimiento.getFaltas());
    }

    @Test
    public void testGetParticipacion() {
        
        Seguimiento seguimiento = new Seguimiento();

        
        seguimiento.setParticipacion("Buena");

       
        assertEquals("Buena", seguimiento.getParticipacion());
    }

    @Test
    public void testGetRendimiento() {
      
        Seguimiento seguimiento = new Seguimiento();

        
        seguimiento.setRendimiento("Malo");

       
        assertEquals("Malo", seguimiento.getRendimiento());
    }

    @Test
    public void testGetAlumno() {
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Mante");

       
        Seguimiento seguimiento = new Seguimiento();

        
        seguimiento.setAlumno(alumno);

        
        assertEquals("Mante", seguimiento.getAlumno().getNombre());
    }
}

