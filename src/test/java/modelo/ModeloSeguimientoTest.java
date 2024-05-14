package modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ModeloSeguimientoTest {

    @Test
    public void testGetAll() {
        // Mock de ModeloSeguimiento
        ModeloSeguimiento modeloSeguimientoMock = mock(ModeloSeguimiento.class);
        
        // Configurar mock
        ArrayList<Seguimiento> seguimientosSimulados = new ArrayList<>();
        when(modeloSeguimientoMock.getAll()).thenReturn(seguimientosSimulados);
        
        // Llamar al método 
        ArrayList<Seguimiento> seguimientos = modeloSeguimientoMock.getAll();
        
        // Verificar resultado
        assertNotNull(seguimientos);
    }

    @Test
    public void testInsert() {
        // Mock de ModeloSeguimiento
        ModeloSeguimiento modeloSeguimientoMock = mock(ModeloSeguimiento.class);
        
        // Crear seguimiento simulado
        Seguimiento seguimiento = new Seguimiento();
        Alumno alumno = new Alumno();
        seguimiento.setFaltas(77);
        seguimiento.setNota(8);
        seguimiento.setParticipacion("Baja");
        seguimiento.setRendimiento("Alto");
        alumno.setId(28);
        alumno.setNombre("Jesus");
        seguimiento.setAlumno(alumno);
        
        // Llamar al método bajo prueba
        modeloSeguimientoMock.insert(seguimiento);
        
        // Verificar que se llamó al método insert correctamente
        verify(modeloSeguimientoMock, times(1)).insert(seguimiento);
    }

    @Test
    public void testDelete() {
        // Mock de ModeloSeguimiento
        ModeloSeguimiento modeloSeguimientoMock = mock(ModeloSeguimiento.class);
        
        // Obtener la lista de seguimientos antes del delete
        ArrayList<Seguimiento> seguimientos = new ArrayList<>();
        when(modeloSeguimientoMock.getAll()).thenReturn(seguimientos);
        int numeroSeguimientos = seguimientos.size();
        
        // Ejecutar delete
        modeloSeguimientoMock.delete(28);
        
        //Comprobar que ha deleteado
        verify(modeloSeguimientoMock, times(1)).delete(28);
    }

    @Test
    public void testUpdate() {
      
        ModeloSeguimiento modeloSeguimientoMock = mock(ModeloSeguimiento.class);
        
        // Asignar valores
        Seguimiento seguimiento = new Seguimiento();
        Alumno alumno = new Alumno();
        seguimiento.setFaltas(33);
        seguimiento.setNota(3);
        seguimiento.setParticipacion("Alta");
        seguimiento.setRendimiento("Sobresaliente");
        alumno.setId(50);
        alumno.setNombre("Judas");
        seguimiento.setAlumno(alumno);
        
        // Configurar  mock
        when(modeloSeguimientoMock.update(seguimiento)).thenReturn(1);
        
        // Ejecutar update
        int rowsAffected = modeloSeguimientoMock.update(seguimiento);
        
        // Comprobar resultado
        assertEquals(1, rowsAffected);
    }
}
