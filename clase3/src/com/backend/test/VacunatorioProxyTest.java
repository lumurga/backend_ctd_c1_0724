package com.backend.test;

import com.backend.model.Persona;
import com.backend.service.impl.VacunatorioProxy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioProxyTest {


    private final VacunatorioProxy PROXY = new VacunatorioProxy();


    @Test
    void siConcurreUnDiaAntes_laPersonaNoDeberiaSerVacunada(){
        //arrange
        Persona persona = new Persona("Cristian Ovalles", "3654646", "Anti Gripal", LocalDate.now().plusDays(1));

        String respuestaEsperada = "La fecha no se corresponde con la fecha asignada";

        //act
        String respuestaObtenida = PROXY.vacunar(persona);

        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

}