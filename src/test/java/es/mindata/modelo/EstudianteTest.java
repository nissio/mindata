package es.mindata.modelo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Estudiante.
 */
public class EstudianteTest {

    private static String nombre;
    private static Integer edad;
    private static Fecha fechaFinalizacion;
    private static List<Materia> materiasCursadas;
    private static Materia materia1;
    private static Materia materia2;
    private static Estudiante estudiante;

    @BeforeAll
    public static void beforeAll() {
        nombre = "Estudiante A";
        edad = 18;
        fechaFinalizacion = new Fecha(LocalDate.now());
        materiasCursadas = new ArrayList<>();
        materia1 = new Materia("Materia 1", (float) 9.5);
        materiasCursadas.add(materia1);
        materia2 = new Materia("Materia 2", (float) 8);
        materiasCursadas.add(materia2);
        estudiante = Estudiante.builder().nombre(nombre).edad(edad).fechaFinalizacion(fechaFinalizacion)
                .materiasCursadas(materiasCursadas)
                .build();
    }

    @Test
    public void parametrosOk() {
        assertAll(
                "Propiedades del estudiante",
                () -> assertEquals(nombre, estudiante.getNombre()),
                () -> assertEquals(edad, estudiante.getEdad()),
                () -> assertEquals(fechaFinalizacion, estudiante.getFechaFinalizacion()),
                () -> assertEquals(materiasCursadas, estudiante.getMateriasCursadas()));
    }

    @Test
    public void modificacionMateriasCursadasInmutableThrowExceptionOk() {
        assertThrows(UnsupportedOperationException.class, () -> {
            estudiante.getMateriasCursadas().remove(materia1);
        });
    }

}
