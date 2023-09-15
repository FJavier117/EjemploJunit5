package org.example;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public enum Tiempo implements TemporalUnit {
    SEGUNDOS("SEGUNDOS", Duration.ofSeconds(1)),
    MINUTOS("MINUTOS",Duration.ofSeconds(60)),
    HORAS("HORAS",Duration.ofSeconds(3600)),
    DIAS("DIAS",Duration.ofSeconds(86400));

    Tiempo(String unidad, Duration tiempo) {
        this.unidad = unidad;
        this.tiempo = tiempo;
    }

    private final String unidad;
    private final Duration tiempo;

    public String getUnidad() {
        return unidad;
    }

    public Duration getTiempo() {
        return tiempo;
    }

    @Override
    public Duration getDuration() {
        return null;
    }

    @Override
    public boolean isDurationEstimated() {
        return false;
    }

    @Override
    public boolean isDateBased() {
        return false;
    }

    @Override
    public boolean isTimeBased() {
        return false;
    }

    @Override
    public <R extends Temporal> R addTo(R temporal, long amount) {
        return null;
    }

    @Override
    public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
        return 0;
    }
}
