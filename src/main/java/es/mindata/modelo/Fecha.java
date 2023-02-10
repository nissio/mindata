package es.mindata.modelo;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Fecha.
 */
public final class Fecha implements Comparable<Fecha> {

    private final LocalDate fecha;

    /**
     * Crea una nueva instancia de Fecha.
     * 
     * @param fecha la fecha
     */
    public Fecha(LocalDate fecha) {
        if (fecha == null) {
            throw new NullPointerException("La fecha no puede ser nula.");
        }
        this.fecha = fecha;
    }

    /**
     * Retorna la fecha.
     * 
     * @return la fecha
     */
    private LocalDate getFecha() {
        return fecha;
    }

    /**
     * Retorna el día y mes de la fecha.
     * 
     * @return el día y mes de la fecha
     */
    public String getDiaMes() {
        return getFecha().getMonthValue() + "/" + getFecha().getDayOfMonth();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Fecha)) {
            return false;
        }
        Fecha castOther = (Fecha) other;
        return new EqualsBuilder().append(this.getFecha(), castOther.getFecha()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getFecha()).toHashCode();
    }

    @Override
    public int compareTo(Fecha other) {
        return new CompareToBuilder().append(getFecha(), other.getFecha())
                .toComparison();
    }
}
