package es.mindata.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Fecha.
 */
public class FechaTest {

    private static LocalDate localDate;
    private static Fecha fecha;
    private static String diaMes;

    @BeforeAll
    public static void before() {
        localDate = LocalDate.now();
        fecha = new Fecha(localDate);
        diaMes = localDate.getMonthValue() + "/" + localDate.getDayOfMonth();
    }

    @Test
    public void diaMesFechaOk() {
        assertEquals(diaMes, fecha.getDiaMes());
    }

}
