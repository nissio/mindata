package es.mindata.modelo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Materia.
 */
public class MateriaTest {

    private static String nombre;
    private static Float calificacion;
    private static Materia materia;

    @BeforeAll
    public static void beforeAll() {
        nombre = "Materia A";
        calificacion = (float) 9;
        materia = new Materia(nombre, calificacion);
    }

    @Test
    public void parametrosOk() {
        assertAll(
                "Propiedades de la materia",
                () -> assertEquals(nombre, materia.getNombre()),
                () -> assertEquals(calificacion, materia.getCalificacion()));
    }

}
