package org.example.estudiante;

public record Calificacion(String alumno, Asignatura asignatura, double calificacion) {
    @Override
    public String toString() {
        return "Calificacion{" +
                "alumno='" + alumno + '\'' +
                ", asignatura=" + asignatura +
                ", calificacion=" + calificacion +
                '}';
    }
}
