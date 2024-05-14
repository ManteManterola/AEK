package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProgramaTest {

    @Test
    public void testGetContenido() {
        // Arrange
        Programa programa = new Programa();
        programa.setContenido("Contenido de ejemplo");
        
        // Act
        String contenido = programa.getContenido();
        
        // Assert
        assertEquals("Contenido de ejemplo", contenido);
    }

    @Test
    public void testGetCriterioEvaluacion() {
        // Arrange
        Programa programa = new Programa();
        programa.setCriterioEvaluacion("Criterio de evaluación de ejemplo");
        
        // Act
        String criterio = programa.getCriterioEvaluacion();
        
        // Assert
        assertEquals("Criterio de evaluación de ejemplo", criterio);
    }

    @Test
    public void testGetCurso() {
        // Arrange
        Curso curso = new Curso();
        Programa programa = new Programa();
        programa.setCurso(curso);
        
        // Act
        Curso cursoObtenido = programa.getCurso();
        
        // Assert
        assertEquals(curso, cursoObtenido);
    }

    @Test
    public void testSetContenido() {
        // Arrange
        Programa programa = new Programa();
        
        // Act
        programa.setContenido("Nuevo contenido");
        
        // Assert
        assertEquals("Nuevo contenido", programa.getContenido());
    }

    @Test
    public void testSetCriterioEvaluacion() {
        // Arrange
        Programa programa = new Programa();
        
        // Act
        programa.setCriterioEvaluacion("Nuevo criterio de evaluación");
        
        // Assert
        assertEquals("Nuevo criterio de evaluación", programa.getCriterioEvaluacion());
    }

    @Test
    public void testSetCurso() {
        // Arrange
        Curso curso = new Curso();
        Programa programa = new Programa();
        
        // Act
        programa.setCurso(curso);
        
        // Assert
        assertEquals(curso, programa.getCurso());
    }
}

