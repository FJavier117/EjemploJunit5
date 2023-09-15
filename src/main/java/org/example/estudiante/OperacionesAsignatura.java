package org.example.estudiante;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class OperacionesAsignatura {

    private final List<Calificacion> calificacionList;

    {
        calificacionList = new ArrayList<>();
    }

    public void addCal(String alumno, Asignatura asignatura, double cal) {
        calificacionList.add(new Calificacion(alumno, asignatura, cal));
    }

    public Calificacion getCalificacion(String alumno, String nombreAsignatura) {
        Calificacion calificacion = null;
        for (Calificacion cal : calificacionList) {
            if (alumno.equals(cal.alumno()) && nombreAsignatura.equals(cal.asignatura().nobre())) {
                calificacion = cal;
            }
        }
        return calificacion;
    }

    public List<Calificacion> getAllCalificacionList(String alumno) {
        List<Calificacion> list = new ArrayList<>();
        for (Calificacion cal : calificacionList) {
            if (alumno.equals(cal.alumno())) {
                list.add(cal);
            }
        }
        return list;
    }

    public List<Calificacion> getAllCalificacionList() {
        return calificacionList;
    }


    public Double promedio(String alumno) {
        Vector<Double> listProm = new Vector<>();
        for (Calificacion cal : calificacionList) {
            if (alumno.equals(cal.alumno())) {
                listProm.add(cal.calificacion());
            }
        }
        return calcular(listProm);
    }

    public Double promedio() {
        Vector<Double> listProm = new Vector<>();
        for (Calificacion cal : calificacionList) {
            listProm.add(cal.calificacion());
        }
        return calcular(listProm);
    }


    private Double calcular(Vector<Double> listProm) {
        Double prom = 0.0;
        for (Double val : listProm) {
            prom += val;
        }
        return redondeo(prom / listProm.size());
    }

    private Double redondeo(Double valor) {
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.FLOOR);
        //DecimalFormat decimalFormat = new DecimalFormat("###.##");
        // decimalFormat.format(valor);
        return bd.doubleValue();
    }


}
