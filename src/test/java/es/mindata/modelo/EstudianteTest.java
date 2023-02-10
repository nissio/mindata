package es.mindata.modelo;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Estudiante.
 */
public class EstudianteTest {

    private String nombre;
    private Integer edad;
    private Fecha fechaFinalizacion;
    private List<Materia> materiasCursadas;
    private Materia materia1;
    private Materia materia2;
    private Estudiante estudiante;

    @Before
    public void before() {
        this.nombre = "Estudiante A";
        this.edad = 18;
        this.fechaFinalizacion = new Fecha(LocalDate.now());
        this.materiasCursadas = new ArrayList<>();
        this.materia1 = new Materia("Materia 1", (float) 9.5);
        this.materiasCursadas.add(materia1);
        this.materia2 = new Materia("Materia 2", (float) 8);
        this.materiasCursadas.add(materia2);
        estudiante = Estudiante.builder().nombre(nombre).edad(edad).fechaFinalizacion(fechaFinalizacion)
                .materiasCursadas(materiasCursadas)
                .build();
    }

    @Test
    public void nombreOk() {
        assertEquals(this.estudiante.getNombre(), this.nombre);
    }

    @Test
    public void edadOk() {
        assertEquals(this.estudiante.getEdad(), this.edad);
    }

    @Test
    public void fechaFinalizacionOk() {
        assertEquals(this.estudiante.getFechaFinalizacion(), this.fechaFinalizacion);
    }

    @Test
    public void materiasCursadasOk() {
        assertEquals(this.estudiante.getMateriasCursadas(), this.materiasCursadas);
    }

    @Test
    public void materiasCursadasInmutableOk() {
        this.estudiante.getMateriasCursadas().remove(materia1);
        assertEquals(this.estudiante.getMateriasCursadas(), this.materiasCursadas);
    }

}
