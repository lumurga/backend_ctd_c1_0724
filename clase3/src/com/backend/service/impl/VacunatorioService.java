package com.backend.service.impl;

import com.backend.model.Persona;
import com.backend.service.Vacunatorio;

public class VacunatorioService implements Vacunatorio {
    @Override
    public String vacunar(Persona persona) {
        System.out.println("Admision de " + persona.getNombreCompleto());

        return "Se ha registrado a la persona con DNI " + persona.getDni() + ", fue vacunada con " + persona.getVacuna();
    }
}
