package org.example;

import org.example.estudiante.Asignatura;
import org.example.estudiante.OperacionesAsignatura;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        OperacionesAsignatura operacionesAsignatura = new OperacionesAsignatura();
        operacionesAsignatura.addCal("Maria",new Asignatura("Física",8),6.0);
        operacionesAsignatura.addCal("Maria",new Asignatura("Química",8),6.0);
        operacionesAsignatura.addCal("Maria",new Asignatura("Programación",8),6.0);

        operacionesAsignatura.addCal("Javier",new Asignatura("Física",8),5.0);
        operacionesAsignatura.addCal("Javier",new Asignatura("Química",8),5.0);
        operacionesAsignatura.addCal("Javier",new Asignatura("Programación",8),5.0);

        operacionesAsignatura.addCal("Antonio",new Asignatura("Física",8),7.5);
        operacionesAsignatura.addCal("Antonio",new Asignatura("Química",8),8.9);
        operacionesAsignatura.addCal("Antonio",new Asignatura("Programación",8),9.0);

        operacionesAsignatura.addCal("Perla",new Asignatura("Física",8),10.0);
        operacionesAsignatura.addCal("Perla",new Asignatura("Química",8),6.5);
        operacionesAsignatura.addCal("Perla",new Asignatura("Programación",8),8.0);

        System.out.println(operacionesAsignatura.getCalificacion("Maria","Química"));
        System.out.println(operacionesAsignatura.getCalificacion("Perla","Física"));
        System.out.println("Información por alumno: " + operacionesAsignatura.getAllCalificacionList("Antonio"));
        System.out.println("Información de todos los alumnos: " +operacionesAsignatura.getAllCalificacionList());
        System.out.println("Promedio por alumno: " + operacionesAsignatura.promedio("Javier"));
        System.out.println("Promedio por de todos: " +operacionesAsignatura.promedio());
        EjemploTest ejemploTest = new EjemploTest();
        System.out.println(ejemploTest.evaluarPrimo(2));

    }
}