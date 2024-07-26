package com.backend.model;

import java.time.LocalDate;

public class Persona {

    private String nombreCompleto;
    private String dni;
    private String vacuna;
    private LocalDate fechaAsignada;

    //atl+insert
    public Persona(String nombreCompleto, String dni, String vacuna, LocalDate fechaAsignada) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.vacuna = vacuna;
        this.fechaAsignada = fechaAsignada;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }
}
