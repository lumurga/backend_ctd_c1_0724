package com.backend.service;

import com.backend.model.Persona;

import java.util.List;

public class GrupoService {

    private List<Persona> personas; //= new ArrayList<>();

    public GrupoService(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }


    public void admitirPersona(Persona persona){

        boolean cumpleCondiciones = persona.getNombre().length() >= 5 && persona.getNombre().matches("[a-zA-Z ]+") && persona.getEdad() > 18 && persona.getEdad() < 100;

        if(cumpleCondiciones) personas.add(persona);
        else System.out.println("No es posible admitir a " + persona.getNombre() + " al grupo.");

    }

}
