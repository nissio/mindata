package es.mindata.modelo;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Fecha.
 */
public class FechaTest {

    private LocalDate localDate;
    private Fecha fecha;
    private String diaMes;

    @Before
    public void before() {
        this.localDate = LocalDate.now();
        this.fecha = new Fecha(localDate);
        diaMes = this.localDate.getMonthValue() + "/" + this.localDate.getDayOfMonth();
    }

    @Test
    public void diaMesFechaOk() {
        assertEquals(this.fecha.getDiaMes(), diaMes);
    }

    @Test
    public void diaMesFechaFechaInmutableOk() {
        this.localDate = this.localDate.plusDays(10);
        assertEquals(this.fecha.getDiaMes(), diaMes);
    }

}
