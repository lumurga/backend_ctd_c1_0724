package com.backend.service.impl;

import com.backend.model.Persona;
import com.backend.service.Vacunatorio;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio {


    private VacunatorioService vacunatorioService;


    @Override
    public String vacunar(Persona persona) {

        //CONTROLAR FECHA
        String respuesta = "La fecha no se corresponde con la fecha asignada";
        if(validarFecha(persona.getFechaAsignada())){
            vacunatorioService = new VacunatorioService();
            respuesta = vacunatorioService.vacunar(persona);
        }

        return respuesta;
    }

    private boolean validarFecha(LocalDate fechaAsignada){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaAsignada);
    }

}
