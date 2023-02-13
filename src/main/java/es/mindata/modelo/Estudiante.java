package es.mindata.modelo;

import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Estudiante.
 */
public final class Estudiante implements Comparable<Estudiante> {

    private final String nombre;
    private final Integer edad;
    private final Fecha fechaFinalizacion;
    private final List<Materia> materiasCursadas;

    /**
     * Crea una nueva instancia de Estudiante.
     * 
     * @param nombre            el nombre del estudiante
     * @param edad              la edad
     * @param fechaFinalizacion la fecha de finalización
     * @param materiasCursadas  las materias cursadas
     */
    private Estudiante(String nombre,
            Integer edad,
            Fecha fechaFinalizacion,
            List<Materia> materiasCursadas) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        if (edad == null) {
            throw new NullPointerException("La edad no puede ser nula.");
        }
        if (edad <= 0) {
            throw new IllegalStateException("La edad debe ser mayor que cero.");
        }
        if (fechaFinalizacion == null) {
            throw new NullPointerException("La fecha de finalización no puede ser nula.");
        }
        if (materiasCursadas == null) {
            throw new NullPointerException("Las colección de materias cursadas no puede ser nula.");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.fechaFinalizacion = fechaFinalizacion;
        this.materiasCursadas = Collections.unmodifiableList(materiasCursadas);
    }

    /**
     * Crea una instancia de Estudiante.
     * 
     * @param builder el builder
     */
    private Estudiante(EstudianteBuilder builder) {
        this(builder.getNombre(), builder.getEdad(), builder.getFechaFinalizacion(), builder.getMateriasCursadas());
    }

    /**
     * Retorna el nombre del estudiante.
     * 
     * @return el nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la edad.
     * 
     * @return la edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Retorna la fecha de finalización.
     * 
     * @return la fecha de finalización
     */
    public Fecha getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    /**
     * Retorna la lista de materias cursadas.
     * 
     * @return la lista de materias cursadas
     */
    public List<Materia> getMateriasCursadas() {
        return materiasCursadas;
    }

    /**
     * Rertorna el builder de estudiantes.
     * 
     * @return el builder de estudiantes
     */
    public static EstudianteBuilder builder() {
        return new EstudianteBuilder();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Estudiante)) {
            return false;
        }
        Estudiante castOther = (Estudiante) other;
        return new EqualsBuilder().append(this.getNombre(), castOther.getNombre()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getNombre()).toHashCode();
    }

    @Override
    public int compareTo(Estudiante other) {
        return new CompareToBuilder().append(getNombre(), other.getNombre())
                .toComparison();
    }

    /**
     * Builder de Estudiante.
     */
    public static final class EstudianteBuilder {
        private String nombre;
        private Integer edad;
        private Fecha fechaFinalizacion;
        private List<Materia> materiasCursadas;

        private EstudianteBuilder() {
        }

        private String getNombre() {
            return nombre;
        }

        public EstudianteBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        private Integer getEdad() {
            return edad;
        }

        public EstudianteBuilder edad(Integer edad) {
            this.edad = edad;
            return this;
        }

        private Fecha getFechaFinalizacion() {
            return fechaFinalizacion;
        }

        public EstudianteBuilder fechaFinalizacion(Fecha fechaFinalizacion) {
            this.fechaFinalizacion = fechaFinalizacion;
            return this;
        }

        private List<Materia> getMateriasCursadas() {
            return materiasCursadas;
        }

        public EstudianteBuilder materiasCursadas(List<Materia> materiasCursadas) {
            this.materiasCursadas = materiasCursadas;
            return this;
        }

        public Estudiante build() {
            Estudiante estudiante = new Estudiante(this);
            return estudiante;
        }

    }
}
