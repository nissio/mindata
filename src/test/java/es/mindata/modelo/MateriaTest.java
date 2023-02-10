package es.mindata.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Materia.
 */
public class MateriaTest {

    private String nombre;
    private Float calificacion;
    private Materia materia;

    @Before
    public void before() {
        this.nombre = "Materia A";
        this.calificacion = (float) 9;
        this.materia = new Materia(nombre, calificacion);
    }

    @Test
    public void nombreOk() {
        assertEquals(this.materia.getNombre(), nombre);
    }

    @Test
    public void calificacionOk() {
        assertEquals(this.materia.getCalificacion(), calificacion);
    }

}
