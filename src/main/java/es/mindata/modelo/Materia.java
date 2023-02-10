package es.mindata.modelo;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Materia.
 */
public final class Materia implements Comparable<Materia> {

    private final String nombre;
    private final Float calificacion;

    /**
     * Crea una nueva instancia de Materia.
     * 
     * @param nombre       el nombre de la materia
     * @param calificacion la calificación
     */
    public Materia(final String nombre, final Float calificacion) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        if (calificacion == null) {
            throw new NullPointerException("La calificación no puede ser nula.");
        }
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    /**
     * Retorna el nombre de la materia.
     * 
     * @return el nombre de la materia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la calificación.
     * 
     * @return la calificación
     */
    public Float getCalificacion() {
        return calificacion;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Materia)) {
            return false;
        }
        Materia castOther = (Materia) other;
        return new EqualsBuilder()
                .append(this.getNombre(), castOther.getNombre()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getNombre()).toHashCode();
    }

    @Override
    public int compareTo(Materia other) {
        return new CompareToBuilder()
                .append(getNombre(), other.getNombre()).toComparison();
    }
}
