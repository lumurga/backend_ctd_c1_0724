package com.backend.clinica.dto.salida;

import java.time.LocalDate;

public class PacienteSalidaDto {
    private Long id;

    private String nombre;

    private String apellido;

    private int dni;
    private LocalDate fechaIngreso;
    private DomicilioSalidaDto domicilioSalidaDto;

    public PacienteSalidaDto() {
    }

    public PacienteSalidaDto(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioSalidaDto domicilioSalidaDto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioSalidaDto = domicilioSalidaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioSalidaDto getDomicilioSalidaDto() {
        return domicilioSalidaDto;
    }

    public void setDomicilioSalidaDto(DomicilioSalidaDto domicilioSalidaDto) {
        this.domicilioSalidaDto = domicilioSalidaDto;
    }
}
