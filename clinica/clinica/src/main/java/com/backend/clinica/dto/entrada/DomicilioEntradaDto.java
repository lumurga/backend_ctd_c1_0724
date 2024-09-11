package com.backend.clinica.dto.entrada;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Schema(description = "Estructura de datos de entrada que se corresponden con el domicilio del paciente")
public class DomicilioEntradaDto {

    @NotBlank(message = "Debe especificarse el nombre de la calle")
    @Size(min = 1, max = 30, message = "La calle debe tener entre 1 y 30 caracteres")
    private String calle;
    @Positive(message = "El numero de calle no puede ser nulo ni menor a cero")
    @Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
    private int numero;
    @NotBlank(message = "Debe especificarse el nombre de la localidad")
    @Size(min = 1, max = 30, message = "La localidad debe tener entre 1 y 30 caracteres")
    private String localidad;
    @NotBlank(message = "Debe especificarse el nombre de la provincia")
    @Size(min = 1, max = 30, message = "La provincia debe tener entre 1 y 30 caracteres")
    @Schema(description = "Provincia a la que pertenece el domicilio. Opciones: COR - BA - MEN")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
